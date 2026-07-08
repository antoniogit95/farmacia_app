import React, { useState } from "react";
import { NavBar } from "../../componets/NavBar/NavBar";
import { AddLaboratoryModal } from "../../componets/Modals/modalAddLaboratory/AddLaboratoryModal";
import { TableLaboratories } from "../../componets/tables/tablesLaboratory/TablesLaboratory";
import "./AddLaboratory.css";

export const AddLaboratory = () => {

    const [showModal, setShowModal] = useState(false);
    const [reload, setReload] = useState(false);

    const handleReload = () => {
        setReload(prev => !prev);
    }

    return (
        <>
            <NavBar />

            <div className="stylesAddLaboratory">

                <button 
                    className="stylesButoon" 
                    onClick={() => setShowModal(true)}
                >
                    Agregar Laboratorio
                </button>

                <TableLaboratories reload={reload} />

                <AddLaboratoryModal
                    show={showModal}
                    onHide={() => setShowModal(false)}
                    onSuccess={handleReload}
                />

            </div>
        </>
    );
};