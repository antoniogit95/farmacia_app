package farmacia.backend.sale.saleDetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SaleDetailRequest {
    
    private Long LoteId;
    private int quantity;
    private double unitPrice;
    private double discount;
    private double subTotal;
    
}
