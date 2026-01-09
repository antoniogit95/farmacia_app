
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for notificaCertificadoRevocadoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="notificaCertificadoRevocadoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaNotificaRevocado" type="{https://siat.impuestos.gob.bo/}respuestaNotificaRevocado" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notificaCertificadoRevocadoResponse", propOrder = {
    "respuestaNotificaRevocado"
})
public class NotificaCertificadoRevocadoResponse {

    @XmlElement(name = "RespuestaNotificaRevocado")
    protected RespuestaNotificaRevocado respuestaNotificaRevocado;

    /**
     * Gets the value of the respuestaNotificaRevocado property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaNotificaRevocado }
     *     
     */
    public RespuestaNotificaRevocado getRespuestaNotificaRevocado() {
        return respuestaNotificaRevocado;
    }

    /**
     * Sets the value of the respuestaNotificaRevocado property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaNotificaRevocado }
     *     
     */
    public void setRespuestaNotificaRevocado(RespuestaNotificaRevocado value) {
        this.respuestaNotificaRevocado = value;
    }

}
