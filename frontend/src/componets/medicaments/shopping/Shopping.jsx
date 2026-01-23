import React, { useState } from "react";
import "./Shopping.css"
import PrintFile from "../../printer/PrinterFactura";
import { ToastContainer, toast } from "react-toastify";
import { URL_API_private } from "../../../providerContext/EndPoint";
import axios from "axios";

export const Shopping = ({ cart , setCart}) => {
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

    const handleClic = () => {
        const store = async () => {
            try {
                const response = await axios.post(endPoint,
                    {
                        clientNit: nit,
                        clientname: name,
                        userName: userName,
                        description: generarDescription(),
                        saleName: "",
                        subTotal: totalFinal,
                        discount: totalDiscount,
                        details : cart,

                    },
                    config
                )

                toast.success('pedido con exito', {
                    position: 'top-right',
                    autoClose: 3000,      
                });

                setCart([]);
                setNit("");
                setName("")
            } catch (error) {
                console.log(error);
                toast.error('error inesperado', {
                    position: 'top-right',
                    autoClose: 3000,      
                });
            }
        }
        

        if (cart.length >  0) {
            store()
        } else {
            toast.error('debe agregar un pedido antes', {
                position: 'top-right',
                autoClose: 3000,      
            });   
        }
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
                        total: {i.subTotal.toFixed(2)} bs
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