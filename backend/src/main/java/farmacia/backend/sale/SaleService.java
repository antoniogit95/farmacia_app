package farmacia.backend.sale;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import farmacia.backend.client.Client;
import farmacia.backend.client.ClientService;
import farmacia.backend.sale.saleDetail.SaleDetailRequest;
import farmacia.backend.sale.saleDetail.SaleDetailService;
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

    public ResponseEntity<String> addSale(SaleRequest saleRequest){
        try {
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
            for (SaleDetailRequest details : saleRequest.getDetails()) {
                saleDetailService.save(details, sale);
            }
            return ResponseEntity.ok(":venta exitosa");
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>("error inesperado", HttpStatus.BAD_REQUEST);
        }

    }
    
}
