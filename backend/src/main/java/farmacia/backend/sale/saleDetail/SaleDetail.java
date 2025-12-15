package farmacia.backend.sale.saleDetail;

import java.time.LocalDateTime;

import farmacia.backend.lote.Lote;
import farmacia.backend.sale.Sale;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SaleDetail {
    
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn (name = "id_sale", referencedColumnName = "id")
    private Sale sale;

    @ManyToOne
    @JoinColumn (name = "id_Lote", referencedColumnName = "id")
    private Lote lote;

    private int quantity;
    private double discount;
    private double subTotal;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
