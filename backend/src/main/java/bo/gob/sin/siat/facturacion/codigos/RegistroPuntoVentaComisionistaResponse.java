
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for registroPuntoVentaComisionistaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registroPuntoVentaComisionistaResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaPuntoVentaComisionista" type="{https://siat.impuestos.gob.bo/}respuestaPuntoVentaComisionista" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registroPuntoVentaComisionistaResponse", propOrder = {
    "respuestaPuntoVentaComisionista"
})
public class RegistroPuntoVentaComisionistaResponse {

    @XmlElement(name = "RespuestaPuntoVentaComisionista")
    protected RespuestaPuntoVentaComisionista respuestaPuntoVentaComisionista;

    /**
     * Gets the value of the respuestaPuntoVentaComisionista property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaPuntoVentaComisionista }
     *     
     */
    public RespuestaPuntoVentaComisionista getRespuestaPuntoVentaComisionista() {
        return respuestaPuntoVentaComisionista;
    }

    /**
     * Sets the value of the respuestaPuntoVentaComisionista property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaPuntoVentaComisionista }
     *     
     */
    public void setRespuestaPuntoVentaComisionista(RespuestaPuntoVentaComisionista value) {
        this.respuestaPuntoVentaComisionista = value;
    }

}
