
package bo.gob.sin.siat.facturacion.operaciones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anulacionFactura complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="anulacionFactura"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudServicioAnulacionFactura" type="{https://siat.impuestos.gob.bo/}solicitudAnulacion"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anulacionFactura", propOrder = {
    "solicitudServicioAnulacionFactura"
})
public class AnulacionFactura {

    @XmlElement(name = "SolicitudServicioAnulacionFactura", required = true)
    protected SolicitudAnulacion solicitudServicioAnulacionFactura;

    /**
     * Gets the value of the solicitudServicioAnulacionFactura property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudAnulacion }
     *     
     */
    public SolicitudAnulacion getSolicitudServicioAnulacionFactura() {
        return solicitudServicioAnulacionFactura;
    }

    /**
     * Sets the value of the solicitudServicioAnulacionFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudAnulacion }
     *     
     */
    public void setSolicitudServicioAnulacionFactura(SolicitudAnulacion value) {
        this.solicitudServicioAnulacionFactura = value;
    }

}
