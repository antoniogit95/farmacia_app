
package bo.gob.sin.siat.servicio.facturacion.DocumentoAjuste;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anulacionCompra complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="anulacionCompra"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudAnulacionCompra" type="{https://siat.impuestos.gob.bo/}solicitudAnulacionCompra"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anulacionCompra", propOrder = {
    "solicitudAnulacionCompra"
})
public class AnulacionCompra {

    @XmlElement(name = "SolicitudAnulacionCompra", required = true)
    protected SolicitudAnulacionCompra solicitudAnulacionCompra;

    /**
     * Gets the value of the solicitudAnulacionCompra property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudAnulacionCompra }
     *     
     */
    public SolicitudAnulacionCompra getSolicitudAnulacionCompra() {
        return solicitudAnulacionCompra;
    }

    /**
     * Sets the value of the solicitudAnulacionCompra property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudAnulacionCompra }
     *     
     */
    public void setSolicitudAnulacionCompra(SolicitudAnulacionCompra value) {
        this.solicitudAnulacionCompra = value;
    }

}
