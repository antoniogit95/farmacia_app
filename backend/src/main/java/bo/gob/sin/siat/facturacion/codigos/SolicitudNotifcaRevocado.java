
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for solicitudNotifcaRevocado complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solicitudNotifcaRevocado"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="certificado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codigoAmbiente" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codigoSistema" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codigoSucursal" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cuis" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechaRevocacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="nit" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="razonRevocacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudNotifcaRevocado", propOrder = {
    "certificado",
    "codigoAmbiente",
    "codigoSistema",
    "codigoSucursal",
    "cuis",
    "fechaRevocacion",
    "nit",
    "razonRevocacion"
})
public class SolicitudNotifcaRevocado {

    @XmlElement(required = true)
    protected String certificado;
    protected int codigoAmbiente;
    @XmlElement(required = true)
    protected String codigoSistema;
    protected int codigoSucursal;
    @XmlElement(required = true)
    protected String cuis;
    @XmlElementRef(name = "fechaRevocacion", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> fechaRevocacion;
    protected long nit;
    @XmlElement(required = true)
    protected String razonRevocacion;

    /**
     * Gets the value of the certificado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificado() {
        return certificado;
    }

    /**
     * Sets the value of the certificado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificado(String value) {
        this.certificado = value;
    }

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
     * Gets the value of the fechaRevocacion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getFechaRevocacion() {
        return fechaRevocacion;
    }

    /**
     * Sets the value of the fechaRevocacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setFechaRevocacion(JAXBElement<XMLGregorianCalendar> value) {
        this.fechaRevocacion = value;
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
     * Gets the value of the razonRevocacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazonRevocacion() {
        return razonRevocacion;
    }

    /**
     * Sets the value of the razonRevocacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazonRevocacion(String value) {
        this.razonRevocacion = value;
    }

}
