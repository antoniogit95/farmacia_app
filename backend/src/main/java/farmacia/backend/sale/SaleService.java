package farmacia.backend.sale;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import farmacia.backend.client.Client;
import farmacia.backend.client.ClientService;
import farmacia.backend.invoice.InvoiceService;
import farmacia.backend.invoice.invoiceSequence.InvoiceSequenceService;
import farmacia.backend.sale.saleDetail.SaleDetail;
import farmacia.backend.sale.saleDetail.SaleDetailRequest;
import farmacia.backend.sale.saleDetail.SaleDetailService;
import farmacia.backend.signature.DigitalSignatureService;
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
    private final InvoiceSequenceService invoiceSequenceService;
    private final InvoiceService invoiceService;
    private final DigitalSignatureService digitalSignatureService;


    public ResponseEntity<String> addSale(SaleRequest saleRequest){
        try {
            Long numFact = invoiceSequenceService.getSequence();
            Client client = clientService.existClientByNit(saleRequest.getClientNit());
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
            
            User user = userService.getUserbyId(saleRequest.getUserId());
            if(user == null){
                return new ResponseEntity<>("no existe Usuario con el Id: "+ saleRequest.getUserId(), HttpStatus.BAD_REQUEST);
            }

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
            List<SaleDetail> saleDetails = new ArrayList<>();
            for (SaleDetailRequest details : saleRequest.getDetails()) {
                saleDetails.add(saleDetailService.save(details, sale));
            }

            String xml = invoiceService.generarXmlFactura(sale, saleDetails, numFact);
            System.out.println(xml);
            String xmlFirmado = digitalSignatureService.firmarXml(xml);
            System.out.println(xmlFirmado);
            return ResponseEntity.ok(":venta exitosa");
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>("error inesperado", HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<List<Sale>> getReportSale(SaleRequestReport report){
        
        LocalDateTime start = report.getStart().atStartOfDay();
        LocalDateTime end = report.getEnd().atTime(23, 59, 59); 
        List<Sale> sales = saleRepository.findAllByCreatedAtBetween(start, end);
        return ResponseEntity.ok(sales);    
    } 
    
}
