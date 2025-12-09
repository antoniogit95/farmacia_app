import React, { useEffect, useState } from "react";
import axios from "axios";
import { URL_API_private } from "../../../providerContext/EndPoint";
import "./SearchMedicament.css"

export const SearchMedicament = ({ onSelect }) =>{

    const [query, setQuery] = useState("");
    const endPoint = URL_API_private+"/medicament/list";
    const [data, setData] = useState([]);
    const token  = JSON.parse(localStorage.getItem('user_data')).token;

    useEffect(()=>{
        const fectshMedicament = async () => {
            const response = await axios.get(endPoint, config);
            setData(response.data);
            console.log(response.data)
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
        <div className="">
            <h2 className="stylesH2Subtitule">Buscar medicamento</h2>
            <label > Ingrese nombre del medicamento</label>
            <input 
                className="stylesInput"
                type = "text"
                placeholder = "buscar por nombre comun o general"
                value = {query}
                onChange = {(e) => setQuery(e.target.value)}
            />
            <ul className="styleSearchResult">
                {filtered.map((m) => (
                    <li className="styleSearchItem" key={m.id} onClick={() => onSelect(m)}>
                        {m.genericName} - {m.comercialName}-{m.consetration} - {m.laboratory} 
                    </li>
                ))}
            </ul>
        </div>
    </>)
}