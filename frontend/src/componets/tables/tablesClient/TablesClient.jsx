import React, { useEffect, useState } from "react";
import { URL_API_private } from "../../../providerContext/EndPoint";
import axios from "axios";
import { FaSpinner } from "react-icons/fa";

export const TablesClient = () => {

    const [clients, setclients] = useState([]);
    const [loading, setLoading] = useState(false);

    const token = JSON.parse(localStorage.getItem('user_data')).accessToken
    const endPoint = URL_API_private + "/client/list";

    useEffect(() => {
        getAllData();
    },[])

    const config = {
        headers:{
            Authorization: `Bearer ${token}`,
        }
    }

    const getAllData = async () => {
        setLoading(true);
        try {
            const response = await axios.get(endPoint, config);
            setclients(response.data);
            setLoading(false);
            console.log(response.data);
        } catch (error) {
            console.error(error)
        }
    }

    return(<>
        <div>
            <h2 className="stylesH2Subtitule">Lista de Clientes</h2>
            {loading && (
                <div className="loading-spinner">
                    <FaSpinner className="spinner-icon"/>
                </div>
            )}
            <div className="styleContentTable">
                <table className="styleTable">
                    <thead className="stylesHead">
                        <tr>
                            <th className="stylesTh-Td">Nit / Ci</th>
                            <th className="stylesTh-Td"> Compañia</th>
                            <th className="stylesTh-Td"> Telefono</th>
                            <th className="stylesTh-Td"> Notificaciones</th>
                            <th className="stylesTh-Td"> Opciones</th>
                        </tr>
                    </thead>
                    <tbody className="styleBody">
                        {clients.map((data) => (<>
                            <tr className="stylesTr" key={data.id}>
                                <td className="stylesTh-Td">{data.nit}</td>
                                <td className="stylesTh-Td">{data.companyName}</td>
                                <td className="stylesTh-Td">{data.person.telefono}</td>
                                <td className="stylesTh-Td">{data.notifications? 'si' : 'no'}</td>
                                 <td>
                                    <div className="stylesContentButton-two">
                                        <button className="stylesButoonLogin">editar</button>
                                        <button className="stylesButoonLogin">borrar</button>
                                    </div>
                                </td>
                            </tr>
                        </>)) }
                    </tbody>
                </table>
            </div>
        </div>
    </>);
}