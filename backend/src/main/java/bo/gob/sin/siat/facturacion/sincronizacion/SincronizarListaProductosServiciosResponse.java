
package bo.gob.sin.siat.facturacion.sincronizacion;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sincronizarListaProductosServiciosResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sincronizarListaProductosServiciosResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaListaProductos" type="{https://siat.impuestos.gob.bo/}respuestaListaProductos" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sincronizarListaProductosServiciosResponse", propOrder = {
    "respuestaListaProductos"
})
public class SincronizarListaProductosServiciosResponse {

    @XmlElement(name = "RespuestaListaProductos")
    protected RespuestaListaProductos respuestaListaProductos;

    /**
     * Gets the value of the respuestaListaProductos property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaListaProductos }
     *     
     */
    public RespuestaListaProductos getRespuestaListaProductos() {
        return respuestaListaProductos;
    }

    /**
     * Sets the value of the respuestaListaProductos property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaListaProductos }
     *     
     */
    public void setRespuestaListaProductos(RespuestaListaProductos value) {
        this.respuestaListaProductos = value;
    }

}
