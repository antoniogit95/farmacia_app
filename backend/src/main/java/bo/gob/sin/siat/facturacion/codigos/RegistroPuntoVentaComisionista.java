
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for registroPuntoVentaComisionista complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registroPuntoVentaComisionista"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudPuntoVentaComisionista" type="{https://siat.impuestos.gob.bo/}solicitudPuntoVentaComisionista"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registroPuntoVentaComisionista", propOrder = {
    "solicitudPuntoVentaComisionista"
})
public class RegistroPuntoVentaComisionista {

    @XmlElement(name = "SolicitudPuntoVentaComisionista", required = true)
    protected SolicitudPuntoVentaComisionista solicitudPuntoVentaComisionista;

    /**
     * Gets the value of the solicitudPuntoVentaComisionista property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudPuntoVentaComisionista }
     *     
     */
    public SolicitudPuntoVentaComisionista getSolicitudPuntoVentaComisionista() {
        return solicitudPuntoVentaComisionista;
    }

    /**
     * Sets the value of the solicitudPuntoVentaComisionista property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudPuntoVentaComisionista }
     *     
     */
    public void setSolicitudPuntoVentaComisionista(SolicitudPuntoVentaComisionista value) {
        this.solicitudPuntoVentaComisionista = value;
    }

}
