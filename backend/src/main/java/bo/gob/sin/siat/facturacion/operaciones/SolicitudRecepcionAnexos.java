
package bo.gob.sin.siat.facturacion.operaciones;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solicitudRecepcionAnexos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solicitudRecepcionAnexos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://siat.impuestos.gob.bo/}solicitudRecepcion"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="anexosList" type="{https://siat.impuestos.gob.bo/}ventaAnexo" maxOccurs="unbounded"/&gt;
 *         &lt;element name="cuf" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudRecepcionAnexos", propOrder = {
    "anexosList",
    "cuf"
})
public class SolicitudRecepcionAnexos
    extends SolicitudRecepcion
{

    @XmlElement(required = true)
    protected List<VentaAnexo> anexosList;
    @XmlElement(required = true)
    protected String cuf;

    /**
     * Gets the value of the anexosList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anexosList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnexosList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VentaAnexo }
     * 
     * 
     */
    public List<VentaAnexo> getAnexosList() {
        if (anexosList == null) {
            anexosList = new ArrayList<VentaAnexo>();
        }
        return this.anexosList;
    }

    /**
     * Gets the value of the cuf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuf() {
        return cuf;
    }

    /**
     * Sets the value of the cuf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuf(String value) {
        this.cuf = value;
    }

}
