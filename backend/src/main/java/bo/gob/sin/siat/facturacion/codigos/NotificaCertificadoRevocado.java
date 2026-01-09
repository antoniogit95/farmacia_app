
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for notificaCertificadoRevocado complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="notificaCertificadoRevocado"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudNotificaRevocado" type="{https://siat.impuestos.gob.bo/}solicitudNotifcaRevocado"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notificaCertificadoRevocado", propOrder = {
    "solicitudNotificaRevocado"
})
public class NotificaCertificadoRevocado {

    @XmlElement(name = "SolicitudNotificaRevocado", required = true)
    protected SolicitudNotifcaRevocado solicitudNotificaRevocado;

    /**
     * Gets the value of the solicitudNotificaRevocado property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudNotifcaRevocado }
     *     
     */
    public SolicitudNotifcaRevocado getSolicitudNotificaRevocado() {
        return solicitudNotificaRevocado;
    }

    /**
     * Sets the value of the solicitudNotificaRevocado property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudNotifcaRevocado }
     *     
     */
    public void setSolicitudNotificaRevocado(SolicitudNotifcaRevocado value) {
        this.solicitudNotificaRevocado = value;
    }

}
