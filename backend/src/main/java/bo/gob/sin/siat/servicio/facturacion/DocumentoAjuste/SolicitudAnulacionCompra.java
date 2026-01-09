
package bo.gob.sin.siat.servicio.facturacion.DocumentoAjuste;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solicitudAnulacionCompra complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solicitudAnulacionCompra"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://siat.impuestos.gob.bo/}solicitudCompras"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codAutorizacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nitProveedor" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="nroDuiDim" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nroFactura" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudAnulacionCompra", propOrder = {
    "codAutorizacion",
    "nitProveedor",
    "nroDuiDim",
    "nroFactura"
})
public class SolicitudAnulacionCompra
    extends SolicitudCompras
{

    @XmlElement(required = true)
    protected String codAutorizacion;
    protected long nitProveedor;
    @XmlElement(required = true)
    protected String nroDuiDim;
    protected long nroFactura;

    /**
     * Gets the value of the codAutorizacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAutorizacion() {
        return codAutorizacion;
    }

    /**
     * Sets the value of the codAutorizacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAutorizacion(String value) {
        this.codAutorizacion = value;
    }

    /**
     * Gets the value of the nitProveedor property.
     * 
     */
    public long getNitProveedor() {
        return nitProveedor;
    }

    /**
     * Sets the value of the nitProveedor property.
     * 
     */
    public void setNitProveedor(long value) {
        this.nitProveedor = value;
    }

    /**
     * Gets the value of the nroDuiDim property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroDuiDim() {
        return nroDuiDim;
    }

    /**
     * Sets the value of the nroDuiDim property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroDuiDim(String value) {
        this.nroDuiDim = value;
    }

    /**
     * Gets the value of the nroFactura property.
     * 
     */
    public long getNroFactura() {
        return nroFactura;
    }

    /**
     * Sets the value of the nroFactura property.
     * 
     */
    public void setNroFactura(long value) {
        this.nroFactura = value;
    }

}
