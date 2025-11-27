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
    return (<>
        <h1>lista de medicamentos</h1>
        {loading && (
            <div className="loading-spinner">
                <FaSpinner className="spinner-icon" />
            </div>
        )}
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Nombre Generico</th>
                        <th>Nombre Comun</th>
                        <th>Descripcion</th>
                        <th>Presentacion</th>
                        <th>Concentracion</th>
                        <th>Forma farmaceutica</th>
                        <th>Laboratorio</th>
                    </tr>
                </thead>
                <tbody>
                    {medicamets.map((data) => (
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