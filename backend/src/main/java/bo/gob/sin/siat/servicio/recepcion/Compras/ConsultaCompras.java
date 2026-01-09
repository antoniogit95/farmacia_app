
package bo.gob.sin.siat.servicio.recepcion.Compras;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultaCompras complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultaCompras"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudConsultaCompras" type="{https://siat.impuestos.gob.bo/}solicitudConsultaCompras"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaCompras", propOrder = {
    "solicitudConsultaCompras"
})
public class ConsultaCompras {

    @XmlElement(name = "SolicitudConsultaCompras", required = true)
    protected SolicitudConsultaCompras solicitudConsultaCompras;

    /**
     * Gets the value of the solicitudConsultaCompras property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudConsultaCompras }
     *     
     */
    public SolicitudConsultaCompras getSolicitudConsultaCompras() {
        return solicitudConsultaCompras;
    }

    /**
     * Sets the value of the solicitudConsultaCompras property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudConsultaCompras }
     *     
     */
    public void setSolicitudConsultaCompras(SolicitudConsultaCompras value) {
        this.solicitudConsultaCompras = value;
    }

}
