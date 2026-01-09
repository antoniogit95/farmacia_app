
package bo.gob.sin.siat.facturacion.operaciones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for verificacionEstadoFactura complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="verificacionEstadoFactura"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudServicioVerificacionEstadoFactura" type="{https://siat.impuestos.gob.bo/}solicitudVerificacionEstado"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verificacionEstadoFactura", propOrder = {
    "solicitudServicioVerificacionEstadoFactura"
})
public class VerificacionEstadoFactura {

    @XmlElement(name = "SolicitudServicioVerificacionEstadoFactura", required = true)
    protected SolicitudVerificacionEstado solicitudServicioVerificacionEstadoFactura;

    /**
     * Gets the value of the solicitudServicioVerificacionEstadoFactura property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudVerificacionEstado }
     *     
     */
    public SolicitudVerificacionEstado getSolicitudServicioVerificacionEstadoFactura() {
        return solicitudServicioVerificacionEstadoFactura;
    }

    /**
     * Sets the value of the solicitudServicioVerificacionEstadoFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudVerificacionEstado }
     *     
     */
    public void setSolicitudServicioVerificacionEstadoFactura(SolicitudVerificacionEstado value) {
        this.solicitudServicioVerificacionEstadoFactura = value;
    }

}
