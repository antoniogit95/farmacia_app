
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cierreOperacionesSistema complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cierreOperacionesSistema"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudOperaciones" type="{https://siat.impuestos.gob.bo/}solicitudOperaciones"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cierreOperacionesSistema", propOrder = {
    "solicitudOperaciones"
})
public class CierreOperacionesSistema {

    @XmlElement(name = "SolicitudOperaciones", required = true)
    protected SolicitudOperaciones solicitudOperaciones;

    /**
     * Gets the value of the solicitudOperaciones property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudOperaciones }
     *     
     */
    public SolicitudOperaciones getSolicitudOperaciones() {
        return solicitudOperaciones;
    }

    /**
     * Sets the value of the solicitudOperaciones property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudOperaciones }
     *     
     */
    public void setSolicitudOperaciones(SolicitudOperaciones value) {
        this.solicitudOperaciones = value;
    }

}
