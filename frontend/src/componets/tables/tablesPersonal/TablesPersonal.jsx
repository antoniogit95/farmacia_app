import React, { useEffect, useState } from "react";
import "./TablesPersonal.css"
import axios from "axios";
import { URL_API_private } from "../../../providerContext/EndPoint";
import { FaSpinner } from 'react-icons/fa';

export const TablesPersonal = () => {
    const [personal, setPersonal] = useState([]);
    const [loading, setLoading] = useState(false);

    const token  = JSON.parse(localStorage.getItem('user_data')).token;
    const endPoint = URL_API_private + "/user/list";


    useEffect(() =>{
        getallPersonal();  
    }, []);

    const config = {
        headers:{
            Authorization: `Bearer ${token}`,
        }
    }

    const getallPersonal = async () =>{
        setLoading(true);
        try {    
            const response = await axios.get(endPoint, config);
            setPersonal(response.data)   
            setLoading(false)
            console.log(response.data);
        } catch (error) {
            console.error(error);   
        }
    }

    return(<>
        <div>
            <h2 className="stylesH2Subtitule">lista del personal</h2>
            {loading && (
                        <div className="loading-spinner">
                            <FaSpinner className="spinner-icon" />
                        </div>
                    )}
            <div className="styleContentTable">
                <table className="styleTable">
                    <thead className="stylesHead">
                        <tr>
                            <th className="stylesTh-Td">id</th>
                            <th className="stylesTh-Td">nombre</th>
                            <th className="stylesTh-Td">telefono</th>
                            <th className="stylesTh-Td">direccion</th>
                            <th className="stylesTh-Td">usuario</th>
                            <th className="stylesTh-Td">Opciones</th>
                        </tr>
                    </thead>
                    <tbody className="stylesBody">
                        {personal.map((data) => (<> 
                            <tr className="stylesTr" key={data.id}>
                                <td className="stylesTh-Td">{data.username}</td>
                                <td className="stylesTh-Td">{data.person.name}</td>
                                <td className="stylesTh-Td">{data.username}</td>
                                <td className="stylesTh-Td">{data.username}</td>
                                <td className="stylesTh-Td">{data.username}</td>
                                <td>
                                    <div className="stylesContentButton-two">
                                        <button className="stylesButoonLogin">editar</button>
                                        <button className="stylesButoonLogin">borrar</button>
                                    </div>
                                </td>
                            </tr>
                        </>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    </>);
}