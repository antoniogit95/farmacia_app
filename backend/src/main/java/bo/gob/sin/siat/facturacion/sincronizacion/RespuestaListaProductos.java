
package bo.gob.sin.siat.facturacion.sincronizacion;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for respuestaListaProductos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="respuestaListaProductos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://siat.impuestos.gob.bo/}respuestaConfiguracion"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="listaCodigos" type="{https://siat.impuestos.gob.bo/}productosDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaListaProductos", propOrder = {
    "listaCodigos"
})
public class RespuestaListaProductos
    extends RespuestaConfiguracion
{

    @XmlElement(nillable = true)
    protected List<ProductosDto> listaCodigos;

    /**
     * Gets the value of the listaCodigos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaCodigos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaCodigos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductosDto }
     * 
     * 
     */
    public List<ProductosDto> getListaCodigos() {
        if (listaCodigos == null) {
            listaCodigos = new ArrayList<ProductosDto>();
        }
        return this.listaCodigos;
    }

}
