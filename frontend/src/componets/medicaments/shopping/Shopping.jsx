import React, { useState } from "react";
import "./Shopping.css"
import PrintFile from "../../printer/PrinterFactura";
import { ToastContainer, toast } from "react-toastify";
import { URL_API_private } from "../../../providerContext/EndPoint";
import axios from "axios";

export const Shopping = ({ cart }) => {
    const [nit, setNit] = useState("");
    const [name, setName] = useState("");
    const token = JSON.parse(localStorage.getItem('user_data')).token;

    const endPoint = URL_API_private + "/sale/add";

    const totalFinal = cart.reduce((acc, item) => acc + parseFloat(item.total), 0);
    const totalDiscount = cart.reduce((acc, item) => acc + parseFloat(item.discount), 0);

    const config = {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    }

    const handleClic = () => {
        const store = async () => {
            try {
                const response = await axios.post(endPoint,
                    {
                        clientNit: nit,
                        clientname: name,
                        userId: "2",
                        description: "mensaje desde el front para mostrar",
                        saleName: "asdasd",
                        subTotal: totalFinal,
                        discount: totalDiscount,
                        details : cart,

                    },
                    config
                )
                console.log(response)
                toast.success('pedido con exito', {
                    position: 'top-right',
                    autoClose: 3000,      
                });
            } catch (error) {
                console.log(error);
                toast.error('error inesperado', {
                    position: 'top-right',
                    autoClose: 3000,      
                });
            }
        }
        
        store();
    }

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
            <ul className="styleSearchResult">
                {cart.map((i) => (
                    <li key={i.id}>
                        nombre: {i.comercialName} | 
                        cantidad: {i.quantity} unit | 
                        total descuento: {i.discount} bs | 
                        total: {i.total.toFixed(2)} bs
                    </li>
                ))}
            </ul>
            
            <h4>Total Descuento: {totalDiscount.toFixed(2)} bs</h4>
            <h3>Sub Total: {totalFinal.toFixed(2)} bs</h3>

            <PrintFile items={cart} />
            <br />
            
            <br />
            <div className="stylesContenedorButton">
                <button className='stylesButoon' onClick={handleClic}>Realizar pedido</button>  
            </div>
            
        </div>
        <ToastContainer/>
    </>)
}