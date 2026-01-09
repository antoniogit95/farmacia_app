
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for registroPuntoVentaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registroPuntoVentaResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaRegistroPuntoVenta" type="{https://siat.impuestos.gob.bo/}respuestaRegistroPuntoVenta" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registroPuntoVentaResponse", propOrder = {
    "respuestaRegistroPuntoVenta"
})
public class RegistroPuntoVentaResponse {

    @XmlElement(name = "RespuestaRegistroPuntoVenta")
    protected RespuestaRegistroPuntoVenta respuestaRegistroPuntoVenta;

    /**
     * Gets the value of the respuestaRegistroPuntoVenta property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaRegistroPuntoVenta }
     *     
     */
    public RespuestaRegistroPuntoVenta getRespuestaRegistroPuntoVenta() {
        return respuestaRegistroPuntoVenta;
    }

    /**
     * Sets the value of the respuestaRegistroPuntoVenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaRegistroPuntoVenta }
     *     
     */
    public void setRespuestaRegistroPuntoVenta(RespuestaRegistroPuntoVenta value) {
        this.respuestaRegistroPuntoVenta = value;
    }

}
