import React, { useState } from "react";
import "./TablesReportVentas.css"
import { URL_API_private } from "../../../providerContext/EndPoint";
import { toast, ToastContainer } from "react-toastify";
import axios from "axios";

export const TablesReportVentas = () => {
    const [dateInit, setDateInit] = useState("");
    const [dateFin, setDateFin] = useState("");
    const [datos, setDatos] = useState([]);
    const [loading , setLoading] = useState(false);

    const endPoint = URL_API_private + "/sale/reports"
    const token = JSON.parse(localStorage.getItem('user_data')).token;


    const config = {
        headers:{
            Authorization: `Bearer ${token}`,
        }
    }

    const handleClick = async() => {
        
        if (!dateInit || !dateFin) {
            toast.error("debe seleccionar una fecha primero")
            return;
        }

        try {
            const response = await axios.post(endPoint,
                    {
                        start: dateInit,
                        end: dateFin
                    },
                    config
            );
            console.log(response.data);
            setDatos(response.data);
        } catch (error) {
            console.error("error al cargar: ", error)
            toast.error("error al recuperar los datos")
        } finally {
            setLoading(false)
        }
    }


    return(<>
        <h2 className="stylesH2Subtitule">Buscar por interbalo de fechas</h2>
        <div className="stylesContentInput-tre">
            <div className="">
                <label> fecha Inicio</label>
                <input 
                    className="stylesInput"
                    type="date" 
                    value={dateInit}
                    onChange={(e) => setDateInit(e.target.value)}/>
            </div>
            <div>
                <label> fecha Final</label>
                <input 
                    className="stylesInput"
                    type="date" 
                    value={dateFin}
                    onChange={(e) => setDateFin(e.target.value)}/>
            </div>
            <div className="stylesContenedorButton">
                <button className="stylesButoon" onClick={handleClick}>Buscar</button>
            </div>
        </div>
        <h3 className="stylesH2Subtitule">historial de Ventas</h3>
        <div>
            {loading ? (
                <p>Cargando...</p>
            ) : datos.length === 0 ? (
                <p>No hay ventas en este rango</p>
            ) : (
                <table className="stylesTable">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Factura</th>
                            <th>Cliente</th>
                            <th>Total</th>
                            <th>Descuento</th>
                            <th>Fecha</th>
                        </tr>
                    </thead>
                    <tbody>
                        {datos.map((v) => (
                            <tr key={v.id}>
                                <td>{v.id}</td>
                                <td>{v.description}</td>
                                <td>{v.client.companyName}</td>
                                <td>{v.subTotal.toFixed(2)}</td>
                                <td>{v.totalDiscount.toFixed(2)}</td>
                                <td>{new Date(v.updatedAt).toLocaleString()}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            )}
        </div>
        <ToastContainer />
    </>);
}