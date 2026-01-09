package farmacia.backend.invoice;

import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import farmacia.backend.company.Branch;
import farmacia.backend.company.Company;
import farmacia.backend.company.CompanyService;
import farmacia.backend.invoice.cufd.Cufd;
import farmacia.backend.invoice.cufd.CufdService;
import farmacia.backend.invoice.cuis.CuisRepository;
import farmacia.backend.invoice.cuis.CuisService;
import farmacia.backend.sale.Sale;
import farmacia.backend.sale.saleDetail.SaleDetail;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvoiceService {
    
    private final InvoiceRepository invoiceRepository;
    private final CompanyService companyService;
    private final CufdService cufdService;

    public String generarXmlFactura(Sale sale, List<SaleDetail> saleDetail, Long numeroFactura) {
        try {

            Company company = companyService.getCompany();
            Branch branch = companyService.getBranch();

            Cufd cufd = cufdService.verificarOCrear(); 
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("FacturaElectronica");
            doc.appendChild(root);

            // CABECERA
            Element cabecera = doc.createElement("cabecera");
                root.appendChild(cabecera);

                agregarNodo(doc, cabecera, "nitEmisor", company.getNit());
                agregarNodo(doc, cabecera, "razonSocialEmisor", company.getRazonSocial());
                agregarNodo(doc, cabecera, "municipio", branch.getMunicipio());
                agregarNodo(doc, cabecera, "telefono", company.getTelefono());

                agregarNodo(doc, cabecera, "numeroFactura", numeroFactura.toString());
                agregarNodo(doc, cabecera, "cuf", "pober cuf");
                agregarNodo(doc, cabecera, "cufd", "poner cufd");

                agregarNodo(doc, cabecera, "codigoSucursal", branch.getCodigoSucursal().toString());
                agregarNodo(doc, cabecera, "direccion", branch.getDireccion());
                agregarNodo(doc, cabecera, "codigoPuntoVenta", branch.getCodigoPuntoVenta().toString());

                agregarNodo(doc, cabecera, "fechaEmision", formatearFechaSIN(sale.getCreatedAt()));

                agregarNodo(doc, cabecera, "nombreRazonSocial", sale.getClient().getCompanyName());
                agregarNodo(doc, cabecera, "codigoTipoDocumentoIdentidad", "1");
                agregarNodo(doc, cabecera, "numeroDocumento", sale.getClient().getNit());
                agregarNodo(doc, cabecera, "codigoCliente", sale.getClient().getNit());

                agregarNodo(doc, cabecera, "codigoMetodoPago", "1");

                agregarNodo(doc, cabecera, "montoTotal", String.valueOf(sale.getSubTotal()));
                agregarNodo(doc, cabecera, "montoTotalSujetoIva", String.valueOf(sale.getSubTotal()));

                agregarNodo(doc, cabecera, "codigoMoneda", "1");
                agregarNodo(doc, cabecera, "tipoCambio", "1");
                agregarNodo(doc, cabecera, "montoTotalMoneda", String.valueOf(sale.getSubTotal()));

                agregarNodo(doc, cabecera, "descuentoAdicional", "0");
                agregarNodo(doc, cabecera, "leyenda", company.getLeyendaFactura());
                agregarNodo(doc, cabecera, "usuario", sale.getUser().getUsername());
                agregarNodo(doc, cabecera, "codigoDocumentoSector", "1");

            // DETALLE
            Element detalle = doc.createElement("Detalle");
            root.appendChild(detalle);
            System.out.println("detalles -------: "+saleDetail.size()+"tamanio de los detalles");
            for (SaleDetail d : saleDetail) {
                Element item = doc.createElement("Item");
                detalle.appendChild(item);

                agregarNodo(doc, item, "Descripcion", d.getLote().getMedicament().getComercialName());
                agregarNodo(doc, item, "Cantidad", String.valueOf(d.getQuantity()));
                agregarNodo(doc, item, "PrecioUnitario", String.valueOf(d.getUnitPrice()));
                agregarNodo(doc, item, "descuento", String.valueOf(d.getDiscount()));
                agregarNodo(doc, item, "Subtotal", String.valueOf(d.getSubTotal()));
            }

            return transformarXmlAString(doc);

        } catch (Exception e) {
            throw new RuntimeException("Error generando XML de factura", e);
        }
    }

    private void agregarNodo(Document doc, Element parent, String nombre, String valor) {
        Element element = doc.createElement(nombre);
        element.appendChild(doc.createTextNode(valor));
        parent.appendChild(element);
    }

    private String transformarXmlAString(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        return writer.toString();
    }



    private String formatearFechaSIN(LocalDateTime dateTime){
        return LocalDateTime.now().toString();
    }

}
