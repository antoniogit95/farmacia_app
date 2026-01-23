import React, { useState } from "react";
import './TablesMedicaments.css'
import { AddMedicationModal } from "../../Modals/modalAddMedication/AddMedicationModal";
import { EditMedicationModal } from "../../Modals/modalEditMedication/EditMedicationModal";
import { AddLoteModal } from "../../Modals/modalAddLote/AddLoteModal";

export const MedicamentRow = ({medicament}) => {
    const [showModalEdit, setShowModalEdit] = useState(false);
    const [showModalLote, setShowModalLote] = useState(false);
    
    return(<>
        <tr className="stylesTr">
            <td className="stylesTh-Td">{medicament.comercialName}</td>
            <td className="stylesTh-Td">{medicament.genericName}</td>
            <td className="stylesTh-Td">{medicament.descrption}</td>
            <td className="stylesTh-Td">{medicament.presentation.name}</td>
            <td className="stylesTh-Td">{medicament.consetration}</td>
            <td className="stylesTh-Td">{medicament.pharmaceForm}</td>
            <td className="stylesTh-Td">{medicament.laboratory}</td>
            <div className="stylesContentButton-two">
                <button className="stylesButoonLogin" onClick={() => setShowModalEdit(true)}>Editar</button>
                <button className="stylesButoonLogin" onClick={() => setShowModalLote(true)}>Add Lote</button>
            </div>
        </tr>

        <EditMedicationModal
            show={showModalEdit}
            onHide={() => setShowModalEdit(false)}
            medication={medicament}
        />
        <AddLoteModal
            show={showModalLote}
            onHide={() => setShowModalLote(false)}
            medication={medicament}
        />
    </>);
}