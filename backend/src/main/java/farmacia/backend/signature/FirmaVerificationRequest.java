package farmacia.backend.signature;

import farmacia.backend.sale.Sale;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FirmaVerificationRequest {
    
    private Sale facturaJson;
    private String firmaDigital;
    private String certificado;


}
