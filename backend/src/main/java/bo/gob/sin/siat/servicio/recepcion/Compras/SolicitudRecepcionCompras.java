
package bo.gob.sin.siat.servicio.recepcion.Compras;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for solicitudRecepcionCompras complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solicitudRecepcionCompras"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://siat.impuestos.gob.bo/}solicitudCompras"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="archivo" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *         &lt;element name="cantidadFacturas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="fechaEnvio" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="gestion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="hashArchivo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="periodo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudRecepcionCompras", propOrder = {
    "archivo",
    "cantidadFacturas",
    "fechaEnvio",
    "gestion",
    "hashArchivo",
    "periodo"
})
public class SolicitudRecepcionCompras
    extends SolicitudCompras
{

    @XmlElement(required = true)
    protected byte[] archivo;
    protected int cantidadFacturas;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEnvio;
    protected int gestion;
    @XmlElement(required = true)
    protected String hashArchivo;
    protected int periodo;

    /**
     * Gets the value of the archivo property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getArchivo() {
        return archivo;
    }

    /**
     * Sets the value of the archivo property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setArchivo(byte[] value) {
        this.archivo = value;
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
     * Gets the value of the fechaEnvio property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEnvio() {
        return fechaEnvio;
    }

    /**
     * Sets the value of the fechaEnvio property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEnvio(XMLGregorianCalendar value) {
        this.fechaEnvio = value;
    }

    /**
     * Gets the value of the gestion property.
     * 
     */
    public int getGestion() {
        return gestion;
    }

    /**
     * Sets the value of the gestion property.
     * 
     */
    public void setGestion(int value) {
        this.gestion = value;
    }

    /**
     * Gets the value of the hashArchivo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHashArchivo() {
        return hashArchivo;
    }

    /**
     * Sets the value of the hashArchivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHashArchivo(String value) {
        this.hashArchivo = value;
    }

    /**
     * Gets the value of the periodo property.
     * 
     */
    public int getPeriodo() {
        return periodo;
    }

    /**
     * Sets the value of the periodo property.
     * 
     */
    public void setPeriodo(int value) {
        this.periodo = value;
    }

}
