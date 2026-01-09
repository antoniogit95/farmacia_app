
package bo.gob.sin.siat.facturacion.operaciones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solicitudRegistroPuntoVenta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solicitudRegistroPuntoVenta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoAmbiente" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codigoModalidad" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codigoSistema" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codigoSucursal" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codigoTipoPuntoVenta" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cuis" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nit" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="nombrePuntoVenta" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudRegistroPuntoVenta", propOrder = {
    "codigoAmbiente",
    "codigoModalidad",
    "codigoSistema",
    "codigoSucursal",
    "codigoTipoPuntoVenta",
    "cuis",
    "descripcion",
    "nit",
    "nombrePuntoVenta"
})
public class SolicitudRegistroPuntoVenta {

    protected int codigoAmbiente;
    protected int codigoModalidad;
    @XmlElement(required = true)
    protected String codigoSistema;
    protected int codigoSucursal;
    protected int codigoTipoPuntoVenta;
    @XmlElement(required = true)
    protected String cuis;
    @XmlElement(required = true)
    protected String descripcion;
    protected long nit;
    @XmlElement(required = true)
    protected String nombrePuntoVenta;

    /**
     * Gets the value of the codigoAmbiente property.
     * 
     */
    public int getCodigoAmbiente() {
        return codigoAmbiente;
    }

    /**
     * Sets the value of the codigoAmbiente property.
     * 
     */
    public void setCodigoAmbiente(int value) {
        this.codigoAmbiente = value;
    }

    /**
     * Gets the value of the codigoModalidad property.
     * 
     */
    public int getCodigoModalidad() {
        return codigoModalidad;
    }

    /**
     * Sets the value of the codigoModalidad property.
     * 
     */
    public void setCodigoModalidad(int value) {
        this.codigoModalidad = value;
    }

    /**
     * Gets the value of the codigoSistema property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoSistema() {
        return codigoSistema;
    }

    /**
     * Sets the value of the codigoSistema property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoSistema(String value) {
        this.codigoSistema = value;
    }

    /**
     * Gets the value of the codigoSucursal property.
     * 
     */
    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    /**
     * Sets the value of the codigoSucursal property.
     * 
     */
    public void setCodigoSucursal(int value) {
        this.codigoSucursal = value;
    }

    /**
     * Gets the value of the codigoTipoPuntoVenta property.
     * 
     */
    public int getCodigoTipoPuntoVenta() {
        return codigoTipoPuntoVenta;
    }

    /**
     * Sets the value of the codigoTipoPuntoVenta property.
     * 
     */
    public void setCodigoTipoPuntoVenta(int value) {
        this.codigoTipoPuntoVenta = value;
    }

    /**
     * Gets the value of the cuis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuis() {
        return cuis;
    }

    /**
     * Sets the value of the cuis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuis(String value) {
        this.cuis = value;
    }

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the nit property.
     * 
     */
    public long getNit() {
        return nit;
    }

    /**
     * Sets the value of the nit property.
     * 
     */
    public void setNit(long value) {
        this.nit = value;
    }

    /**
     * Gets the value of the nombrePuntoVenta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrePuntoVenta() {
        return nombrePuntoVenta;
    }

    /**
     * Sets the value of the nombrePuntoVenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrePuntoVenta(String value) {
        this.nombrePuntoVenta = value;
    }

}
