
package bo.gob.sin.siat.servicio.facturacion.DocumentoAjuste;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for verificacionEstadoDocumentoAjuste complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="verificacionEstadoDocumentoAjuste"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudServicioVerificacionEstadoDocumentoAjuste" type="{https://siat.impuestos.gob.bo/}solicitudVerificacionEstado"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verificacionEstadoDocumentoAjuste", propOrder = {
    "solicitudServicioVerificacionEstadoDocumentoAjuste"
})
public class VerificacionEstadoDocumentoAjuste {

    @XmlElement(name = "SolicitudServicioVerificacionEstadoDocumentoAjuste", required = true)
    protected SolicitudVerificacionEstado solicitudServicioVerificacionEstadoDocumentoAjuste;

    /**
     * Gets the value of the solicitudServicioVerificacionEstadoDocumentoAjuste property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudVerificacionEstado }
     *     
     */
    public SolicitudVerificacionEstado getSolicitudServicioVerificacionEstadoDocumentoAjuste() {
        return solicitudServicioVerificacionEstadoDocumentoAjuste;
    }

    /**
     * Sets the value of the solicitudServicioVerificacionEstadoDocumentoAjuste property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudVerificacionEstado }
     *     
     */
    public void setSolicitudServicioVerificacionEstadoDocumentoAjuste(SolicitudVerificacionEstado value) {
        this.solicitudServicioVerificacionEstadoDocumentoAjuste = value;
    }

}
