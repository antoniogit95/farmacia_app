import React from "react";
import './SingAuth.css'
import { FormsSingAuth } from "../../componets/Forms/FormsSingAuth";

export const SingAuth = () => {
    return(<>
        <div className="styleContentRegister">
            <h2>Registrar Personal</h2>
            <FormsSingAuth/>
        </div>
        
    </>);
}