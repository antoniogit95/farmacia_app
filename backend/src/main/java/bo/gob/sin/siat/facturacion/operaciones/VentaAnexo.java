
package bo.gob.sin.siat.facturacion.operaciones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ventaAnexo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ventaAnexo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://siat.impuestos.gob.bo/}modelDto"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codigoProducto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codigoProductoSin" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="tipoCodigo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ventaAnexo", propOrder = {
    "codigo",
    "codigoProducto",
    "codigoProductoSin",
    "tipoCodigo"
})
public class VentaAnexo
    extends ModelDto
{

    @XmlElement(required = true)
    protected String codigo;
    @XmlElement(required = true)
    protected String codigoProducto;
    protected long codigoProductoSin;
    @XmlElement(required = true)
    protected String tipoCodigo;

    /**
     * Gets the value of the codigo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the value of the codigo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Gets the value of the codigoProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * Sets the value of the codigoProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoProducto(String value) {
        this.codigoProducto = value;
    }

    /**
     * Gets the value of the codigoProductoSin property.
     * 
     */
    public long getCodigoProductoSin() {
        return codigoProductoSin;
    }

    /**
     * Sets the value of the codigoProductoSin property.
     * 
     */
    public void setCodigoProductoSin(long value) {
        this.codigoProductoSin = value;
    }

    /**
     * Gets the value of the tipoCodigo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCodigo() {
        return tipoCodigo;
    }

    /**
     * Sets the value of the tipoCodigo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCodigo(String value) {
        this.tipoCodigo = value;
    }

}
