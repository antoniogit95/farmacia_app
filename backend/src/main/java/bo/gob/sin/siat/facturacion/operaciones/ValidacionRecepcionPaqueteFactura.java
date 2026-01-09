
package bo.gob.sin.siat.facturacion.operaciones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validacionRecepcionPaqueteFactura complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="validacionRecepcionPaqueteFactura"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudServicioValidacionRecepcionPaquete" type="{https://siat.impuestos.gob.bo/}solicitudValidacionRecepcion"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validacionRecepcionPaqueteFactura", propOrder = {
    "solicitudServicioValidacionRecepcionPaquete"
})
public class ValidacionRecepcionPaqueteFactura {

    @XmlElement(name = "SolicitudServicioValidacionRecepcionPaquete", required = true)
    protected SolicitudValidacionRecepcion solicitudServicioValidacionRecepcionPaquete;

    /**
     * Gets the value of the solicitudServicioValidacionRecepcionPaquete property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudValidacionRecepcion }
     *     
     */
    public SolicitudValidacionRecepcion getSolicitudServicioValidacionRecepcionPaquete() {
        return solicitudServicioValidacionRecepcionPaquete;
    }

    /**
     * Sets the value of the solicitudServicioValidacionRecepcionPaquete property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudValidacionRecepcion }
     *     
     */
    public void setSolicitudServicioValidacionRecepcionPaquete(SolicitudValidacionRecepcion value) {
        this.solicitudServicioValidacionRecepcionPaquete = value;
    }

}
