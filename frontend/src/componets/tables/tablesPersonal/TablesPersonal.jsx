import React, { useState } from "react";
import "./TablesPersonal.css"
import { FaSpinner } from 'react-icons/fa';
import { FiEdit,FiLock } from "react-icons/fi";
import { useQuery } from "@tanstack/react-query";
import { personalService } from "../../../services/personalService";
import { EditPersonModal } from "../../Modals/personal/EditPersonal";
import { EditPassword } from "../../Modals/personal/EditPassword";

export const TablesPersonal = () => {

    const [selectedPersonal, setSelectedPersonal] = useState(null);
    const [showEditModal, setShowEditModal] = useState(false);

    const [selectedPassword, setSelectedPassword] = useState(null);
    const [showPassworndModal, setShowPasswordModal] = useState(false)

    const {
        data: personal = [], 
        isLoading,
        isError,
        error
    } = useQuery({
        queryKey: ["personal"],
        queryFn: personalService.getAll,
    })

     if (isError) {
        console.error(error);
    }

    return(<>
        <div>
            <h2 className="stylesH2Subtitule">lista del personal</h2>
            {isLoading && (
                        <div className="loading-spinner">
                            <FaSpinner className="spinner-icon" />
                        </div>
                    )}
            <div className="styleContentTable">
                <table className="styleTable">
                    <thead className="stylesHead">
                        <tr>
                            <th className="stylesTh-Td">Nombre</th>
                            <th className="stylesTh-Td">Apellidos</th>
                            <th className="stylesTh-Td">telefono</th>
                            <th className="stylesTh-Td">direccion</th>
                            <th className="stylesTh-Td">usuario</th>
                            <th className="stylesTh-Td">estado</th>
                            <th className="stylesTh-Td">Opciones</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody className="stylesBody">
                        {personal.map((data) => (<> 
                            <tr className="stylesTr" key={data.id}>
                                <td className="stylesTh-Td">{data.person?.name}</td>
                                <td className="stylesTh-Td">{data.person?.surname}</td>
                                <td className="stylesTh-Td">{data.person?.telefono}</td>
                                <td className="stylesTh-Td">{data.person?.address}</td>
                                <td className="stylesTh-Td">{data.username}</td>
                                <td className="stylesTh-Td">{data.status? "si" : "no"}</td>
                                <td colSpan={2}>
                                    <div className="stylesContentButton-thre">
                                        
                                        <button 
                                            className="stylesButoonLogin"
                                            onClick={() =>{
                                                setSelectedPersonal(data);
                                                setShowEditModal(true);
                                            }}
                                        > <FiEdit/>editar</button>
                                        
                                        <button 
                                            className="stylesButoonLogin"
                                            onClick={() =>{
                                                setSelectedPassword(data);
                                                setShowPasswordModal(true);
                                            }}
                                        >cambiar comtraseña</button>
                                        
                                        <button 
                                        className="stylesButoonLogin">
                                            
                                            <FiLock style={{ color: "red", marginRight: "5px"  }}/> 
                                            Bloquear/Desbloquear
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
        <EditPersonModal
            show={showEditModal}
            onHide={() =>{
                setSelectedPersonal(null);
                setShowEditModal(false);
            }}
            person={selectedPersonal}
        />

        <EditPassword
            show={{showPassworndModal}}
            onHide={() =>{
                setSelectedPassword(null);
                setShowPasswordModal(false)
            }}
            person={selectedPassword}
        />

    </>);
}