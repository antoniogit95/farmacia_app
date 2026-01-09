
package bo.gob.sin.siat.servicio.facturacion.DocumentoAjuste;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solicitudValidacionRecepcionCompras complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solicitudValidacionRecepcionCompras"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://siat.impuestos.gob.bo/}solicitudCompras"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoRecepcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudValidacionRecepcionCompras", propOrder = {
    "codigoRecepcion"
})
public class SolicitudValidacionRecepcionCompras
    extends SolicitudCompras
{

    @XmlElement(required = true)
    protected String codigoRecepcion;

    /**
     * Gets the value of the codigoRecepcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoRecepcion() {
        return codigoRecepcion;
    }

    /**
     * Sets the value of the codigoRecepcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoRecepcion(String value) {
        this.codigoRecepcion = value;
    }

}
