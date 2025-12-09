import React, { useState } from "react";
import "./Shopping.css"
import PrintFile from "../../printer/PrinterFactura";

export const Shopping = ({ cart }) => {
    const [nit, setNit] = useState("");
    const [name, setName] = useState("");
    console.log(cart);

    const totalFinal = cart.reduce((acc, item) => acc + parseFloat(item.total), 0);

    return(<>
        <div>
            <h2 className="stylesH2Subtitule">Resumen de compra</h2>
            <div>
                <div>
                    <label >Numero de NIT o Carnet</label>
                    <input 
                        className="stylesInput"
                        type="text" />
                </div>
                <div>
                    <label >Nombre de razon social</label>
                    <input 
                        className="stylesInput"
                        type="text" />
                </div>
            </div>
            <ul className="styleSearchResult">
                {cart.map((i) => (
                    <li key={i.id}>
                        {i.comercialName} | {i.quantity} unit | {i.total.toFixed(2)} bs
                    </li>
                ))}
            </ul>

            <h3>Total: {totalFinal.toFixed(2)} bs</h3>

            <PrintFile items={cart} />
            <br />
            
            <br />
            <div className="stylesContenedorButton">
                <button className='stylesButoon'>Realizar pedido</button>  
            </div>
            
        </div>
    </>)
}