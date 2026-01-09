
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cufdMasivoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cufdMasivoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaCufdMasivo" type="{https://siat.impuestos.gob.bo/}respuestaCufdMasivo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cufdMasivoResponse", propOrder = {
    "respuestaCufdMasivo"
})
public class CufdMasivoResponse {

    @XmlElement(name = "RespuestaCufdMasivo")
    protected RespuestaCufdMasivo respuestaCufdMasivo;

    /**
     * Gets the value of the respuestaCufdMasivo property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaCufdMasivo }
     *     
     */
    public RespuestaCufdMasivo getRespuestaCufdMasivo() {
        return respuestaCufdMasivo;
    }

    /**
     * Sets the value of the respuestaCufdMasivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaCufdMasivo }
     *     
     */
    public void setRespuestaCufdMasivo(RespuestaCufdMasivo value) {
        this.respuestaCufdMasivo = value;
    }

}
