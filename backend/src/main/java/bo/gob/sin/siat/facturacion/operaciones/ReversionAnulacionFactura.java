
package bo.gob.sin.siat.facturacion.operaciones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reversionAnulacionFactura complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reversionAnulacionFactura"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SolicitudServicioReversionAnulacionFactura" type="{https://siat.impuestos.gob.bo/}solicitudReversionAnulacion"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reversionAnulacionFactura", propOrder = {
    "solicitudServicioReversionAnulacionFactura"
})
public class ReversionAnulacionFactura {

    @XmlElement(name = "SolicitudServicioReversionAnulacionFactura", required = true)
    protected SolicitudReversionAnulacion solicitudServicioReversionAnulacionFactura;

    /**
     * Gets the value of the solicitudServicioReversionAnulacionFactura property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudReversionAnulacion }
     *     
     */
    public SolicitudReversionAnulacion getSolicitudServicioReversionAnulacionFactura() {
        return solicitudServicioReversionAnulacionFactura;
    }

    /**
     * Sets the value of the solicitudServicioReversionAnulacionFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudReversionAnulacion }
     *     
     */
    public void setSolicitudServicioReversionAnulacionFactura(SolicitudReversionAnulacion value) {
        this.solicitudServicioReversionAnulacionFactura = value;
    }

}
