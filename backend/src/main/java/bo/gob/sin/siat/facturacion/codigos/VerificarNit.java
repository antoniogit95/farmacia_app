
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for verificarNit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="verificarNit"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudVerificarNit" type="{https://siat.impuestos.gob.bo/}solicitudVerificarNit"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verificarNit", propOrder = {
    "solicitudVerificarNit"
})
public class VerificarNit {

    @XmlElement(name = "SolicitudVerificarNit", required = true)
    protected SolicitudVerificarNit solicitudVerificarNit;

    /**
     * Gets the value of the solicitudVerificarNit property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudVerificarNit }
     *     
     */
    public SolicitudVerificarNit getSolicitudVerificarNit() {
        return solicitudVerificarNit;
    }

    /**
     * Sets the value of the solicitudVerificarNit property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudVerificarNit }
     *     
     */
    public void setSolicitudVerificarNit(SolicitudVerificarNit value) {
        this.solicitudVerificarNit = value;
    }

}
