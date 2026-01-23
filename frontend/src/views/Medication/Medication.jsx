import React, { useState } from "react";
import { NavBar } from "../../componets/NavBar/NavBar";
import './Medication.css';
import { Ventas } from "../../componets/ventas/Ventas";
import { SearchMedicament } from "../../componets/medicaments/searchMedicament/SearchMedicament";
import { SelectMedicament } from "../../componets/medicaments/selectMedicament/SelectMedicament";
import { Shopping } from "../../componets/medicaments/shopping/Shopping";

export const Medication = () => {
    const [selectItem, setSelectItem] = useState(null);
    const [cart, setCart] = useState([]);

    const addToCar = (item) =>{
        setCart((prev) => [...prev, item]);
        setSelectItem(null);
    }

    return (<>
        <NavBar/>
        <div className="stylesContentMedicament"> 
            {/**<Ventas></Ventas> */}
            <div className="styleContentMedicament-thre ">
                <div className="styleWindowsColumn">
                    <SearchMedicament onSelect={setSelectItem}/>
                </div>
                <div className="styleWindowsColumn">
                    <SelectMedicament item={selectItem} onAdd={addToCar}/>
                </div>
                <div className="styleWindowsColumn">
                    <Shopping cart={cart} setCart={setCart}/>
                </div>
            </div>
        </div>
    </>);
}