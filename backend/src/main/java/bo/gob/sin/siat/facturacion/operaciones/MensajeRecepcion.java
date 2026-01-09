
package bo.gob.sin.siat.facturacion.operaciones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mensajeRecepcion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mensajeRecepcion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://siat.impuestos.gob.bo/}mensajeServicio"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="advertencia" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="numeroArchivo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="numeroDetalle" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mensajeRecepcion", propOrder = {
    "advertencia",
    "numeroArchivo",
    "numeroDetalle"
})
public class MensajeRecepcion
    extends MensajeServicio
{

    protected Boolean advertencia;
    protected Integer numeroArchivo;
    protected Integer numeroDetalle;

    /**
     * Gets the value of the advertencia property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAdvertencia() {
        return advertencia;
    }

    /**
     * Sets the value of the advertencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAdvertencia(Boolean value) {
        this.advertencia = value;
    }

    /**
     * Gets the value of the numeroArchivo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroArchivo() {
        return numeroArchivo;
    }

    /**
     * Sets the value of the numeroArchivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroArchivo(Integer value) {
        this.numeroArchivo = value;
    }

    /**
     * Gets the value of the numeroDetalle property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroDetalle() {
        return numeroDetalle;
    }

    /**
     * Sets the value of the numeroDetalle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroDetalle(Integer value) {
        this.numeroDetalle = value;
    }

}
