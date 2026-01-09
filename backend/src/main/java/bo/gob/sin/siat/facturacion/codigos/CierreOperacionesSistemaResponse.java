
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cierreOperacionesSistemaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cierreOperacionesSistemaResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaCierreSistemas" type="{https://siat.impuestos.gob.bo/}respuestaCierreSistemas" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cierreOperacionesSistemaResponse", propOrder = {
    "respuestaCierreSistemas"
})
public class CierreOperacionesSistemaResponse {

    @XmlElement(name = "RespuestaCierreSistemas")
    protected RespuestaCierreSistemas respuestaCierreSistemas;

    /**
     * Gets the value of the respuestaCierreSistemas property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaCierreSistemas }
     *     
     */
    public RespuestaCierreSistemas getRespuestaCierreSistemas() {
        return respuestaCierreSistemas;
    }

    /**
     * Sets the value of the respuestaCierreSistemas property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaCierreSistemas }
     *     
     */
    public void setRespuestaCierreSistemas(RespuestaCierreSistemas value) {
        this.respuestaCierreSistemas = value;
    }

}
