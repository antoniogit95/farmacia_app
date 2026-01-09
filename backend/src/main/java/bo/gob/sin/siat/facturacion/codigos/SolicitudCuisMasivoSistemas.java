
package bo.gob.sin.siat.facturacion.codigos;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solicitudCuisMasivoSistemas complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solicitudCuisMasivoSistemas"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoAmbiente" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codigoModalidad" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codigoSistema" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="datosSolicitud" type="{https://siat.impuestos.gob.bo/}solicitudListaCuisDto" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "solicitudCuisMasivoSistemas", propOrder = {
    "codigoAmbiente",
    "codigoModalidad",
    "codigoSistema",
    "datosSolicitud",
    "nit"
})
public class SolicitudCuisMasivoSistemas {

    protected int codigoAmbiente;
    protected int codigoModalidad;
    @XmlElement(required = true)
    protected String codigoSistema;
    @XmlElement(required = true)
    protected List<SolicitudListaCuisDto> datosSolicitud;
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
     * Gets the value of the datosSolicitud property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datosSolicitud property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatosSolicitud().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SolicitudListaCuisDto }
     * 
     * 
     */
    public List<SolicitudListaCuisDto> getDatosSolicitud() {
        if (datosSolicitud == null) {
            datosSolicitud = new ArrayList<SolicitudListaCuisDto>();
        }
        return this.datosSolicitud;
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
