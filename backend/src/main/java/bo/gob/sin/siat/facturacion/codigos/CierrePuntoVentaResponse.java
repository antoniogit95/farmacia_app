
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cierrePuntoVentaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cierrePuntoVentaResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaCierrePuntoVenta" type="{https://siat.impuestos.gob.bo/}respuestaCierrePuntoVenta" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cierrePuntoVentaResponse", propOrder = {
    "respuestaCierrePuntoVenta"
})
public class CierrePuntoVentaResponse {

    @XmlElement(name = "RespuestaCierrePuntoVenta")
    protected RespuestaCierrePuntoVenta respuestaCierrePuntoVenta;

    /**
     * Gets the value of the respuestaCierrePuntoVenta property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaCierrePuntoVenta }
     *     
     */
    public RespuestaCierrePuntoVenta getRespuestaCierrePuntoVenta() {
        return respuestaCierrePuntoVenta;
    }

    /**
     * Sets the value of the respuestaCierrePuntoVenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaCierrePuntoVenta }
     *     
     */
    public void setRespuestaCierrePuntoVenta(RespuestaCierrePuntoVenta value) {
        this.respuestaCierrePuntoVenta = value;
    }

}
