package farmacia.backend.lote;

import java.time.LocalDate;
import java.time.LocalDateTime;

import farmacia.backend.medicament.Medicament;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data
public class Lote {
    
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn (name = "id_medicament", referencedColumnName = "id")
    private Medicament medicament;

    @Column (nullable = false)
    private String lotNomber;

    @Column (nullable = false)
    private LocalDate expirationTime;
    
    @Column (nullable = false)
    private int quantity;
    
    private Double unitPrice;

    @Column(nullable = false)
    private boolean status   = false;

    @Column (nullable = false)
    private Double salePrice;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
