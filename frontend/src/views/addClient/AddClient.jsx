import React, { useState } from "react";
import './AddClient.css';
import { NavBar } from "../../componets/NavBar/NavBar";
import { TablesClient } from "../../componets/tables/tablesClient/TablesClient";
import { AddClientModal } from "../../componets/Modals/modalAddClient/AddClientModal";

export const AddClient = () =>{

    const [openModal, setOpenModal] = useState(false);

    return(<>
        <NavBar/>
        <div className="stylesContentClient">
            <div className="stylesTopButton">
                <button className="stylesButoon" onClick={() => setOpenModal(true)}> Agregar Cliente</button>
            </div>
            <TablesClient />
        </div>
        <AddClientModal
            show={openModal}
            onHide={() => setOpenModal(false)}
        />
    </>);
} 