
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultaEventoSignificativo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultaEventoSignificativo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudConsultaEvento" type="{https://siat.impuestos.gob.bo/}solicitudConsultaEvento"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaEventoSignificativo", propOrder = {
    "solicitudConsultaEvento"
})
public class ConsultaEventoSignificativo {

    @XmlElement(name = "SolicitudConsultaEvento", required = true)
    protected SolicitudConsultaEvento solicitudConsultaEvento;

    /**
     * Gets the value of the solicitudConsultaEvento property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudConsultaEvento }
     *     
     */
    public SolicitudConsultaEvento getSolicitudConsultaEvento() {
        return solicitudConsultaEvento;
    }

    /**
     * Sets the value of the solicitudConsultaEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudConsultaEvento }
     *     
     */
    public void setSolicitudConsultaEvento(SolicitudConsultaEvento value) {
        this.solicitudConsultaEvento = value;
    }

}
