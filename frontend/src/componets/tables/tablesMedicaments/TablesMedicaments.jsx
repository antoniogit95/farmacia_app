import React, { useEffect, useState } from "react";
import "./TablesMedicaments.css"
import { URL_API_private } from "../../../providerContext/EndPoint";
import axios from 'axios';
import { MedicamentRow } from "./MedicamentRow";
import { FaSpinner } from 'react-icons/fa';

export const TablesMedicaments = () => {
    const [medicamets, setMedicaments] = useState([]);
    const token  = JSON.parse(localStorage.getItem('user_data')).token;
    const endPointMedication = URL_API_private + "/medicament/list"
    const [loading, setLoading] = useState(false);
    const [search, setSearch] = useState("");



    useEffect(() => {
        getAllDataMedications();
    }, []);


    const config = {
        headers:{
            Authorization: `Bearer ${token}`,
        }
    }

    const getAllDataMedications = async () => {
        setLoading(true);
        try {
            const response = await axios.get(endPointMedication, config);
            setMedicaments(response.data);
            setLoading(false)
        } catch (error) {
            console.log(error);
            setLoading(false)
        }
    }

    const filteredMedicaments = medicamets.filter((m) => {
        const text = search.toLowerCase();
        return (
            m.genericName?.toLowerCase().includes(text) ||
            m.comercialName?.toLowerCase().includes(text) ||
            m.description?.toLowerCase().includes(text) ||
            m.laboratory?.toLowerCase().includes(text)
        );
    });

    return (<>
        <h2 className="stylesH2Subtitule">lista de medicamentos</h2>
        {loading && (
            <div className="loading-spinner">
                <FaSpinner className="spinner-icon" />
            </div>
        )}
        <div className="stylesSearchContainer">
            <input
                type="text"
                className="stylesInput"
                placeholder="Buscar medicamento..."
                value={search}
                onChange={(e) => setSearch(e.target.value)}
            />
        </div>
        <div className="styleContentTable">
            <table className="styleTable">
                <thead className="stylesHead">
                    <tr>
                        <th className="stylesTh-Td">Nombre Generico</th>
                        <th className="stylesTh-Td">Nombre Comun</th>
                        <th className="stylesTh-Td">Descripcion</th>
                        <th className="stylesTh-Td">Presentacion</th>
                        <th className="stylesTh-Td">Concentracion</th>
                        <th className="stylesTh-Td">Forma farmaceutica</th>
                        <th className="stylesTh-Td">Laboratorio</th>
                        <th className="stylesTh-Td"> opciones</th>
                    </tr>
                </thead>
                <tbody className="stylesBody">
                    {filteredMedicaments.map((data) => (
                        <MedicamentRow 
                            key={data.id}
                            medicament = {data}
                        />
                    ))}
                </tbody>
            </table>
        </div>
    </>);
}