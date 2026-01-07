
package bo.gob.sin.siat.facturacion.sincronizacion;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sincronizarParametricaMotivoAnulacionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sincronizarParametricaMotivoAnulacionResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaListaParametricas" type="{https://siat.impuestos.gob.bo/}respuestaListaParametricas" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sincronizarParametricaMotivoAnulacionResponse", propOrder = {
    "respuestaListaParametricas"
})
public class SincronizarParametricaMotivoAnulacionResponse {

    @XmlElement(name = "RespuestaListaParametricas")
    protected RespuestaListaParametricas respuestaListaParametricas;

    /**
     * Gets the value of the respuestaListaParametricas property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaListaParametricas }
     *     
     */
    public RespuestaListaParametricas getRespuestaListaParametricas() {
        return respuestaListaParametricas;
    }

    /**
     * Sets the value of the respuestaListaParametricas property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaListaParametricas }
     *     
     */
    public void setRespuestaListaParametricas(RespuestaListaParametricas value) {
        this.respuestaListaParametricas = value;
    }

}
