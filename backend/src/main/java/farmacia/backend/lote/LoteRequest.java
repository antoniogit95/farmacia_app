package farmacia.backend.lote;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoteRequest {
    
    private Long id;
    private Long medicamentId;
    private String lotNomber;
    private LocalDate expirationTime;
    private double unitPrice;
    private int quantity;
}
