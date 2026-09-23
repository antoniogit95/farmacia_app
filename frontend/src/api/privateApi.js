import axios from "axios";
import { URL_API_private } from "../providerContext/EndPoint";

const privateApi = axios.create({

    baseURL: URL_API_private,

    headers:{

        "Content-Type":"application/json"

    },

    timeout:10000

});

privateApi.interceptors.request.use(

    (config)=>{

        const user=JSON.parse(localStorage.getItem("user_data"));

        if(user?.accessToken){

            config.headers.Authorization=
                `Bearer ${user.accessToken}`;

        }

        return config;

    },

    (error)=>Promise.reject(error)

);

privateApi.interceptors.response.use(

    (response)=>response,

    (error)=>{

        if(error.response?.status===401){

            localStorage.removeItem("user_data");

            window.location.href="/";

        }

        return Promise.reject(error);

    }

);

export default privateApi;