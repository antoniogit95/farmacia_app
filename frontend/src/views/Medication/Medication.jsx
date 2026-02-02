import React, { useState } from "react";
import { NavBar } from "../../componets/NavBar/NavBar";
import './Medication.css';
import { SearchMedicament } from "../../componets/medicaments/searchMedicament/SearchMedicament";
import { SelectMedicament } from "../../componets/medicaments/selectMedicament/SelectMedicament";
import { Shopping } from "../../componets/medicaments/shopping/Shopping";

export const Medication = () => {

    const [selectItem, setSelectItem] = useState(null);
    const [cart, setCart] = useState([]);
    const [editingIndex, setEditingIndex] = useState(null);

    const addToCart = (item) => {
        setCart(prev => {
            
            // si estamos editando
            if (editingIndex !== null) {
                const copy = [...prev];
                copy[editingIndex] = item;
                return copy;
            }

            // evitar duplicados (mismo medicamento + mismo lote)
            const index = prev.findIndex(
                p => p.id === item.id && p.loteId === item.loteId
            );

            if (index !== -1) {
                const copy = [...prev];
                copy[index] = item;
                return copy;
            }

            return [...prev, item];
        });

        setSelectItem(null);
        setEditingIndex(null);
    };

    /** Editar desde Shopping */
    const handleEdit = (item, index) => {
        setSelectItem(item);
        setEditingIndex(index);
    };

    /** Borrar */
    const handleDelete = (index) => {
        setCart(prev => prev.filter((_, i) => i !== index));
    };

    return (
        <>
            <NavBar />
            <div className="stylesContentMedicament">
                <div className="styleContentMedicament-thre">
                    <div className="styleWindowsColumn">
                        <SearchMedicament onSelect={setSelectItem} />
                    </div>

                    <div className="styleWindowsColumn">
                        <SelectMedicament
                            item={selectItem}
                            onAdd={addToCart}
                            isEditing={editingIndex !== null}
                        />
                    </div>

                    <div className="styleWindowsColumn">
                        <Shopping
                            cart={cart}
                            setCart={setCart}
                            onEdit={handleEdit}
                            onDelete={handleDelete}
                        />
                    </div>
                </div>
            </div>
        </>
    );
};
