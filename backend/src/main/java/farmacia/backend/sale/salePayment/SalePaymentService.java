package farmacia.backend.sale.salePayment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import farmacia.backend.sale.Sale;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalePaymentService {

    private final SalePaymentRepository salePaymentRepository;

    public void savePayments(Sale sale, List<PaymentRequest> payments){

        List<SalePayment> paymentList = new ArrayList<>();

        for(PaymentRequest p : payments){

            SalePayment payment = SalePayment.builder()
                    .sale(sale)
                    .paymentType(p.getPaymentType())
                    .amount(p.getAmount())
                    .build();

            paymentList.add(payment);
        }

        salePaymentRepository.saveAll(paymentList);
    }
    
    public Map<String, Double> getPayments(LocalDateTime start, LocalDateTime end) {

        List<Object[]> results = salePaymentRepository.getPayments(start, end);

        Map<String, Double> payments = new HashMap<>();

        for (Object[] row : results) {

            String type = (String) row[0];
            Double total = ((Number) row[1]).doubleValue();

            payments.put(type, total);
        }

        return payments;
    }

}
