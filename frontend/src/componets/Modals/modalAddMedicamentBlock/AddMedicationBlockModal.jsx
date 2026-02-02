import { Formik } from "formik";
import "./AddMedicationBlockModal.css"
import React, { useEffect, useState } from "react";
import { Modal } from "react-bootstrap";
import { URL_API_private, URL_API_public } from "../../../providerContext/EndPoint";
import { toast, ToastContainer } from "react-toastify";
import axios from "axios";

export const AddMedicationBlockModal = ({show, onHide}) => {

    const personData = localStorage.getItem('user_data');
    const endPoint = URL_API_private+"/medicament/savefile";
    const token = JSON.parse(personData).token;
    const [file, setFile] = useState([]);
    const [loading, setLoading] = useState(false);
    const [dragActive, setDragActive] = useState(false);

    const config = {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    };
    const handleFileChange = (e) =>{
        const selectedFile = e.target.files[0];
        if(selectedFile && selectedFile.type === "text/csv"){
            setFile(selectedFile);
        }else{
            toast.error("Solo se permiten archivos .csv");
            setFile(null);
        }
    }

    const validateFile = (selected) => {
        if (!selected) return;

        if (!selected.name.endsWith(".csv")) {
        toast.error("❌ Solo se permiten archivos .csv");
        return;
        }

        setFile(selected);
    };

    const handleDrop = (e) => {
        e.preventDefault();
        setDragActive(false);
        const droppedFile = e.dataTransfer.files[0];
        validateFile(droppedFile);
    };

    const handleUpload = async () =>{
        if(!file){
            toast.error("Selecciona un Archivo CSV primero")
            return;
        }

        setLoading(true);
        
        const formData = new FormData();
        formData.append("file", file);

        try {
            const response = await axios.post(endPoint, formData, config);
            toast.success("✅ Archivo procesado con exito")
            console.log(response.data);
        } catch (error) {
            console.error(error);
            toast.error("❌ Error al procesar el archivo")
        }finally{
            setLoading(false);
        }

    }

    return(<>
        <Modal show={show} onHide={onHide} centered>
            <Modal.Header closeButton className="modalHeader">
                <Modal.Title>Guardar Medicamentos </Modal.Title>
            </Modal.Header>
            <Modal.Body className="modalBody">
                <p className="stylesformatInfo">
                    Formato:
                    <br />
                    <strong>
                    Nombre genérico, Nombre comercial, Descripción, Concentración,
                    Forma farmacéutica, Presentación, Laboratorio
                    </strong>
                </p>
                <div
                    className={dragActive? "stylesDropZoneActive" : "stylesDropZone"}
                        onDragOver={(e) => {
                        e.preventDefault();
                        setDragActive(true);
                    }}
                    onDragLeave={() => setDragActive(false)}
                    onDrop={handleDrop}
                >
                    <p>
                    {file
                        ? `📄 Archivo seleccionado: ${file.name}`
                        : "Arrastra el archivo aquí o haz clic para seleccionar"}
                    </p>

                    <input
                        type="file"
                        accept=".csv"
                        onChange={handleFileChange}
                        className="file-input"
                    />
                </div>
                
                <div className="">
                    <button 
                        className = "stylesButoon"
                        disabled = {loading}
                        onClick={handleUpload}
                    >
                        {loading ? "procesando... " : "subir archivo"}
                    </button>
                </div>
            </Modal.Body>
        </Modal>
    </>)
}     