import { Formik } from "formik";
import "./AddMedicationBlockModal.css"
import React, { useEffect, useState } from "react";
import { Modal } from "react-bootstrap";
import { URL_API_private, URL_API_public } from "../../../providerContext/EndPoint";
import { toast, ToastContainer } from "react-toastify";
import axios from "axios";

export const AddMedicationBlockModal = ({show, onHide}) => {

    const personData = localStorage.getItem('user_data');
    const endPoint = URL_API_private+"/lote/add";
    const token = JSON.parse(personData).token;

    const config = {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    };


    return(<>
        <Modal show={show} onHide={onHide} centered>
            <Modal.Header closeButton className="modalHeader">
                <Modal.Title>Guardar Medicamentos </Modal.Title>
            </Modal.Header>
            <Modal.Body className="modalBody">
                <div className='stylesRegistroPersonal'>
                <strong>Guardar Medicamentos por Lote</strong>
                <ToastContainer />
           </div>
            </Modal.Body>
        </Modal>
    </>)
}     