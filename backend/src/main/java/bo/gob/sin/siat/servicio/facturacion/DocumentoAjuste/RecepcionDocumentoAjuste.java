
package bo.gob.sin.siat.servicio.facturacion.DocumentoAjuste;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recepcionDocumentoAjuste complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recepcionDocumentoAjuste"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudServicioRecepcionDocumentoAjuste" type="{https://siat.impuestos.gob.bo/}solicitudRecepcionFactura"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recepcionDocumentoAjuste", propOrder = {
    "solicitudServicioRecepcionDocumentoAjuste"
})
public class RecepcionDocumentoAjuste {

    @XmlElement(name = "SolicitudServicioRecepcionDocumentoAjuste", required = true)
    protected SolicitudRecepcionFactura solicitudServicioRecepcionDocumentoAjuste;

    /**
     * Gets the value of the solicitudServicioRecepcionDocumentoAjuste property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudRecepcionFactura }
     *     
     */
    public SolicitudRecepcionFactura getSolicitudServicioRecepcionDocumentoAjuste() {
        return solicitudServicioRecepcionDocumentoAjuste;
    }

    /**
     * Sets the value of the solicitudServicioRecepcionDocumentoAjuste property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudRecepcionFactura }
     *     
     */
    public void setSolicitudServicioRecepcionDocumentoAjuste(SolicitudRecepcionFactura value) {
        this.solicitudServicioRecepcionDocumentoAjuste = value;
    }

}
