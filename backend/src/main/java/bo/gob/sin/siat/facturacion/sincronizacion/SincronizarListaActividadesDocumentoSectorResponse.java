
package bo.gob.sin.siat.facturacion.sincronizacion;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sincronizarListaActividadesDocumentoSectorResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sincronizarListaActividadesDocumentoSectorResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaListaActividadesDocumentoSector" type="{https://siat.impuestos.gob.bo/}respuestaListaActividadesDocumentoSector" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sincronizarListaActividadesDocumentoSectorResponse", propOrder = {
    "respuestaListaActividadesDocumentoSector"
})
public class SincronizarListaActividadesDocumentoSectorResponse {

    @XmlElement(name = "RespuestaListaActividadesDocumentoSector")
    protected RespuestaListaActividadesDocumentoSector respuestaListaActividadesDocumentoSector;

    /**
     * Gets the value of the respuestaListaActividadesDocumentoSector property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaListaActividadesDocumentoSector }
     *     
     */
    public RespuestaListaActividadesDocumentoSector getRespuestaListaActividadesDocumentoSector() {
        return respuestaListaActividadesDocumentoSector;
    }

    /**
     * Sets the value of the respuestaListaActividadesDocumentoSector property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaListaActividadesDocumentoSector }
     *     
     */
    public void setRespuestaListaActividadesDocumentoSector(RespuestaListaActividadesDocumentoSector value) {
        this.respuestaListaActividadesDocumentoSector = value;
    }

}
