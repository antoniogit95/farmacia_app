import { useState } from "react";
import PrintFile from "../printer/PrinterFactura";
import "./Ventas.css";

export const Ventas = () => {
    const [items, setItems] = useState([
        { id: 1, product: "", quantity: 1, price: 0, discount: 0 },
    ]);

    const handleChange = (id, field, value) => {
        setItems((prev) =>
            prev.map((item) =>
                item.id === id ? { ...item, [field]: value } : item
            )
        );
    };

    const addItem = () => {
        setItems((prev) => [
            ...prev,
            {
                id: Date.now(),
                product: "",
                quantity: 1,
                price: 0,
                discount: 0,
            },
        ]);
    };

    const calcularTotalItem = (item) => {
        const subtotal = item.quantity * item.price;
        const desc = (subtotal * item.discount) / 100;
        return subtotal - desc;
    };

    const totalGeneral = items.reduce(
        (acc, item) => acc + calcularTotalItem(item),
        0
    );

    return (
        <div className="">
            <h2 className="styleH2">Registro de ventas</h2>

            <div className="header-row">
                <span>Producto</span>
                <span>Cant.</span>
                <span>Precio Unit</span>
                <span>Desc %</span>
                <span>Total</span>
                <span></span>
            </div>

            {items.map((item) => (
                <div className="item-row" key={item.id}>
                    <input
                        type="text"
                        placeholder="Producto"
                        value={item.product}
                        onChange={(e) => handleChange(item.id, "product", e.target.value)}
                    />

                    <input
                        type="number"
                        placeholder="Cant."
                        min="1"
                        value={item.quantity}
                        onChange={(e) => handleChange(item.id, "quantity", e.target.value)}
                    />

                    <input
                        type="number"
                        placeholder="Precio"
                        min="0"
                        value={item.price}
                        onChange={(e) => handleChange(item.id, "price", e.target.value)}
                    />

                    <input
                        type="number"
                        placeholder="Desc %"
                        min="0"
                        max="100"
                        value={item.discount}
                        onChange={(e) => handleChange(item.id, "discount", e.target.value)}
                    />

                    <input
                        type="text"
                        disabled
                        value={calcularTotalItem(item).toFixed(2)}
                        className="total-field"
                    />

                    <button onClick={addItem}>+</button>
                </div>
            ))}

            {/*Total General */}
            <div className="total-general">
                <h3>Total General: {totalGeneral.toFixed(2)} Bs</h3>
            </div>

            {/* Botón para imprimir */}
            <PrintFile items={items} totalGeneral={totalGeneral} />
        </div>
    );
};
