import React, { useEffect, useState } from "react";
import axios from "axios";
import { URL_API_private } from "../../../providerContext/EndPoint";

export const SearchMedicament = ({ onSelect }) =>{

    const [query, setQuery] = useState("");
    const endPoint = URL_API_private+"/medicament/list";
    const [data, setData] = useState([]);
    const token  = JSON.parse(localStorage.getItem('user_data')).token;

    useEffect(()=>{
        const fectshMedicament = async () => {
            const response = await axios.get(endPoint, config);
            setData(response.data);
        }
        fectshMedicament();
    }, [])

    const config = {
        headers:{
            Authorization: `Bearer ${token}`,
        }
    }

    const filtered = data.filter((p) =>
        (p.genericName + p.comercialName).toLowerCase().includes(query.toLowerCase())
    );

    return(<>
        <div>
            <h2>buscar medicamento</h2>
            <input 
                type = "text"
                placeholder = "buscar por nombre comun o general"
                value = {query}
                onChange = {(e) => setQuery(e.target.value)}
            />
            <ul>
                {filtered.map((m) => (
                    <li key={m.id} onClick={() => onSelect(m)}>
                        {m.genericName} - {m.comercialName}-{m.concentration} - {m.laboratory} 
                    </li>
                ))}
            </ul>
        </div>
    </>)
}