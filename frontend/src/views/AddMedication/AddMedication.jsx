import React, { useState } from "react";
import { NavBar} from "../../componets/NavBar/NavBar";
import { FormsAddMedication } from "../../componets/Forms/addMedication/FormsAddMedication";
 
export const AddMedication = () => {
    
    const [addmedication, setAddMedication] = useState(false);
    const [addBathc, setBatch] = useState(false);

    return (<>
        <NavBar></NavBar>
        <button>agregar medicamentos</button>
        <FormsAddMedication></FormsAddMedication>
        <button>agregar lote</button>
    </>);
}