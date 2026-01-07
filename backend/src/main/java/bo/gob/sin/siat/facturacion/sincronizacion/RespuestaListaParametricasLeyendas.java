
package bo.gob.sin.siat.facturacion.sincronizacion;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for respuestaListaParametricasLeyendas complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="respuestaListaParametricasLeyendas"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://siat.impuestos.gob.bo/}respuestaConfiguracion"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="listaLeyendas" type="{https://siat.impuestos.gob.bo/}parametricaLeyendasDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaListaParametricasLeyendas", propOrder = {
    "listaLeyendas"
})
public class RespuestaListaParametricasLeyendas
    extends RespuestaConfiguracion
{

    @XmlElement(nillable = true)
    protected List<ParametricaLeyendasDto> listaLeyendas;

    /**
     * Gets the value of the listaLeyendas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaLeyendas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaLeyendas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParametricaLeyendasDto }
     * 
     * 
     */
    public List<ParametricaLeyendasDto> getListaLeyendas() {
        if (listaLeyendas == null) {
            listaLeyendas = new ArrayList<ParametricaLeyendasDto>();
        }
        return this.listaLeyendas;
    }

}
