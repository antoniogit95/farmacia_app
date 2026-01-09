
package bo.gob.sin.siat.facturacion.operaciones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultaPuntoVenta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultaPuntoVenta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudConsultaPuntoVenta" type="{https://siat.impuestos.gob.bo/}solicitudConsultaPuntoVenta"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaPuntoVenta", propOrder = {
    "solicitudConsultaPuntoVenta"
})
public class ConsultaPuntoVenta {

    @XmlElement(name = "SolicitudConsultaPuntoVenta", required = true)
    protected SolicitudConsultaPuntoVenta solicitudConsultaPuntoVenta;

    /**
     * Gets the value of the solicitudConsultaPuntoVenta property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudConsultaPuntoVenta }
     *     
     */
    public SolicitudConsultaPuntoVenta getSolicitudConsultaPuntoVenta() {
        return solicitudConsultaPuntoVenta;
    }

    /**
     * Sets the value of the solicitudConsultaPuntoVenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudConsultaPuntoVenta }
     *     
     */
    public void setSolicitudConsultaPuntoVenta(SolicitudConsultaPuntoVenta value) {
        this.solicitudConsultaPuntoVenta = value;
    }

}
