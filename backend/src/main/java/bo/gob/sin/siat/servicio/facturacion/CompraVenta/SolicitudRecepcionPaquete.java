
package bo.gob.sin.siat.servicio.facturacion.CompraVenta;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solicitudRecepcionPaquete complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solicitudRecepcionPaquete"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://siat.impuestos.gob.bo/}solicitudRecepcionFactura"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cafc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cantidadFacturas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codigoEvento" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudRecepcionPaquete", propOrder = {
    "cafc",
    "cantidadFacturas",
    "codigoEvento"
})
public class SolicitudRecepcionPaquete
    extends SolicitudRecepcionFactura
{

    protected String cafc;
    protected int cantidadFacturas;
    protected long codigoEvento;

    /**
     * Gets the value of the cafc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCafc() {
        return cafc;
    }

    /**
     * Sets the value of the cafc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCafc(String value) {
        this.cafc = value;
    }

    /**
     * Gets the value of the cantidadFacturas property.
     * 
     */
    public int getCantidadFacturas() {
        return cantidadFacturas;
    }

    /**
     * Sets the value of the cantidadFacturas property.
     * 
     */
    public void setCantidadFacturas(int value) {
        this.cantidadFacturas = value;
    }

    /**
     * Gets the value of the codigoEvento property.
     * 
     */
    public long getCodigoEvento() {
        return codigoEvento;
    }

    /**
     * Sets the value of the codigoEvento property.
     * 
     */
    public void setCodigoEvento(long value) {
        this.codigoEvento = value;
    }

}
