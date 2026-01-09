
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for verificarNitResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="verificarNitResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaVerificarNit" type="{https://siat.impuestos.gob.bo/}respuestaVerificarNit" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verificarNitResponse", propOrder = {
    "respuestaVerificarNit"
})
public class VerificarNitResponse {

    @XmlElement(name = "RespuestaVerificarNit")
    protected RespuestaVerificarNit respuestaVerificarNit;

    /**
     * Gets the value of the respuestaVerificarNit property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaVerificarNit }
     *     
     */
    public RespuestaVerificarNit getRespuestaVerificarNit() {
        return respuestaVerificarNit;
    }

    /**
     * Sets the value of the respuestaVerificarNit property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaVerificarNit }
     *     
     */
    public void setRespuestaVerificarNit(RespuestaVerificarNit value) {
        this.respuestaVerificarNit = value;
    }

}
