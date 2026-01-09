
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for solicitudEventoSignificativo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solicitudEventoSignificativo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoAmbiente" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codigoMotivoEvento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codigoPuntoVenta" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="codigoSistema" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codigoSucursal" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cufd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cufdEvento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cuis" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechaHoraFinEvento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="fechaHoraInicioEvento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="nit" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudEventoSignificativo", propOrder = {
    "codigoAmbiente",
    "codigoMotivoEvento",
    "codigoPuntoVenta",
    "codigoSistema",
    "codigoSucursal",
    "cufd",
    "cufdEvento",
    "cuis",
    "descripcion",
    "fechaHoraFinEvento",
    "fechaHoraInicioEvento",
    "nit"
})
public class SolicitudEventoSignificativo {

    protected int codigoAmbiente;
    protected int codigoMotivoEvento;
    @XmlElementRef(name = "codigoPuntoVenta", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> codigoPuntoVenta;
    @XmlElement(required = true)
    protected String codigoSistema;
    protected int codigoSucursal;
    @XmlElement(required = true)
    protected String cufd;
    @XmlElement(required = true)
    protected String cufdEvento;
    @XmlElement(required = true)
    protected String cuis;
    @XmlElement(required = true)
    protected String descripcion;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraFinEvento;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraInicioEvento;
    protected long nit;

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
     * Gets the value of the codigoMotivoEvento property.
     * 
     */
    public int getCodigoMotivoEvento() {
        return codigoMotivoEvento;
    }

    /**
     * Sets the value of the codigoMotivoEvento property.
     * 
     */
    public void setCodigoMotivoEvento(int value) {
        this.codigoMotivoEvento = value;
    }

    /**
     * Gets the value of the codigoPuntoVenta property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCodigoPuntoVenta() {
        return codigoPuntoVenta;
    }

    /**
     * Sets the value of the codigoPuntoVenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCodigoPuntoVenta(JAXBElement<Integer> value) {
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
     * Gets the value of the cufdEvento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCufdEvento() {
        return cufdEvento;
    }

    /**
     * Sets the value of the cufdEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCufdEvento(String value) {
        this.cufdEvento = value;
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
     * Gets the value of the fechaHoraFinEvento property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraFinEvento() {
        return fechaHoraFinEvento;
    }

    /**
     * Sets the value of the fechaHoraFinEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraFinEvento(XMLGregorianCalendar value) {
        this.fechaHoraFinEvento = value;
    }

    /**
     * Gets the value of the fechaHoraInicioEvento property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraInicioEvento() {
        return fechaHoraInicioEvento;
    }

    /**
     * Sets the value of the fechaHoraInicioEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraInicioEvento(XMLGregorianCalendar value) {
        this.fechaHoraInicioEvento = value;
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

}
