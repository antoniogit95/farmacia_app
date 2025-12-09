import React, { use, useEffect, useState } from "react";
import "./SelectMedicament.css"
import { URL_API_private } from "../../../providerContext/EndPoint";
import axios from "axios";

export const SelectMedicament = ({item, onAdd}) => {

    const [lotes, setLotes] = useState([]);
    const [selectedLote, setSelectedLote] = useState([]);
    const [quantity, setQuantity] = useState(1);
    const [price, setPrice] = useState(0.0);
    const [discount, setDiscount] = useState(0.0);
    
    const token = JSON.parse(localStorage.getItem('user_data')).token;

    const endPoint = URL_API_private+"/lote/";

    useEffect(() => {
        if (!item) return;

        const fetchLotes = async () => {
            try {
                console.log(endPoint + item.id);
                console.log(config);
                const response = await axios.get(endPoint + item.id, {
                    headers: config.headers,
                });
                console.log(response);
                setLotes(response.data);  
            } catch (err) {
                console.error("Error cargando lotes:", err);
            }
        };

        fetchLotes();
    }, [item]);

    const config = {
        headers:{
            Authorization: `Bearer ${token}`,
        }
    }

    const handleSelectLote = (loteId) => {
        const lote = lotes.find(l => l.id === parseInt(loteId));
        setSelectedLote(lote);

        setPrice(lote.unitPrice);
        setQuantity(1);
    };

    if(!item) return <h2 className="stylesH2Subtitule"> Selecciona un producto</h2>

    const total = (quantity * price) * (1 -discount/100);

    return (<>
        <div>
            <h2 className="stylesH2Subtitule">Medicamento seleccionado</h2>
            <p>{item.genericName} {item.consentration} {item.laboratory}</p>

            <h3 className="stylesH2Subtitule">Lotes Disponibles</h3>
            
             {lotes.length > 0 ? (
                <div>
                    <label>Lotes disponibles</label>
                    <select className="stylesInput" onChange={(e) => handleSelectLote(e.target.value)}>
                        <option value="">Seleccionar lote</option>
                        {lotes.map(l => (
                            <option key={l.id} value={l.id}>
                                Lote: {l.lotNomber} — Vence: {l.expirationTime} — Stock: {l.quantity}
                            </option>
                        ))}
                    </select>
                </div>
            ) : (
                <p style={{color: "red"}}>⚠ No hay stock disponible</p>
            )}
            <div>
                <label>Precio</label>
                <input 
                    className="stylesInput"
                    type="text"
                    value={price}
                    //onChange={(e) => setPrice(e.target.value)} 
                />
            </div>
            
            <div>
                <label>Cantidad</label>
                <input 
                    className="stylesInput"
                    type="number"
                    value={quantity}
                    onChange={(e) => setQuantity(e.target.value)} />
            </div>
            
            <div>
                <label>Descuento</label>
            <input 
                className="stylesInput"
                type="text"
                value={discount}
                onChange={(e) => setDiscount(e.target.value)} />
            </div>
            <p>total: {total.toFixed(2)}</p>
            <div className="stylesContenedorButton">
                <button className='stylesButoon' onClick={() => onAdd({ ...item, quantity, price, discount, total})}>
                Agregarl al carrito
            </button>
            </div>
            
        </div>
    </>)
   
}