package farmacia.backend.sale;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import farmacia.backend.client.Client;
import farmacia.backend.client.ClientService;
import farmacia.backend.sale.saleDetail.SaleDetail;
import farmacia.backend.sale.saleDetail.SaleDetailRequest;
import farmacia.backend.sale.saleDetail.SaleDetailService;
import farmacia.backend.sale.salePayment.PaymentRequest;
import farmacia.backend.sale.salePayment.SalePaymentService;
import farmacia.backend.user.User;
import farmacia.backend.user.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleService {
 
    private final SaleRepository saleRepository;
    private final ClientService clientService;
    private final UserService userService;
    private final SaleDetailService saleDetailService;
    private final SalePaymentService salePaymentService;


    public ResponseEntity<String> addSale(SaleRequest saleRequest){
        try {

            if(saleRequest.getDetails() == null || saleRequest.getDetails().isEmpty()){
                return new ResponseEntity<>("No existe detalle de venta", HttpStatus.BAD_REQUEST);
            }

            if(saleRequest.getPayments() == null || saleRequest.getPayments().isEmpty()){
                return new ResponseEntity<>("Debe agregar al menos un método de pago", HttpStatus.BAD_REQUEST);
            }

            // validar total pagos
            double totalPayments = saleRequest.getPayments()
                    .stream()
                    .mapToDouble(PaymentRequest::getAmount)
                    .sum();

            if(totalPayments < saleRequest.getSubTotal()){
                return new ResponseEntity<>("El monto pagado es menor al total de la venta", HttpStatus.BAD_REQUEST);
            }

            Client client;

            if (saleRequest.getClientNit() == null || saleRequest.getClientNit().isEmpty()) {
                client = clientService.existClientByNit("1");
            } else {

                client = clientService.existClientByNit(saleRequest.getClientNit());

                if(client == null){
                    Client newClient = Client.builder()
                            .nit(saleRequest.getClientNit())
                            .companyName(saleRequest.getClientname())
                            .createdAt(LocalDateTime.now())
                            .updatedAt(LocalDateTime.now())
                            .build();

                    clientService.save(newClient);
                    client = newClient;
                }
            }

            User user = userService.getUserbyUserName(saleRequest.getUserName());

            if(user == null){
                return new ResponseEntity<>("No existe usuario: "+ saleRequest.getUserName(), HttpStatus.BAD_REQUEST);
            }

            // crear venta
            Sale sale = Sale.builder()
                    .client(client)
                    .user(user)
                    .subTotal(saleRequest.getSubTotal())
                    .totalDiscount(saleRequest.getDiscount())
                    .description(saleRequest.getDescription())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            saleRepository.save(sale);

            // guardar detalles
            List<SaleDetail> saleDetails = new ArrayList<>();

            for (SaleDetailRequest details : saleRequest.getDetails()) {
                saleDetails.add(saleDetailService.save(details, sale));
            }

            // 🔥 GUARDAR PAGOS
            salePaymentService.savePayments(sale, saleRequest.getPayments());

            return ResponseEntity.ok("Venta exitosa");

        } catch (Exception e) {

            System.out.println(e);
            return new ResponseEntity<>("Error inesperado", HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity<SaleReportResponse> getReportSale(SaleRequestReport report){

        LocalDateTime start = report.getStart().atStartOfDay();
        LocalDateTime end = report.getEnd().atTime(23, 59, 59);

        List<Sale> sales = saleRepository.findAllByCreatedAtBetween(start, end);
        double totalGeneral = 0;

        Map<String, Double> objects = salePaymentService.getPayments(start, end);
        
        SaleReportResponse response = SaleReportResponse.builder()
                .sales(sales)
                .totalCash(objects.get("efectivo"))
                .totalQr(objects.get("qr"))
                .totalGeneral(totalGeneral)
                .build();

        return ResponseEntity.ok(response);
    }

    public Sale getSaleById(Long id){
        Optional<Sale> saleOptional = saleRepository.findById(id);
        return saleOptional.isPresent()? saleOptional.get() : null ;
    }
    
}
