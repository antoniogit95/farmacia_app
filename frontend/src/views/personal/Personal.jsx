import React from "react";
import { NavBar } from "../../componets/NavBar/NavBar";
import "./Personal.css"
import { TablesPersonal } from "../../componets/tables/tablesPersonal/TablesPersonal";

export const Personal = () => {
    return (<>
        <NavBar/>
        <div className="stylesContentPersonal">
            <TablesPersonal/>
        </div>
    </>)
}