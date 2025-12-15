package farmacia.backend.sale;

import java.util.List;

import farmacia.backend.sale.saleDetail.SaleDetailRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleRequest {
    
    private String clientNit;
    private String clientname;
    private Long userId;
    private String description;
    private String saleName;
    private double subTotal;
    private double discount;

    private List<SaleDetailRequest> details;
}
