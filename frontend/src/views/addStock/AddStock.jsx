import React, { useState } from "react";
import { NavBar } from "../../componets/NavBar/NavBar";
import "./AddStock.css"
import { SearchMedicament } from "../../componets/medicaments/searchMedicament/SearchMedicament";
import { FormsAddLote } from "../../componets/Forms/addLote/FormsAddLote";

export const AddStock = () => {
    const [selectItem, setSelectItem] = useState(null);

    return(<>
        <NavBar/>
        <div className="stylesContentStock">
            <div className="styleContentStock-two">
                <div className="styleWindowsColumn">
                    <SearchMedicament onSelect={setSelectItem}/>
                </div>

                <div className="styleWindowsColumn">
                    <FormsAddLote item={selectItem}/>
                </div>
            </div>
        </div>
    </>);
}
