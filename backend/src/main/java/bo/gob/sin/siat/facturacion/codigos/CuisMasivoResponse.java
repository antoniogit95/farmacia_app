
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cuisMasivoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cuisMasivoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaCuisMasivo" type="{https://siat.impuestos.gob.bo/}respuestaCuisMasivo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cuisMasivoResponse", propOrder = {
    "respuestaCuisMasivo"
})
public class CuisMasivoResponse {

    @XmlElement(name = "RespuestaCuisMasivo")
    protected RespuestaCuisMasivo respuestaCuisMasivo;

    /**
     * Gets the value of the respuestaCuisMasivo property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaCuisMasivo }
     *     
     */
    public RespuestaCuisMasivo getRespuestaCuisMasivo() {
        return respuestaCuisMasivo;
    }

    /**
     * Sets the value of the respuestaCuisMasivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaCuisMasivo }
     *     
     */
    public void setRespuestaCuisMasivo(RespuestaCuisMasivo value) {
        this.respuestaCuisMasivo = value;
    }

}
