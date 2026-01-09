
package bo.gob.sin.siat.facturacion.codigos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cuisMasivo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cuisMasivo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudCuisMasivoSistemas" type="{https://siat.impuestos.gob.bo/}solicitudCuisMasivoSistemas"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cuisMasivo", propOrder = {
    "solicitudCuisMasivoSistemas"
})
public class CuisMasivo {

    @XmlElement(name = "SolicitudCuisMasivoSistemas", required = true)
    protected SolicitudCuisMasivoSistemas solicitudCuisMasivoSistemas;

    /**
     * Gets the value of the solicitudCuisMasivoSistemas property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudCuisMasivoSistemas }
     *     
     */
    public SolicitudCuisMasivoSistemas getSolicitudCuisMasivoSistemas() {
        return solicitudCuisMasivoSistemas;
    }

    /**
     * Sets the value of the solicitudCuisMasivoSistemas property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudCuisMasivoSistemas }
     *     
     */
    public void setSolicitudCuisMasivoSistemas(SolicitudCuisMasivoSistemas value) {
        this.solicitudCuisMasivoSistemas = value;
    }

}
