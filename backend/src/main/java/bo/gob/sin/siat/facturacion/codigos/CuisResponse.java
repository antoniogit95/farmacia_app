
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cuisResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cuisResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaCuis" type="{https://siat.impuestos.gob.bo/}respuestaCuis" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cuisResponse", propOrder = {
    "respuestaCuis"
})
public class CuisResponse {

    @XmlElement(name = "RespuestaCuis")
    protected RespuestaCuis respuestaCuis;

    /**
     * Gets the value of the respuestaCuis property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaCuis }
     *     
     */
    public RespuestaCuis getRespuestaCuis() {
        return respuestaCuis;
    }

    /**
     * Sets the value of the respuestaCuis property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaCuis }
     *     
     */
    public void setRespuestaCuis(RespuestaCuis value) {
        this.respuestaCuis = value;
    }

}
