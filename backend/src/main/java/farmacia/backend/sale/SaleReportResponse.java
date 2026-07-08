package farmacia.backend.sale;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleReportResponse {
        
    private List<Sale> sales;

    private double totalCash;
    private double totalQr;
    private double totalGeneral;
    
}
