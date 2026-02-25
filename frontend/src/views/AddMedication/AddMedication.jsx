import React, { useState } from "react";
import { NavBar} from "../../componets/NavBar/NavBar";
import { FormsAddMedication } from "../../componets/Forms/addMedication/FormsAddMedication";
import './AddMedication.css'
import { SaveFileMedicament } from "../../componets/saveFiles/saveFileMedicament/SaveFileMedicament";
import { TablesMedicaments } from "../../componets/tables/tablesMedicaments/TablesMedicaments";
import { AddMedicationModal } from "../../componets/Modals/modalAddMedication/AddMedicationModal";
import { AddMedicationBlockModal } from "../../componets/Modals/modalAddMedicamentBlock/AddMedicationBlockModal";
 
export const AddMedication = () => {

    const [showModal, setShowModal] = useState(false)
    const [showModalBlock, setShowModalBlock] = useState(false) 
    const [reload, setReload] = useState(false)

    const handleReload = () => {
        setReload(prev => !prev);
    }

    return (<>
        <NavBar></NavBar>
        <div className="stylesAddMedicament">
            <div className="stylesContentButton-two">
                <button className="stylesButoon" onClick={() => setShowModal(true)}>Agregar medicamento</button>
                <button className="stylesButoon" onClick={() => setShowModalBlock(true)}>Agregar medicamento por bloque</button>
            </div>
            <div>
                <TablesMedicaments/>
            </div>

            {/**
            <div className="stylescontendAddMedicaton-two">
                <div className="styleWindowsColumn">
                    <FormsAddMedication></FormsAddMedication>
                </div>
                <div className="styleWindowsColumn">
                    <SaveFileMedicament/>
                </div>
            </div> */}
            <AddMedicationModal
                show={showModal}
                onHide={() => setShowModal(false)}
                onSuccess={handleReload}
            />
            <AddMedicationBlockModal
                show={showModalBlock}
                onHide={() => setShowModalBlock(false)}
                onSuccess={handleReload}
            />
        </div>
    </>);
}