
package bo.gob.sin.siat.facturacion.operaciones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recepcionAnexosResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recepcionAnexosResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaRecepcionAnexos" type="{https://siat.impuestos.gob.bo/}respuestaRecepcion" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recepcionAnexosResponse", propOrder = {
    "respuestaRecepcionAnexos"
})
public class RecepcionAnexosResponse {

    @XmlElement(name = "RespuestaRecepcionAnexos")
    protected RespuestaRecepcion respuestaRecepcionAnexos;

    /**
     * Gets the value of the respuestaRecepcionAnexos property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaRecepcion }
     *     
     */
    public RespuestaRecepcion getRespuestaRecepcionAnexos() {
        return respuestaRecepcionAnexos;
    }

    /**
     * Sets the value of the respuestaRecepcionAnexos property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaRecepcion }
     *     
     */
    public void setRespuestaRecepcionAnexos(RespuestaRecepcion value) {
        this.respuestaRecepcionAnexos = value;
    }

}
