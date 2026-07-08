import jsPDF from "jspdf";

export const printFactura = ({ items, nit, companyName, payments = [], total = 0, totalPaid = 0 }) => {
    const doc = new jsPDF({
        orientation: "portrait",
        unit: "mm",
        format: [80, 400],
    });

    let y = 8;

    doc.setFontSize(9);
    doc.text("RESUMEN DE COMPRAS", 40, y, { align: "center" });
    y += 5;

    doc.setFontSize(10);
    doc.text("FARMACIA TELLEZ", 40, y, { align: "center" });
    y += 4;

    doc.setFontSize(7);
    doc.text("ZONA TACOPOCA - AV. INGAVI\nESQ. SANTA CRUZ", 40, y, {
        align: "center",
    });
    y += 6;

    doc.text(
        `Fecha: ${new Date().toLocaleString("es-BO", { hour12: false })}`,
        5,
        y
    );
    y += 4;

    doc.line(5, y, 75, y);
    y += 4;

    doc.setFontSize(8);
    doc.text(`NIT/CI: ${nit || "S/N"}`, 5, y);
    y += 4;

    doc.text(`Razón Social: ${companyName || "S/N"}`, 5, y);
    y += 5;

    doc.line(5, y, 75, y);
    y += 4;

    let totalItems = 0;

    items.forEach((item) => {
        const quantity = Number(item.quantity) || 0;
        const price = Number(item.unitPrice) || 0;
        const descuento = Number(item.discount) || 0;
        const final = Number(item.subTotal) || 0;

        totalItems += final;

        doc.text(item.comercialName || "", 5, y);
        y += 4;

        doc.text(`${quantity} x ${price.toFixed(2)} Bs`, 5, y);
        y += 4;

        if (descuento > 0) {
            doc.text(`Desc: ${descuento.toFixed(2)} Bs`, 5, y);
            y += 4;
        }

        doc.text(`Subtotal: ${final.toFixed(2)} Bs`, 5, y);
        y += 4;

        doc.line(5, y, 75, y);
        y += 3;
    });

    y += 2;

    doc.setFontSize(10);
    doc.text(`TOTAL: ${total.toFixed(2)} Bs`, 5, y);
    y += 6;

    // 🔥 METODOS DE PAGO
    doc.setFontSize(7);
    doc.text("METODOS DE PAGO", 5, y);
    y += 4;

    payments.forEach((p) => {
        const amount = Number(p.amount) || 0;
        doc.text(`${p.paymentType}: ${amount.toFixed(2)} Bs`, 5, y);
        y += 4;
    });

    y += 2;

    doc.text(`PAGADO: ${totalPaid.toFixed(2)} Bs`, 5, y);
    y += 4;

    const cambio = totalPaid - total;

    if (cambio > 0) {
        doc.text(`CAMBIO: ${cambio.toFixed(2)} Bs`, 5, y);
        y += 4;
    }

    doc.line(5, y, 75, y);
    y += 5;

    doc.setFontSize(6);
    doc.text("GRACIAS POR SU COMPRA", 40, y, { align: "center" });

    // 🔥 GENERAR PDF EN MEMORIA
    const blob = doc.output("blob");
    const url = URL.createObjectURL(blob);

    const iframe = document.createElement("iframe");
    iframe.style.display = "none";
    iframe.src = url;

    document.body.appendChild(iframe);

    iframe.onload = () => {
        iframe.contentWindow.focus();
        iframe.contentWindow.print();
    };
};