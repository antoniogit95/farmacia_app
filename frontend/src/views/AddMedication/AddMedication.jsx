import React, { useState } from "react";
import { NavBar} from "../../componets/NavBar/NavBar";
 
export const AddMedication = () => {
    
    const [addmedication, setAddMedication] = useState(false);
    const [addBathc, setBatch] = useState(false);

    return (<>
        <NavBar></NavBar>
        <button>agregar medicamentos</button>
        <button>agregar lote</button>
    </>);
}