import React from "react";
import { NavBar } from "../../componets/NavBar/NavBar";
import './Medication.css';
import { Ventas } from "../../componets/ventas/Ventas";

export const Medication = () => {
    

    return (<>
        <NavBar/>
        <div className="stylesContentMedicament"> 
            <Ventas></Ventas>
        </div>
    </>);
}