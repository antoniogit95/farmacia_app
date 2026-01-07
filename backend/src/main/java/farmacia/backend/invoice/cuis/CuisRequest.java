package farmacia.backend.invoice.cuis;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "solicitudCuis")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuisRequest {
    
    private Integer codigoAmbiente;
    private Integer codigoModalidad;
    private String codigoSistema;
    private Integer codigoSucursal;
    private String nit;

}
