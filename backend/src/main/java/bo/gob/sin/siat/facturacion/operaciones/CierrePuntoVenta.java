
package bo.gob.sin.siat.facturacion.operaciones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cierrePuntoVenta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cierrePuntoVenta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudCierrePuntoVenta" type="{https://siat.impuestos.gob.bo/}solicitudCierrePuntoVenta"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cierrePuntoVenta", propOrder = {
    "solicitudCierrePuntoVenta"
})
public class CierrePuntoVenta {

    @XmlElement(name = "SolicitudCierrePuntoVenta", required = true)
    protected SolicitudCierrePuntoVenta solicitudCierrePuntoVenta;

    /**
     * Gets the value of the solicitudCierrePuntoVenta property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudCierrePuntoVenta }
     *     
     */
    public SolicitudCierrePuntoVenta getSolicitudCierrePuntoVenta() {
        return solicitudCierrePuntoVenta;
    }

    /**
     * Sets the value of the solicitudCierrePuntoVenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudCierrePuntoVenta }
     *     
     */
    public void setSolicitudCierrePuntoVenta(SolicitudCierrePuntoVenta value) {
        this.solicitudCierrePuntoVenta = value;
    }

}
