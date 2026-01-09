
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for registroEventoSignificativo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registroEventoSignificativo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudEventoSignificativo" type="{https://siat.impuestos.gob.bo/}solicitudEventoSignificativo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registroEventoSignificativo", propOrder = {
    "solicitudEventoSignificativo"
})
public class RegistroEventoSignificativo {

    @XmlElement(name = "SolicitudEventoSignificativo", required = true)
    protected SolicitudEventoSignificativo solicitudEventoSignificativo;

    /**
     * Gets the value of the solicitudEventoSignificativo property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudEventoSignificativo }
     *     
     */
    public SolicitudEventoSignificativo getSolicitudEventoSignificativo() {
        return solicitudEventoSignificativo;
    }

    /**
     * Sets the value of the solicitudEventoSignificativo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudEventoSignificativo }
     *     
     */
    public void setSolicitudEventoSignificativo(SolicitudEventoSignificativo value) {
        this.solicitudEventoSignificativo = value;
    }

}
