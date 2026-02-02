import React, { useEffect, useState } from "react";
import "./TablesLote.css"
import { URL_API_private } from "../../../providerContext/EndPoint";
import axios from 'axios';
import { FaSpinner } from 'react-icons/fa';
import { EditLoteModal } from "../../Modals/modalEditLote/EditLoteModal";

export const TablesLote = () => {
    const [lotes, setLotes] = useState([]);
    const token  = JSON.parse(localStorage.getItem('user_data')).token;
    const endPointLote = URL_API_private + "/lote/list"
    const [loading, setLoading] = useState(false);
    const [search, setSearch] = useState("");
    const [showModal, setShowModal] = useState(false);
    const [selected, setSelected] = useState([]);
    const [dateFrom, setDateFrom] = useState("");
    const [dateTo, setDateTo] = useState("");
    const [applyDateFilter, setApplyDateFilter] = useState(false);

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

    const filteredMedicaments = lotes
        .filter((l) => {
            const text = search.toLowerCase();
            return l.lotNomber?.toLowerCase().includes(text);
        })
        .filter((l) => {
            if (!applyDateFilter) return true;

            const expDate = new Date(l.expirationTime);
            const from = dateFrom ? new Date(dateFrom) : null;
            const to = dateTo ? new Date(dateTo) : null;

            if (from && expDate < from) return false;
            if (to && expDate > to) return false;

            return true;
        })
        .sort(
            (a, b) =>
                new Date(a.expirationTime) - new Date(b.expirationTime)
        );

    const handleClick = (value) => {
        setSelected(value);
        setShowModal(true);
    }

    return (<>
        <h2 className="stylesH2Subtitule">lista de Stock o Lotes</h2>
        {loading && (
            <div className="loading-spinner">
                <FaSpinner className="spinner-icon" />
            </div>
        )}
        <div className="stylesSearchContainerHorizontal">

            <input
                type="text"
                className="stylesInput"
                placeholder="Buscar Lote..."
                value={search}
                onChange={(e) => setSearch(e.target.value)}
            />

            <input
                type="date"
                className="stylesInput"
                value={dateFrom}
                onChange={(e) => setDateFrom(e.target.value)}
            />

            <input
                type="date"
                className="stylesInput"
                value={dateTo}
                onChange={(e) => setDateTo(e.target.value)}
            />
            <div className="stylesContentButton-two">
                <button
                    className="stylesButoon"
                    onClick={() => setApplyDateFilter(true)}
                >
                    Filtrar
                </button>

                <button
                    className="stylesButoon secondary"
                    onClick={() => {
                        setDateFrom("");
                        setDateTo("");
                        setApplyDateFilter(false);
                    }}
                >
                    Limpiar
                </button>
            </div>
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
                    {filteredMedicaments.map((lote) => (<>
                        <tr className="stylesTr" key={lote.id}>
                            <td className="stylesTh-Td">{lote.lotNomber}</td>
                            <td className="stylesTh-Td">{lote.medicament.comercialName}</td>
                            <td className="stylesTh-Td">{lote.quantity}</td>
                            <td className="stylesTh-Td">{lote.unitPrice}</td>
                            <td className="stylesTh-Td">{lote.expirationTime}</td>
                            <td>
                                <div className="stylesContentButtonTable">
                                    <button className="stylesButoon" onClick={() => handleClick(lote)}>editar</button>
                                </div>
                            </td>
                        </tr>                       
                    </>))}                   
                </tbody>
            </table>
        </div>
        <EditLoteModal
            show={showModal}
            onHide={()=> setShowModal(false)}
            lote={selected}
        />
    </>);
}