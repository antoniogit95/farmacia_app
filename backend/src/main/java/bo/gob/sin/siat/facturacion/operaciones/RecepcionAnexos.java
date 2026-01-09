
package bo.gob.sin.siat.facturacion.operaciones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recepcionAnexos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recepcionAnexos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudRecepcionAnexos" type="{https://siat.impuestos.gob.bo/}solicitudRecepcionAnexos"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recepcionAnexos", propOrder = {
    "solicitudRecepcionAnexos"
})
public class RecepcionAnexos {

    @XmlElement(name = "SolicitudRecepcionAnexos", required = true)
    protected SolicitudRecepcionAnexos solicitudRecepcionAnexos;

    /**
     * Gets the value of the solicitudRecepcionAnexos property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudRecepcionAnexos }
     *     
     */
    public SolicitudRecepcionAnexos getSolicitudRecepcionAnexos() {
        return solicitudRecepcionAnexos;
    }

    /**
     * Sets the value of the solicitudRecepcionAnexos property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudRecepcionAnexos }
     *     
     */
    public void setSolicitudRecepcionAnexos(SolicitudRecepcionAnexos value) {
        this.solicitudRecepcionAnexos = value;
    }

}
