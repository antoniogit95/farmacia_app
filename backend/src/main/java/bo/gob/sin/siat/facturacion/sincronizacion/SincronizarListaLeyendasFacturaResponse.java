
package bo.gob.sin.siat.facturacion.sincronizacion;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sincronizarListaLeyendasFacturaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sincronizarListaLeyendasFacturaResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaListaParametricasLeyendas" type="{https://siat.impuestos.gob.bo/}respuestaListaParametricasLeyendas" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sincronizarListaLeyendasFacturaResponse", propOrder = {
    "respuestaListaParametricasLeyendas"
})
public class SincronizarListaLeyendasFacturaResponse {

    @XmlElement(name = "RespuestaListaParametricasLeyendas")
    protected RespuestaListaParametricasLeyendas respuestaListaParametricasLeyendas;

    /**
     * Gets the value of the respuestaListaParametricasLeyendas property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaListaParametricasLeyendas }
     *     
     */
    public RespuestaListaParametricasLeyendas getRespuestaListaParametricasLeyendas() {
        return respuestaListaParametricasLeyendas;
    }

    /**
     * Sets the value of the respuestaListaParametricasLeyendas property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaListaParametricasLeyendas }
     *     
     */
    public void setRespuestaListaParametricasLeyendas(RespuestaListaParametricasLeyendas value) {
        this.respuestaListaParametricasLeyendas = value;
    }

}
