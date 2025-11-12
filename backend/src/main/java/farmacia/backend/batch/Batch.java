package farmacia.backend.batch;

import java.time.LocalDateTime;

import farmacia.backend.medicament.Medicament;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Batch {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn (name = "id_medicament", referencedColumnName = "id")
    private Medicament medicament;

    private String lotNumber;
    private LocalDateTime expirationDate;
    private int quantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
