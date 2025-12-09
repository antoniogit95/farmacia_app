import React, { useState } from "react";
import "./SaveFileMedicament.css"
import { URL_API_private } from "../../../providerContext/EndPoint";
import { toast, ToastContainer } from "react-toastify";
import axios from "axios";

export const SaveFileMedicament = () => {
    const [file, setFile] = useState([]);
    const [loading, setLoading] = useState(false);
    const endPoint = URL_API_private + "/medicament/savefile";
    const token = JSON.parse(localStorage.getItem('user_data')).token;


    const handlefileChange = (e) =>{
        const selectedFile = e.target.files[0];
        if(selectedFile && selectedFile.type === "text/csv"){
            setFile(selectedFile);
        }else{
            toast.error("Solo se permiten archivos .csv");
            setFile(null);
        }
    }

    const config = {
        headers: {
            "Content-Type": "multipart/form-data",
            Authorization: `Bearer ${token}`,
        },
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
            toast.success("Archivo procesado con exito")
            console.log(response.data);
        } catch (error) {
            console.error(error);
            toast.error("error al procesar el archivo")
        }finally{
            setLoading(false);
        }

    }

    return(<>
        <div>
            <h2>Subir medicamentos desde archivo .csv</h2>
            <label>Formato para agregar los datos</label>
            <label>Nombre Generico, Nombre Comercial, Descripcion, Consentracion, forma farmaceutica, presentacion, laboratorio</label>
            <input 
                className=""
                type = "file"
                accept = "csv"
                onChange={handlefileChange}
            />
            <button 
                className = ""
                disabled = {loading}
                onClick={handleUpload}
            >
                {loading ? "procesando... " : "subir archivo"}
            </button>
            <ToastContainer/>
        </div>
    </>)
}