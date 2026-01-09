
package bo.gob.sin.siat.facturacion.operaciones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recepcionFactura complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recepcionFactura"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudServicioRecepcionFactura" type="{https://siat.impuestos.gob.bo/}solicitudRecepcionFactura"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recepcionFactura", propOrder = {
    "solicitudServicioRecepcionFactura"
})
public class RecepcionFactura {

    @XmlElement(name = "SolicitudServicioRecepcionFactura", required = true)
    protected SolicitudRecepcionFactura solicitudServicioRecepcionFactura;

    /**
     * Gets the value of the solicitudServicioRecepcionFactura property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudRecepcionFactura }
     *     
     */
    public SolicitudRecepcionFactura getSolicitudServicioRecepcionFactura() {
        return solicitudServicioRecepcionFactura;
    }

    /**
     * Sets the value of the solicitudServicioRecepcionFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudRecepcionFactura }
     *     
     */
    public void setSolicitudServicioRecepcionFactura(SolicitudRecepcionFactura value) {
        this.solicitudServicioRecepcionFactura = value;
    }

}
