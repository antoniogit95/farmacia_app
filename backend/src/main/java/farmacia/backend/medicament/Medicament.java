package farmacia.backend.medicament;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Medicament {
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String descrption;
    private Double unitPrice;
    private int stok;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
