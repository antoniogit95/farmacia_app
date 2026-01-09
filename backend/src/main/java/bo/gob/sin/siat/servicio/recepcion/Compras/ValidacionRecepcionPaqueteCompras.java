
package bo.gob.sin.siat.servicio.recepcion.Compras;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validacionRecepcionPaqueteCompras complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="validacionRecepcionPaqueteCompras"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudValidacionRecepcionCompras" type="{https://siat.impuestos.gob.bo/}solicitudValidacionRecepcionCompras"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validacionRecepcionPaqueteCompras", propOrder = {
    "solicitudValidacionRecepcionCompras"
})
public class ValidacionRecepcionPaqueteCompras {

    @XmlElement(name = "SolicitudValidacionRecepcionCompras", required = true)
    protected SolicitudValidacionRecepcionCompras solicitudValidacionRecepcionCompras;

    /**
     * Gets the value of the solicitudValidacionRecepcionCompras property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudValidacionRecepcionCompras }
     *     
     */
    public SolicitudValidacionRecepcionCompras getSolicitudValidacionRecepcionCompras() {
        return solicitudValidacionRecepcionCompras;
    }

    /**
     * Sets the value of the solicitudValidacionRecepcionCompras property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudValidacionRecepcionCompras }
     *     
     */
    public void setSolicitudValidacionRecepcionCompras(SolicitudValidacionRecepcionCompras value) {
        this.solicitudValidacionRecepcionCompras = value;
    }

}
