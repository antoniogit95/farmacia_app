import React, { useState } from "react";
import "./TablesReportVentas.css"
import { URL_API_private } from "../../../providerContext/EndPoint";
import { toast, ToastContainer } from "react-toastify";
import axios from "axios";
import { DetailShopModal } from "../../Modals/modalDetailShop/DetailShopModal";

export const TablesReportVentas = () => {
    const [dateInit, setDateInit] = useState("");
    const [dateFin, setDateFin] = useState("");
    const [datos, setDatos] = useState([]);
    const [loading , setLoading] = useState(false);
    const [totalVendido, setTotalVendido] = useState (0);
    const [showModal, setShowModal] = useState(false);
    const [itemSelect, setItemSelect] = useState([]);

    const endPoint = URL_API_private + "/sale/reports"
    const token = JSON.parse(localStorage.getItem('user_data')).accessToken;


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
            setDatos(response.data);
            generarTotal(response.data);
        } catch (error) {
            console.error("error al cargar: ", error)
            toast.error("error al recuperar los datos")
        } finally {
            setLoading(false)
        }
    }

    const generarTotal = (ventas) => {
        const total = ventas.reduce(
            (acc, venta) => acc + Number(venta.subTotal),
            0
        );
        setTotalVendido(total);
    };

    const handleClickModal = (item) => {
        setItemSelect(item);
        setShowModal(true);
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
                <div className="styleContentTable">
                    <table className="styleTable">
                        <thead className="stylesHead">
                            <tr>
                                <th className="stylesTh-Td">ID</th>
                                <th className="stylesTh-Td">Descripcion</th>
                                <th className="stylesTh-Td">Cliente</th>
                                <th className="stylesTh-Td">Total</th>
                                <th className="stylesTh-Td">Fecha</th>
                                <th className="stylesTh-Td">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            {datos.map((v) => (
                                <tr className="stylesTr" key={v.id}>
                                    <td className="stylesTh-Td">{v.id}</td>
                                    <td className="stylesTh-Td">{v.description}</td>
                                    <td className="stylesTh-Td">{v.client?.companyName}</td>
                                    <td className="stylesTh-Td">{v.subTotal.toFixed(2)} bs</td>
                                    <td className="stylesTh-Td">{new Date(v.updatedAt).toLocaleString()}</td>
                                    <div className="stylesContentButtonTable">
                                        <button className="stylesButoonLogin" onClick={() => handleClickModal(v)}>Ver detalle</button>
                                    </div>
                                    
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            )}
        </div>
        <div>
            <h4>Total Vendido</h4>
            <strong>{totalVendido.toFixed(2)} bs</strong>
        </div>
        <ToastContainer />
        <DetailShopModal
            show={showModal}
            onHide={() => setShowModal(false)}
            cart={itemSelect}
        />
    </>);
}