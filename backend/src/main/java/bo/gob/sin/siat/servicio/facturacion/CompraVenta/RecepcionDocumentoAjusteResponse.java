
package bo.gob.sin.siat.servicio.facturacion.CompraVenta;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recepcionDocumentoAjusteResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recepcionDocumentoAjusteResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaServicioFacturacion" type="{https://siat.impuestos.gob.bo/}respuestaRecepcion" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recepcionDocumentoAjusteResponse", propOrder = {
    "respuestaServicioFacturacion"
})
public class RecepcionDocumentoAjusteResponse {

    @XmlElement(name = "RespuestaServicioFacturacion")
    protected RespuestaRecepcion respuestaServicioFacturacion;

    /**
     * Gets the value of the respuestaServicioFacturacion property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaRecepcion }
     *     
     */
    public RespuestaRecepcion getRespuestaServicioFacturacion() {
        return respuestaServicioFacturacion;
    }

    /**
     * Sets the value of the respuestaServicioFacturacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaRecepcion }
     *     
     */
    public void setRespuestaServicioFacturacion(RespuestaRecepcion value) {
        this.respuestaServicioFacturacion = value;
    }

}
