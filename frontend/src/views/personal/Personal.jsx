import React from "react";
import { NavBar } from "../../componets/NavBar/NavBar";
import "./Personal.css"
import { TablesPersonal } from "../../componets/tables/tablesPersonal/TablesPersonal";
import { useState } from "react";
import { PersonalModal } from "../../componets/Modals/modalsPerson/PersonModal";

export const Personal = () => {

    const [openModalm, setOpenModal] = useState(false);

    return (<>
        <NavBar/>
        <div className="stylesContentPersonal">
            <div className="stylesTopButton">
                <button className="stylesButoon" onClick={() => setOpenModal(true)}>Agregar personal</button>
            </div>
            <TablesPersonal/>
        </div>

        <PersonalModal
            onCrear={handleAdd}
            show={openModalm}
            onHide={() => setOpenModal(false)}
        />
    </>)
}