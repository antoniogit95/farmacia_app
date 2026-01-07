package farmacia.backend.invoice.cuis;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "respuestaCuis")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuisResponse {
    
    private String cuis;
    private String fechaVigencia;
    private String codigoControl;
    private String transaccion;
    
}
