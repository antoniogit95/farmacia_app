
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cufdMasivo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cufdMasivo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudCufdMasivo" type="{https://siat.impuestos.gob.bo/}solicitudCufdMasivo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cufdMasivo", propOrder = {
    "solicitudCufdMasivo"
})
public class CufdMasivo {

    @XmlElement(name = "SolicitudCufdMasivo", required = true)
    protected SolicitudCufdMasivo solicitudCufdMasivo;

    /**
     * Gets the value of the solicitudCufdMasivo property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudCufdMasivo }
     *     
     */
    public SolicitudCufdMasivo getSolicitudCufdMasivo() {
        return solicitudCufdMasivo;
    }

    /**
     * Sets the value of the solicitudCufdMasivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudCufdMasivo }
     *     
     */
    public void setSolicitudCufdMasivo(SolicitudCufdMasivo value) {
        this.solicitudCufdMasivo = value;
    }

}
