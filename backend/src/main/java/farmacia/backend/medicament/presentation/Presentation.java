package farmacia.backend.medicament.presentation;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Presentation {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String name;
    
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
