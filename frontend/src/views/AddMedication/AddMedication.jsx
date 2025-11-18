import React, { useState } from "react";
import { NavBar} from "../../componets/NavBar/NavBar";
import { FormsAddMedication } from "../../componets/Forms/addMedication/FormsAddMedication";
import { FormsAddLote } from "../../componets/Forms/addLote/FormsAddLote";
import './AddMedication.css'
 
export const AddMedication = () => {
    
    const [addmedication, setAddMedication] = useState(false);
    const [addBathc, setBatch] = useState(false);

    return (<>
        <NavBar></NavBar>
        <div className="stylesAddMedicament">
            <div className="stylesAddMedication">
                <FormsAddMedication></FormsAddMedication>
            </div>
            <div className="stylesAddMedication">
            <FormsAddLote></FormsAddLote>
            </div>
        </div>
    </>);
}