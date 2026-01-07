
package bo.gob.sin.siat.facturacion.sincronizacion;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sincronizarActividadesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sincronizarActividadesResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaListaActividades" type="{https://siat.impuestos.gob.bo/}respuestaListaActividades" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sincronizarActividadesResponse", propOrder = {
    "respuestaListaActividades"
})
public class SincronizarActividadesResponse {

    @XmlElement(name = "RespuestaListaActividades")
    protected RespuestaListaActividades respuestaListaActividades;

    /**
     * Gets the value of the respuestaListaActividades property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaListaActividades }
     *     
     */
    public RespuestaListaActividades getRespuestaListaActividades() {
        return respuestaListaActividades;
    }

    /**
     * Sets the value of the respuestaListaActividades property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaListaActividades }
     *     
     */
    public void setRespuestaListaActividades(RespuestaListaActividades value) {
        this.respuestaListaActividades = value;
    }

}
