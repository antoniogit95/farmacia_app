
package bo.gob.sin.siat.servicio.facturacion.CompraVenta;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anulacionDocumentoAjuste complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="anulacionDocumentoAjuste"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudServicioAnulacionDocumentoAjuste" type="{https://siat.impuestos.gob.bo/}solicitudAnulacion"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anulacionDocumentoAjuste", propOrder = {
    "solicitudServicioAnulacionDocumentoAjuste"
})
public class AnulacionDocumentoAjuste {

    @XmlElement(name = "SolicitudServicioAnulacionDocumentoAjuste", required = true)
    protected SolicitudAnulacion solicitudServicioAnulacionDocumentoAjuste;

    /**
     * Gets the value of the solicitudServicioAnulacionDocumentoAjuste property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudAnulacion }
     *     
     */
    public SolicitudAnulacion getSolicitudServicioAnulacionDocumentoAjuste() {
        return solicitudServicioAnulacionDocumentoAjuste;
    }

    /**
     * Sets the value of the solicitudServicioAnulacionDocumentoAjuste property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudAnulacion }
     *     
     */
    public void setSolicitudServicioAnulacionDocumentoAjuste(SolicitudAnulacion value) {
        this.solicitudServicioAnulacionDocumentoAjuste = value;
    }

}
