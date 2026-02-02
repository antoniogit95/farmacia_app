import React, { useEffect, useState } from "react";
import "./DetailShopModal.css";
import { Modal } from "react-bootstrap";
import { URL_API_private } from "../../../providerContext/EndPoint";
import axios from "axios";

export const DetailShopModal = ({show, onHide, cart}) =>{

    const personData = localStorage.getItem('user_data');
    const token = JSON.parse(personData).token;
    const endPoint = URL_API_private+"/saledetail/saleid/";
    const [data, setData] = useState([]);

    const config = {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    };

    useEffect(() => {

        if (!show || !cart?.id) return; 

        const fetchData = async () => {
            try {
                const response = await axios.get(
                    endPoint + cart.id,
                    config
                );
                setData(response.data);
            } catch (error) {
                console.error("Error cargando detalle", error);
            }
        };

        fetchData();

    }, [show, cart?.id]);

    const formatDate = (date) => {
        const d = new Date(date);
        const day = String(d.getDate()).padStart(2, "0");
        const month = String(d.getMonth() + 1).padStart(2, "0");
        const year = d.getFullYear();
        const hours = String(d.getHours()).padStart(2, "0");
        const minutes = String(d.getMinutes()).padStart(2, "0");
        const second = String(d.getSeconds()).padStart(2,"0");

        return `${day}/${month}/${year} ${hours}:${minutes}:${minutes}`;
    };
    return(<>
        <Modal 
            show={show} 
            onHide={onHide} 
            centered
            size="xl"
            scrollable>
            <Modal.Header closeButton className="modalHeader">
                <Modal.Title>Detalle de Venta</Modal.Title>
            </Modal.Header>
            <Modal.Body className="modalBody">
                <div>
                    <div>
                        <strong> cliente: </strong>
                        <laver> {  cart.client?.nit + '-->'}  </laver>
                        <laver> {  cart.client?.companyName}</laver>
                    </div>
                    <div>
                        <strong> Farmaceutico: </strong>
                        <laver> {"dra. " + cart.user?.person.name}  </laver>
                    </div>
                    <br />
                    <div className="styleContentTable">      
                        <table className="styleTableModal">
                            <thead className="stylesHead">
                                <tr>
                                    <th className="stylesTh-Td">Medicamento</th>
                                    <th className="stylesTh-Td">Cantidad</th>
                                    <th className="stylesTh-Td">Descuento</th>
                                    <th className="stylesTh-Td">sub total</th>
                                    <th className="stylesTh-Td">Lote</th>
                                    <th className="stylesTh-Td">Fecha</th>
                                </tr>
                            </thead>
                            <tbody className="stylesBody">
                                {data.map(d => (
                                    <tr className="stylesTr" key={d.id}>
                                        <td className="stylesTh-Td">{d.lote?.medicament.comercialName}</td>
                                        <td className="stylesTh-Td">{d.quantity}</td>
                                        <td className="stylesTh-Td">{d.discount.toFixed(2)} bs</td>
                                        <td className="stylesTh-Td">{d.subTotal.toFixed(2)} bs</td>
                                        <td className="stylesTh-Td">{d.lote.lotNomber}</td>
                                        <td className="stylesTh-Td">{formatDate(d.createdAt)}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>

                    </div>
                </div>
            </Modal.Body>
        </Modal>
    </>);
}
