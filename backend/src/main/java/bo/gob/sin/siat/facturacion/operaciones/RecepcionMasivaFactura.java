
package bo.gob.sin.siat.facturacion.operaciones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recepcionMasivaFactura complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recepcionMasivaFactura"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudServicioRecepcionMasiva" type="{https://siat.impuestos.gob.bo/}solicitudRecepcionMasiva"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recepcionMasivaFactura", propOrder = {
    "solicitudServicioRecepcionMasiva"
})
public class RecepcionMasivaFactura {

    @XmlElement(name = "SolicitudServicioRecepcionMasiva", required = true)
    protected SolicitudRecepcionMasiva solicitudServicioRecepcionMasiva;

    /**
     * Gets the value of the solicitudServicioRecepcionMasiva property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudRecepcionMasiva }
     *     
     */
    public SolicitudRecepcionMasiva getSolicitudServicioRecepcionMasiva() {
        return solicitudServicioRecepcionMasiva;
    }

    /**
     * Sets the value of the solicitudServicioRecepcionMasiva property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudRecepcionMasiva }
     *     
     */
    public void setSolicitudServicioRecepcionMasiva(SolicitudRecepcionMasiva value) {
        this.solicitudServicioRecepcionMasiva = value;
    }

}
