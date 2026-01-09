
package bo.gob.sin.siat.servicio.facturacion.DocumentoAjuste;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reversionAnulacionDocumentoAjuste complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reversionAnulacionDocumentoAjuste"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudServicioReversionAnulacionDocumentoAjuste" type="{https://siat.impuestos.gob.bo/}solicitudReversionAnulacion"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reversionAnulacionDocumentoAjuste", propOrder = {
    "solicitudServicioReversionAnulacionDocumentoAjuste"
})
public class ReversionAnulacionDocumentoAjuste {

    @XmlElement(name = "SolicitudServicioReversionAnulacionDocumentoAjuste", required = true)
    protected SolicitudReversionAnulacion solicitudServicioReversionAnulacionDocumentoAjuste;

    /**
     * Gets the value of the solicitudServicioReversionAnulacionDocumentoAjuste property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudReversionAnulacion }
     *     
     */
    public SolicitudReversionAnulacion getSolicitudServicioReversionAnulacionDocumentoAjuste() {
        return solicitudServicioReversionAnulacionDocumentoAjuste;
    }

    /**
     * Sets the value of the solicitudServicioReversionAnulacionDocumentoAjuste property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudReversionAnulacion }
     *     
     */
    public void setSolicitudServicioReversionAnulacionDocumentoAjuste(SolicitudReversionAnulacion value) {
        this.solicitudServicioReversionAnulacionDocumentoAjuste = value;
    }

}
