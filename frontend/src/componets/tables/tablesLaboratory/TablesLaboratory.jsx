import React, { useEffect, useState } from "react";
import axios from "axios";
import { URL_API_private } from "../../../providerContext/EndPoint";
import "./TablesLaboratory.css";
import { EditLaboratoryModal } from "../../Modals/modalEditLaboratory/EditLaboratoryModal";

export const TableLaboratories = ({ reload }) => {

    const [labs, setLabs] = useState([]);
    const [loading, setLoading] = useState(false);
    const [showEdit, setShowEdit] = useState(false);
    const [selectedLab, setSelectedLab] = useState(null);

    const token = JSON.parse(localStorage.getItem("user_data")).accessToken;

    const config = {
        headers: {
            Authorization: `Bearer ${token}`
        }
    };

    useEffect(() => {
        getAll();
    }, [reload]);

    const handleEdit = (lab) => {
        setSelectedLab(lab);
        setShowEdit(true);
    };

    const getAll = async () => {
        setLoading(true);
        try {
            const response = await axios.get(
                URL_API_private + "/laboratory/list",
                config
            );
            setLabs(response.data);
        } catch (error) {
            console.log(error);
        }
        setLoading(false);
    };

    return (
        <>
            <h2 className="stylesH2Subtitule">Lista de Laboratorios</h2>

            {loading && <p>Cargando...</p>}
            <div className="styleContentTable">
                <table className="styleTable">
                    <thead className="stylesHead">
                        <tr>
                            <th className="stylesTh-Td">Nombre</th>
                            <th className="stylesTh-Td">Distribuidor</th>
                            <th className="stylesTh-Td">Teléfono</th>
                            <th className="stylesTh-Td">Email</th>
                            <th className="stylesTh-Td">Opciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        {labs.map((lab) => (
                            <tr className="stylesTr" key={lab.id}>
                                <td className="stylesTh-Td">{lab.name}</td>
                                <td className="stylesTh-Td">{lab.distributorName}</td>
                                <td className="stylesTh-Td">{lab.phone}</td>
                                <td className="stylesTh-Td">{lab.email}</td>
                                <td className="stylesTh-Td">
                                    <div className="stylesContentButton-two">
                                        <button className="stylesButoonLogin" onClick={() => handleEdit(lab)}>Editar</button>
                                        <button className="stylesButoonLogin">Borrar</button>
                                    </div>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            <EditLaboratoryModal
                show={showEdit}
                onHide={() => setShowEdit(false)}
                laboratory={selectedLab}
                onSuccess={getAll}
            />
        </>
    );
};