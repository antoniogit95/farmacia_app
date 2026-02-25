import React, { useContext, useState, createContext, useEffect, useRef } from "react";
import axios from "axios";
import { URL_API_private, URL_API_public } from "./EndPoint";

const AuthContext = createContext({
    isAuthenticated: false,
    getAccessToken: () => {},
    saveToken: (token) => {},
    deletToken: () => {},
});

export const AuthProvider = ({ children }) => {

    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [accessToken, setAccessToken] = useState("");
    const [timeOut, setTimeOut] = useState(null);

    const endPointRefresh = URL_API_public + "/refresh";
    const endPointClose = URL_API_private + "/cesion/close";

    const INACTIVITY_TIMEOUT = 31 * 60 * 1000; // 31 min
    const REFRESH_INTERVAL = 10 * 60 * 1000;   // 10 min

    const lastRefreshTime = useRef(Date.now());
    const inactivityTimer = useRef(null);

    function getAccessToken() {
        return accessToken;
    }

    // =============================
    // LOGOUT
    // =============================
    const handleLogout = () => {
        setAccessToken("");
        localStorage.removeItem("user_data");
        setIsAuthenticated(false);
        console.log("Sesión cerrada");
    };

    function deletToken() {
        cerrarSesion();
        handleLogout();
    }

    const cerrarSesion = async () => {
        try {
            const data = JSON.parse(localStorage.getItem("user_data"));
            if (!data) return;

            await axios.post(
                endPointClose,
                {
                    username: data.username,
                    password: "---------",
                },
                {
                    headers: {
                        Authorization: `Bearer ${data.accessToken}`,
                    },
                }
            );

            console.log("Sesión cerrada en backend");
        } catch (e) {
            console.error(e);
        }
    };

    // =============================
    // PARSE JWT
    // =============================
    function parseJwt(token) {
        try {
            const base64Url = token.split(".")[1];
            const base64 = base64Url.replace(/-/g, "+").replace(/_/g, "/");
            const jsonPayload = decodeURIComponent(
                atob(base64)
                    .split("")
                    .map((c) => "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2))
                    .join("")
            );
            return JSON.parse(jsonPayload);
        } catch (e) {
            return null;
        }
    }

    // =============================
    // SAVE TOKEN
    // =============================
    function saveToken(accessToken, refreshToken) {
        const decoded = parseJwt(accessToken);
        console.log(decoded)
        if (!decoded) {
            handleLogout();
            //return;
        }

        const expirationDate = new Date(decoded.exp * 1000);

        localStorage.setItem(
            "user_data",
            JSON.stringify({
                accessToken,
                refreshToken,
                username: decoded.sub,
                role: decoded.role,
            })
        );

        setAccessToken(accessToken);
        setIsAuthenticated(true);
        setTimeOut(expirationDate);
    }

    // =============================
    // VALIDAR TOKEN AL INICIAR 🔥
    // =============================
    useEffect(() => {
        const storedData = localStorage.getItem("user_data");

        if (!storedData) return;

        const data = JSON.parse(storedData);

        if (!data.accessToken) {
            handleLogout();
            return;
        }

        const decoded = parseJwt(data.accessToken);

        if (!decoded) {
            handleLogout();
            return;
        }

        const expirationDate = new Date(decoded.exp * 1000);

        if (new Date() > expirationDate) {
            console.log("Token expirado al iniciar");
            handleLogout();
        } else {
            console.log("Token válido");
            setAccessToken(data.accessToken);
            setIsAuthenticated(true);
            setTimeOut(expirationDate);
        }
    }, []);

    // =============================
    // VERIFICAR EXPIRACIÓN
    // =============================
    useEffect(() => {
        if (!timeOut) return;

        const interval = setInterval(() => {
            if (new Date() > timeOut) {
                console.log("Token expirado");
                handleLogout();
            }
        }, 5000);

        return () => clearInterval(interval);
    }, [timeOut]);

    // =============================
    // REFRESH TOKEN
    // =============================
    const refreshToken = async () => {
        try {
            const data = JSON.parse(localStorage.getItem("user_data"));
            if (!data || !data.refreshToken) {
                handleLogout();
                return;
            }

            const response = await axios.post(
                endPointRefresh,
                {
                    refreshToken: data.refreshToken
                },
                
            );

            console.log("Token refrescado");

            // guardar nuevos tokens
            saveToken(response.data.accessToken, response.data.refreshToken);

            lastRefreshTime.current = Date.now();

        } catch (error) {
            console.error("Error refresh token", error);
            handleLogout();
        }
    };

    // =============================
    // ACTIVIDAD USUARIO
    // =============================
    useEffect(() => {

        const handleActivity = () => {
            const now = Date.now();

            // refresh cada cierto tiempo
            if (
                isAuthenticated &&
                accessToken &&
                now - lastRefreshTime.current >= REFRESH_INTERVAL
            ) {
                refreshToken();
            }

            resetInactivityTimer();
        };

        const resetInactivityTimer = () => {
            if (inactivityTimer.current) {
                clearTimeout(inactivityTimer.current);
            }

            inactivityTimer.current = setTimeout(() => {
                console.log("Logout por inactividad");
                handleLogout();
            }, INACTIVITY_TIMEOUT);
        };

        document.addEventListener("mousemove", handleActivity);
        document.addEventListener("keydown", handleActivity);

        resetInactivityTimer();

        return () => {
            document.removeEventListener("mousemove", handleActivity);
            document.removeEventListener("keydown", handleActivity);

            if (inactivityTimer.current) {
                clearTimeout(inactivityTimer.current);
            }
        };

    }, [accessToken, isAuthenticated]);

    // =============================
    // AXIOS INTERCEPTOR 🔥
    // =============================
    useEffect(() => {
        const interceptor = axios.interceptors.response.use(
            (response) => response,
            async (error) => {
                const originalRequest = error.config;

                if (error.response?.status === 401 && !originalRequest._retry) {
                    originalRequest._retry = true;

                    try {
                        await refreshToken();

                        const data = JSON.parse(localStorage.getItem("user_data"));

                        originalRequest.headers.Authorization = `Bearer ${data.accessToken}`;

                        return axios(originalRequest);
                    } catch (err) {
                        handleLogout();
                    }
                }

                return Promise.reject(error);
            }
        );

        return () => axios.interceptors.response.eject(interceptor);
    }, []);

    return (
        <AuthContext.Provider value={{ isAuthenticated, getAccessToken, saveToken, deletToken }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);