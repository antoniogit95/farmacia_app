import React from "react";


export const Shopping = ({ cart }) => {
    console.log(cart);

    const totalFinal = cart.reduce((acc, item) => acc + parseFloat(item.total), 0);

    return(<>
        <div>
            <h3>Resumen de compra</h3>
            <ul>
                {cart.map((i) => (
                    <li key={i.id}>
                        {i.comercialName} - {i.quantity} - {i.total}
                    </li>
                ))}
            </ul>

            <h3>Total: {totalFinal.toFixed(2)} bs</h3>

            <button>Realizar pedido</button>
        </div>
    </>)
}