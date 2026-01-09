
package bo.gob.sin.siat.servicio.facturacion.CompraVenta;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validacionRecepcionMasivaFactura complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="validacionRecepcionMasivaFactura"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudServicioValidacionRecepcionMasiva" type="{https://siat.impuestos.gob.bo/}solicitudValidacionRecepcion"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validacionRecepcionMasivaFactura", propOrder = {
    "solicitudServicioValidacionRecepcionMasiva"
})
public class ValidacionRecepcionMasivaFactura {

    @XmlElement(name = "SolicitudServicioValidacionRecepcionMasiva", required = true)
    protected SolicitudValidacionRecepcion solicitudServicioValidacionRecepcionMasiva;

    /**
     * Gets the value of the solicitudServicioValidacionRecepcionMasiva property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudValidacionRecepcion }
     *     
     */
    public SolicitudValidacionRecepcion getSolicitudServicioValidacionRecepcionMasiva() {
        return solicitudServicioValidacionRecepcionMasiva;
    }

    /**
     * Sets the value of the solicitudServicioValidacionRecepcionMasiva property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudValidacionRecepcion }
     *     
     */
    public void setSolicitudServicioValidacionRecepcionMasiva(SolicitudValidacionRecepcion value) {
        this.solicitudServicioValidacionRecepcionMasiva = value;
    }

}
