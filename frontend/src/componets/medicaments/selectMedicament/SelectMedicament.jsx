import React, { useState } from "react";

export const SelectMedicament = ({item, onAdd}) => {
    const [quantity, setQuantity] = useState(1);
    const [price, setPrice] = useState(0.0);
    const [discount, setDiscount] = useState(0.0);

    if(!item) return <h2> Selecciona un producto</h2>

    const total = (quantity * price) * (1 -discount/100);

    return (<>
        <div>
            <h3>medicamento seleccionado</h3>
            <p>{item.genericName} {item.consentration} {item.laboratory}</p>
            
            <label>Precio</label>
            <input 
                type="text"
                value={price}
                onChange={(e) => setPrice(e.target.value)} />

            <label>Cantidad</label>
            <input 
                type="text"
                value={quantity}
                onChange={(e) => setQuantity(e.target.value)} />

            <label>Descuento</label>
            <input 
                type="text"
                value={discount}
                onChange={(e) => setDiscount(e.target.value)} />

            <p>total: {total.toFixed(2)}</p>
            <button onClick={() => onAdd({ ...item, quantity, price, discount, total})}>
                Agregarl al carrito
            </button>
        </div>
    </>)
   
}