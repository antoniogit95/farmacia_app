package farmacia.backend.sale.saleDetail;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import farmacia.backend.lote.Lote;
import farmacia.backend.lote.LoteService;
import farmacia.backend.sale.Sale;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleDetailService {
    
    private final SaleDetailRepository saleDetailRepository;
    private final LoteService loteService;

    public SaleDetail save(SaleDetailRequest saleDetailRequest, Sale sale){

        Lote lote  = loteService.getLotebyId(saleDetailRequest.getLoteId());
        loteService.addVenta(lote, saleDetailRequest.getQuantity());

        SaleDetail saleDetail = SaleDetail.builder()
                    .sale(sale)
                    .discount(saleDetailRequest.getDiscount())
                    .quantity(saleDetailRequest.getQuantity())
                    .lote(lote)
                    .unitPrice(saleDetailRequest.getUnitPrice())
                    .subTotal(saleDetailRequest.getSubTotal())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
        return saleDetailRepository.save(saleDetail);
    }
}
