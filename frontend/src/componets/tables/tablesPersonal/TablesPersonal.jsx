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
            <h1>lista del personal</h1>
            {loading && (
                        <div className="loading-spinner">
                            <FaSpinner className="spinner-icon" />
                        </div>
                    )}
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>nombre</th>
                            <th>telefono</th>
                            <th>direccion</th>
                            <th>usuario</th>
                        </tr>
                    </thead>
                    <tbody>
                        {personal.map((data) => (<> 
                            <tr key={data.id}>
                                <th>{data.username}</th>
                                <th>{data.person.name}</th>
                                <th>{data.username}</th>
                                <th>{data.username}</th>
                                <th>{data.username}</th>
                            </tr>
                        </>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    </>);
}