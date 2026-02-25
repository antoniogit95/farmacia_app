import React, { useEffect, useState } from "react";
import "./DetailShopModal.css";
import { Modal } from "react-bootstrap";
import { URL_API_private } from "../../../providerContext/EndPoint";
import { printFactura } from "../../printer/PrinterFactura";
import axios from "axios";

export const DetailShopModal = ({show, onHide, cart}) =>{

    const personData = localStorage.getItem('user_data');
    const token = JSON.parse(personData).accessToken;
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

        return `${day}/${month}/${year} ${hours}:${minutes}:${second}`;
    };

    const handlePrint = () => {
        if (!data || data.length === 0) {
            alert("No hay datos para imprimir");
            return;
        }

        const items = data.map(d => {
            const unitPrice = d.subTotal / d.quantity; // calculamos precio unitario

            return {
                comercialName: d.lote?.medicament.comercialName,
                quantity: d.quantity,
                unitPrice: unitPrice,
                discount: d.discount,
                subTotal: d.subTotal
            };
        });

        printFactura({
            items,
            nit: cart.client?.nit,
            companyName: cart.client?.companyName
        });
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
                        <div className="headerDetailShop">
                            <div className="left">
                                <div className="row">
                                    <strong>Cliente:</strong>
                                    <span>{cart.client?.nit} --&gt; {cart.client?.companyName}</span>
                                </div>

                                <div className="row">
                                    <strong>Farmacéutico:</strong>
                                    <span>{"Dra. " + cart.user?.person.name}</span>
                                </div>
                            </div>
                            <div className="right">
                                <button className="stylesButoonLogin" onClick={handlePrint}>
                                    imprimir factura
                                </button>
                            </div>
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
