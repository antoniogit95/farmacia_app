
package bo.gob.sin.siat.servicio.facturacion.CompraVenta;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solicitudRecepcion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solicitudRecepcion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://siat.impuestos.gob.bo/}modelDto"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoAmbiente" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codigoDocumentoSector" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codigoEmision" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codigoModalidad" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codigoPuntoVenta" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="codigoSistema" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codigoSucursal" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cufd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cuis" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nit" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="tipoFacturaDocumento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudRecepcion", propOrder = {
    "codigoAmbiente",
    "codigoDocumentoSector",
    "codigoEmision",
    "codigoModalidad",
    "codigoPuntoVenta",
    "codigoSistema",
    "codigoSucursal",
    "cufd",
    "cuis",
    "nit",
    "tipoFacturaDocumento"
})
@XmlSeeAlso({
    SolicitudAnulacion.class,
    SolicitudReversionAnulacion.class,
    SolicitudRecepcionFactura.class,
    SolicitudVerificacionEstado.class
})
public class SolicitudRecepcion
    extends ModelDto
{

    protected int codigoAmbiente;
    protected int codigoDocumentoSector;
    protected int codigoEmision;
    protected int codigoModalidad;
    protected Integer codigoPuntoVenta;
    @XmlElement(required = true)
    protected String codigoSistema;
    protected int codigoSucursal;
    @XmlElement(required = true)
    protected String cufd;
    @XmlElement(required = true)
    protected String cuis;
    protected long nit;
    protected int tipoFacturaDocumento;

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
     * Gets the value of the codigoDocumentoSector property.
     * 
     */
    public int getCodigoDocumentoSector() {
        return codigoDocumentoSector;
    }

    /**
     * Sets the value of the codigoDocumentoSector property.
     * 
     */
    public void setCodigoDocumentoSector(int value) {
        this.codigoDocumentoSector = value;
    }

    /**
     * Gets the value of the codigoEmision property.
     * 
     */
    public int getCodigoEmision() {
        return codigoEmision;
    }

    /**
     * Sets the value of the codigoEmision property.
     * 
     */
    public void setCodigoEmision(int value) {
        this.codigoEmision = value;
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
     * Gets the value of the codigoPuntoVenta property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodigoPuntoVenta() {
        return codigoPuntoVenta;
    }

    /**
     * Sets the value of the codigoPuntoVenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodigoPuntoVenta(Integer value) {
        this.codigoPuntoVenta = value;
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
     * Gets the value of the cufd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCufd() {
        return cufd;
    }

    /**
     * Sets the value of the cufd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCufd(String value) {
        this.cufd = value;
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
     * Gets the value of the tipoFacturaDocumento property.
     * 
     */
    public int getTipoFacturaDocumento() {
        return tipoFacturaDocumento;
    }

    /**
     * Sets the value of the tipoFacturaDocumento property.
     * 
     */
    public void setTipoFacturaDocumento(int value) {
        this.tipoFacturaDocumento = value;
    }

}
