import React, { useState } from "react";
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
    const personData = JSON.parse(localStorage.getItem('user_data')); 
    const token = personData.token;
    const userName = personData.username;
    const endPoint = URL_API_private + "/sale/add";


    //const endPoint = URL_API_private + "/firma/factura";
    
    const totalFinal = cart.reduce((acc, item) => acc + parseFloat(item.subTotal), 0);

    const totalDiscount = cart.reduce((acc, item) => acc + parseFloat(item.discount), 0);

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

    return(<>
        <div>
            <h2 className="stylesH2Subtitule">Resumen de compra</h2>
            <div>
                <div>
                    <label >Numero de NIT o Carnet</label>
                    <input 
                        className="stylesInput"
                        type="text" 
                        value = {nit}
                        onChange={(e) => setNit(e.target.value)}
                        />

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