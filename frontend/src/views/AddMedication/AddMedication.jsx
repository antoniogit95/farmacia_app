import React, { useState } from "react";
import { NavBar} from "../../componets/NavBar/NavBar";
import { FormsAddMedication } from "../../componets/Forms/addMedication/FormsAddMedication";
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
        </div>
    </>);
}