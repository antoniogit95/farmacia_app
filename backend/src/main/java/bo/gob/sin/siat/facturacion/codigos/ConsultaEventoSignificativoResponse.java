
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultaEventoSignificativoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultaEventoSignificativoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaListaEventos" type="{https://siat.impuestos.gob.bo/}respuestaListaEventos" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaEventoSignificativoResponse", propOrder = {
    "respuestaListaEventos"
})
public class ConsultaEventoSignificativoResponse {

    @XmlElement(name = "RespuestaListaEventos")
    protected RespuestaListaEventos respuestaListaEventos;

    /**
     * Gets the value of the respuestaListaEventos property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaListaEventos }
     *     
     */
    public RespuestaListaEventos getRespuestaListaEventos() {
        return respuestaListaEventos;
    }

    /**
     * Sets the value of the respuestaListaEventos property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaListaEventos }
     *     
     */
    public void setRespuestaListaEventos(RespuestaListaEventos value) {
        this.respuestaListaEventos = value;
    }

}
