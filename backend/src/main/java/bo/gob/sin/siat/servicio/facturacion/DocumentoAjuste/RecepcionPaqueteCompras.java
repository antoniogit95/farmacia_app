
package bo.gob.sin.siat.servicio.facturacion.DocumentoAjuste;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recepcionPaqueteCompras complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recepcionPaqueteCompras"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudRecepcionCompras" type="{https://siat.impuestos.gob.bo/}solicitudRecepcionCompras"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recepcionPaqueteCompras", propOrder = {
    "solicitudRecepcionCompras"
})
public class RecepcionPaqueteCompras {

    @XmlElement(name = "SolicitudRecepcionCompras", required = true)
    protected SolicitudRecepcionCompras solicitudRecepcionCompras;

    /**
     * Gets the value of the solicitudRecepcionCompras property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudRecepcionCompras }
     *     
     */
    public SolicitudRecepcionCompras getSolicitudRecepcionCompras() {
        return solicitudRecepcionCompras;
    }

    /**
     * Sets the value of the solicitudRecepcionCompras property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudRecepcionCompras }
     *     
     */
    public void setSolicitudRecepcionCompras(SolicitudRecepcionCompras value) {
        this.solicitudRecepcionCompras = value;
    }

}
