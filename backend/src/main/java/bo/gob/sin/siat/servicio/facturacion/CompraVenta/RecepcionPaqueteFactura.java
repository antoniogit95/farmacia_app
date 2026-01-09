
package bo.gob.sin.siat.servicio.facturacion.CompraVenta;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recepcionPaqueteFactura complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recepcionPaqueteFactura"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudServicioRecepcionPaquete" type="{https://siat.impuestos.gob.bo/}solicitudRecepcionPaquete"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recepcionPaqueteFactura", propOrder = {
    "solicitudServicioRecepcionPaquete"
})
public class RecepcionPaqueteFactura {

    @XmlElement(name = "SolicitudServicioRecepcionPaquete", required = true)
    protected SolicitudRecepcionPaquete solicitudServicioRecepcionPaquete;

    /**
     * Gets the value of the solicitudServicioRecepcionPaquete property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudRecepcionPaquete }
     *     
     */
    public SolicitudRecepcionPaquete getSolicitudServicioRecepcionPaquete() {
        return solicitudServicioRecepcionPaquete;
    }

    /**
     * Sets the value of the solicitudServicioRecepcionPaquete property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudRecepcionPaquete }
     *     
     */
    public void setSolicitudServicioRecepcionPaquete(SolicitudRecepcionPaquete value) {
        this.solicitudServicioRecepcionPaquete = value;
    }

}
