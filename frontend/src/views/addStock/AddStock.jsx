import React, { useState } from "react";
import { NavBar } from "../../componets/NavBar/NavBar";
import "./AddStock.css"
import { TablesLote,  } from "../../componets/tables/tablesStock/TablesLote";

export const AddStock = () => {
    const [selectItem, setSelectItem] = useState(null);

    return(<>
        <NavBar/>
        <div className="stylesContentStock">

            <div>
                <TablesLote/>
            </div>
            
            {/**
            <div className="styleContentStock-two">
                <div className="styleWindowsColumn">
                    <SearchMedicament onSelect={setSelectItem}/>
                </div>

                <div className="styleWindowsColumn">
                    <FormsAddLote item={selectItem}/>
                </div>
            </div> */}           
        </div>
    </>);
}
