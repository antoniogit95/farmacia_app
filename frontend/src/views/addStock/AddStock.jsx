import React from "react";
import { NavBar } from "../../componets/NavBar/NavBar";
import "./AddStock.css"
import { TablesMedicaments } from "../../componets/tables/tablesMedicaments/TablesMedicaments";

export const AddStock = () => {

    return(<>
        <NavBar/>
        <div className="stylesContentStock">
            <TablesMedicaments/>
        </div>
    </>);
}
