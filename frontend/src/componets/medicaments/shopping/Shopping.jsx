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
    const [payments, setPayments] = useState([]);


    //const endPoint = URL_API_private + "/firma/factura";
    
    const totalFinal = cart.reduce((acc, item) => acc + parseFloat(item.subTotal), 0);

    const totalDiscount = cart.reduce((acc, item) => acc + parseFloat(item.discount), 0);

    const totalPaid = payments.reduce(
        (acc, p) => acc + (parseFloat(p.amount) || 0),
        0
    );

    const restante = totalFinal - totalPaid;

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
            toast.error("Debe agregar productos");
            return;
        }

        if (payments.length === 0) {
            toast.error("Debe agregar un metodo de pago");
            return;
        }

        if (totalPaid < totalFinal) {
            toast.error("Falta completar el pago");
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
                payments: pagosAjustados,
            },
            config
            );

            toast.success("Pedido realizado", { autoClose: 2000 });

            // 🔥 IMPRIMIR AUTOMÁTICAMENTE
            printFactura({
                items: cart,
                nit,
                companyName: name,
                payments: ajustarPagos(),
                total: totalFinal,
                totalPaid: totalPaid
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
    
    const addPayment = () => {
        setPayments([
            ...payments,
            { paymentType: "EFECTIVO", amount: "" }
        ]);
    };

    const updatePaymentType = (index, type) => {
        const updated = [...payments];
        updated[index].paymentType = type;
        setPayments(updated);
    };

    const updateAmount = (index, value) => {

        const updated = [...payments];

        updated[index].amount = value;

        setPayments(updated);
    };

    const ajustarPagos = () => {

        let restante = totalFinal;

        const pagosAjustados = payments.map(p => {

            let monto = parseFloat(p.amount) || 0;

            if (restante <= 0) {
                monto = 0;
            } 
            else if (monto > restante) {
                monto = restante;
            }

            restante -= monto;

            return {
                paymentType: p.paymentType,
                amount: monto
            };
        });

        return pagosAjustados;
    };

    const pagosAjustados = ajustarPagos();

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

                <h3>Metodos de pago</h3>

                <button className="stylesButoon" onClick={addPayment}>
                    Agregar metodo de pago
                </button>

                {payments.map((p, index) => (

                <div key={index} className="paymentRow">

                    <select
                        className="paymentType"
                        value={p.paymentType}
                        onChange={(e)=>updatePaymentType(index,e.target.value)}
                    >
                        <option value="EFECTIVO">Efectivo</option>
                        <option value="QR">QR</option>
                    </select>

                    <input
                        className="paymentAmount"
                        type="number"
                        placeholder="Monto"
                        value={p.amount}
                        onChange={(e)=>updateAmount(index,e.target.value)}
                    />

                </div>

                ))}

                <br />
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
            <h4>Total Pagado: {totalPaid.toFixed(2)} bs</h4>

            {restante > 0 && (
                <h4 style={{color:"red"}}>
                Falta pagar: {restante.toFixed(2)} bs
                </h4>
            )}

            {restante < 0 && (
                <h4 style={{color:"green"}}>
                    Cambio: {(restante * -1).toFixed(2)} bs
                </h4>
            )}
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