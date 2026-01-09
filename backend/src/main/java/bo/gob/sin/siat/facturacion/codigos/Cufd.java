
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cufd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cufd"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudCufd" type="{https://siat.impuestos.gob.bo/}solicitudCufd"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cufd", propOrder = {
    "solicitudCufd"
})
public class Cufd {

    @XmlElement(name = "SolicitudCufd", required = true)
    protected SolicitudCufd solicitudCufd;

    /**
     * Gets the value of the solicitudCufd property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudCufd }
     *     
     */
    public SolicitudCufd getSolicitudCufd() {
        return solicitudCufd;
    }

    /**
     * Sets the value of the solicitudCufd property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudCufd }
     *     
     */
    public void setSolicitudCufd(SolicitudCufd value) {
        this.solicitudCufd = value;
    }

}
