import React from "react";
import jsPDF from "jspdf";
import "./PrinterFactura.css"

export default function PrintFile({ items }) {
    const generatePDF = () => {

    const doc = new jsPDF({
        orientation: "portrait",
        unit: "mm",
        format: [80, 200], // tamaño tipo ticket 80mm
    });

    let y = 10;

    // Encabezado de farmacia
    doc.setFontSize(12);
    doc.text("RESUMEN DE COMPRAS", 10, y);
    y += 6;

    doc.setFontSize(14);
    doc.text("FARMACIA TELLEZ", 10, y);
    y += 6;


    doc.setFontSize(10);
    doc.text("ZONA TACOPOCA, AV. INGAVI \nESQ. SANTA CRUZ", 10, y);
    y += 6;

    doc.setFontSize(10);
    doc.text("", 10, y);
    y += 6;

    doc.setFontSize(10);
    doc.text("TELEFONO: 71752959", 10, y);
    y += 6;

    doc.setFontSize(12);
    doc.text("EMAIL: farmaciatellez1@gmail.com", 10, y);
    y += 6;

    doc.text("Fecha: " + new Date().toLocaleString(), 10, y);
    y += 8;

    doc.line(5, y, 75, y); // línea horizontal
    y += 4;

    let total = 0;

    items.forEach((item) => {
        console.log(item);
        const subtotal = item.quantity * item.price;
        const descuento = (subtotal * item.discount) / 100;
        const final = subtotal - descuento;
        total += final;

        doc.setFontSize(10);
        doc.text(`${item.product}`, 5, y);
        y += 4;

        doc.text(
            `${item.quantity} x ${item.price}   Desc: ${item.discount}%`,
        5,
        y
      );
      y += 4;

      doc.text(`Subtotal: ${final.toFixed(2)} Bs`, 5, y);
      y += 6;

      doc.line(5, y, 75, y);
      y += 4;
    });

    y += 4;

    doc.setFontSize(12);
    doc.text(`TOTAL: ${total.toFixed(2)} Bs`, 10, y);

    // Guardar PDF
    doc.save("factura.pdf");
  };

  return (
    <button
      className="stylesButoonPrinter"
      onClick={generatePDF}
      
    >
      Imprimir PDF
    </button>
  );
}
