import React, { useEffect, useState } from "react";
import "./TablesLote.css"
import { URL_API_private } from "../../../providerContext/EndPoint";
import axios from 'axios';
import { FaSpinner } from 'react-icons/fa';

export const TablesLote = () => {
    const [lotes, setLotes] = useState([]);
    const token  = JSON.parse(localStorage.getItem('user_data')).token;
    const endPointLote = URL_API_private + "/lote/list"
    const [loading, setLoading] = useState(false);
    const [search, setSearch] = useState("");



    useEffect(() => {
        getAllDataLote();
    }, []);


    const config = {
        headers:{
            Authorization: `Bearer ${token}`,
        }
    }

    const getAllDataLote = async () => {
        setLoading(true);
        try {
            const response = await axios.get(endPointLote, config);
            setLotes(response.data);
            console.log(response.data);
            console.log(lotes);
            setLoading(false)
        } catch (error) {
            console.log(error);
            setLoading(false)
        }
    }

    const filteredMedicaments = lotes.filter((m) => {
        const text = search.toLowerCase();
        return (
            m.genericName?.toLowerCase().includes(text) ||
            m.comercialName?.toLowerCase().includes(text) ||
            m.description?.toLowerCase().includes(text) ||
            m.laboratory?.toLowerCase().includes(text)
        );
    });

    return (<>
        <h2 className="stylesH2Subtitule">lista de Stock o Lotes</h2>
        {loading && (
            <div className="loading-spinner">
                <FaSpinner className="spinner-icon" />
            </div>
        )}
        <div className="stylesSearchContainer">
            <input
                type="text"
                className="stylesInput"
                placeholder="Buscar Lote..."
                value={search}
                onChange={(e) => setSearch(e.target.value)}
            />
        </div>
        <div className="styleContentTable">
            <table className="styleTable">
                <thead className="stylesHead">
                    <tr>
                        <th className="stylesTh-Td">Numero de Lote</th>
                        <th className="stylesTh-Td">Medicamento</th>
                        <th className="stylesTh-Td">Cantidad</th>
                        <th className="stylesTh-Td">Precio</th>
                        <th className="stylesTh-Td">Fecha Expiracion</th>
                        <th className="stylesTh-Td">Opciones</th>
                    </tr>
                </thead>
                <tbody className="stylesBody">
                    {lotes.map((lotes) => (<>
                        <tr className="stylesTr" key={lotes.id}>
                            <td className="stylesTh-Td">{lotes.lotNomber}</td>
                            <td className="stylesTh-Td">{lotes.medicament.genericName}</td>
                            <td className="stylesTh-Td">{lotes.quantity}</td>
                            <td className="stylesTh-Td">{lotes.unitPrice}</td>
                            <td className="stylesTh-Td">{lotes.expirationTime}</td>
                            <td>
                                <div className="stylesContentButton">
                                    <button className="stylesButoonLogin">editar</button>
                                </div>
                            </td>
                        </tr>                       
                    </>))}                   
                </tbody>
            </table>
        </div>
    </>);
}