import React, { useEffect, useState } from "react";
import "./Shopping.css"
import { printFactura } from "../../printer/PrinterFactura";
import { ToastContainer, toast } from "react-toastify";
import { URL_API_private } from "../../../providerContext/EndPoint";
import axios from "axios";
import { FiEdit } from "react-icons/fi";
import { FiTrash2 } from "react-icons/fi";

export const Shopping = ({ cart , setCart, onEdit, onDelete}) => {
    
    const [nit, setNit] = useState("");
    const [name, setName] = useState("");
    
    const [clients, setClients] = useState([]);
    const [suggestions, setSuggestions] = useState([]);
    const [showSuggestions, setShowSuggestions] = useState(false);

    const personData = JSON.parse(localStorage.getItem('user_data')); 
    const token = personData.accessToken;
    const userName = personData.username;
    const endPoint = URL_API_private + "/sale/add";
    const endPointClient = URL_API_private + "/client/list";
    const [paymentType, setPaymentType] = useState("EFECTIVO");


    //const endPoint = URL_API_private + "/firma/factura";
    
    const totalFinal = cart.reduce((acc, item) => acc + parseFloat(item.subTotal), 0);

    const totalDiscount = cart.reduce((acc, item) => acc + parseFloat(item.discount), 0);

    useEffect(() => {
        loadClients();
    }, []);

    const config = {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    }

    const generarDescription = () =>{
         let descripcion = "";

        for (let i = 0; i < cart.length; i++) {
            const item = cart[i];
            descripcion += `${item.comercialName} x${item.quantity}`;

            // evitar salto de línea al final
            if (i < cart.length - 1) {
                descripcion += "\n";
            }
        }

        return descripcion;
    }

    const loadClients = async () => {
        try {
            const response = await axios.get(
                endPointClient,
                config
            );
            setClients(response.data);
        } catch (error) {
            console.log(error);
        }
    };

    const handlePedidoEImpresion = async () => {
        
        if (cart.length === 0) {
            toast.error("Debe agregar productos", { autoClose: 3000 });
            return;
        }

        try {
            await axios.post(
            endPoint,
            {
                clientNit: nit,
                clientname: name,
                userName: userName,
                description: generarDescription(),
                saleName: "",
                subTotal: totalFinal,
                discount: totalDiscount,
                details: cart,
            },
            config
            );

            toast.success("Pedido realizado", { autoClose: 2000 });

            // 🔥 IMPRIMIR AUTOMÁTICAMENTE
            printFactura({
                items: cart,
                nit,
                companyName: name,
            });

            // limpiar
            setCart([]);
            setNit("");
            setName("");

        } catch (error) {
            console.error(error);
            toast.error("Error al realizar pedido");
        }
    };

    const handleSearch = (value) => {
        setNit(value);

        if (!value) {
            setSuggestions([]);
            setShowSuggestions(false);
            return;
        }

        const filtered = clients.filter(c =>
            c.nit.includes(value) || 
            c.companyName.toLowerCase().includes(value.toLowerCase())
        );

        setSuggestions(filtered.slice(0, 5)); // máximo 5 resultados
        setShowSuggestions(true);
    };

    const handleSelectClient = (client) => {
        setNit(client.nit);
        setName(client.companyName);

        setSuggestions([]);
        setShowSuggestions(false);
    };

    return(<>
        <div>
            <h2 className="stylesH2Subtitule">Resumen de compra</h2>
            <div>
                <div className="autocomplete-container">
                    <label>Numero de NIT o Carnet</label>

                    <input 
                        className="stylesInput"
                        type="text" 
                        value={nit}
                        onChange={(e) => handleSearch(e.target.value)}
                        onFocus={() => nit && setShowSuggestions(true)}
                        onBlur={() => {
                            // pequeño delay para permitir click
                            setTimeout(() => setShowSuggestions(false), 200);
                        }}
                    />

                    {showSuggestions && suggestions.length > 0 && (
                        <ul className="suggestions-list">
                            {suggestions.map((c) => (
                                <li
                                    key={c.id}
                                    onClick={() => handleSelectClient(c)}
                                >
                                    <strong>{c.nit}</strong> - {c.companyName}
                                </li>
                            ))}
                        </ul>
                    )}
                </div>
                <div>
                    <label >Nombre de razon social</label>
                    <input 
                        className="stylesInput"
                        type="text"
                        value = {name}
                        onChange={(e) => setName(e.target.value)} />
                </div>
            </div>
            <div>
                <label>Tipo de pago</label>
                <select 
                    className="stylesInput"
                    value={paymentType}
                    onChange={(e) => setPaymentType(e.target.value)}
                >
                    <option value="EFECTIVO">Efectivo</option>
                    <option value="QR">Pago por QR</option>
                </select>
            </div>
            <div className="styleContentTable">
                <table className="styleTable">
                    <thead className="stylesHead">
                        <tr>
                            <th className="stylesTh-td">Nombre</th>
                            <th className="stylesTh-td">Cantidad</th>
                            <th className="stylesTh-td">Descuento</th>
                            <th className="stylesTh-td">total</th>
                            <th className="stylesTh-td">Opciones</th>
                        </tr>
                    </thead>
                    <tbody className="stylesBody">
                        {cart.map((i, index) => (<>
                            <tr className="stylesTr" key={index} >
                                <td className="stylesTh-td">{i.comercialName}</td>
                                <td className="stylesThShopping">{i.quantity}</td>
                                <td className="stylesThShopping">{i.discount.toFixed(2)} bs</td>
                                <td className="stylesThShopping">{i.subTotal.toFixed(2)} bs</td>
                                <td>
                                    <div className="stylesContentButton-two">
                                        <button className="btnIcon edit" onClick={() => onEdit(i, index)}>
                                            <FiEdit />
                                        </button>

                                        <button className="btnIcon delete" onClick={() => onDelete(index)}>
                                            <FiTrash2 />
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </>))}
                    </tbody>
                </table>
            </div>
            
            <h4>Total Descuento: {totalDiscount.toFixed(2)} bs</h4>
            <h3>Sub Total: {totalFinal.toFixed(2)} bs</h3>

            <br />
            
            <br />
            <div className="stylesContenedorButton">
                <button className='stylesButoon' onClick={handlePedidoEImpresion}
                    >Realizar pedido e imprimri</button>  
            </div>
            
        </div>
        <ToastContainer/>
    </>)
}