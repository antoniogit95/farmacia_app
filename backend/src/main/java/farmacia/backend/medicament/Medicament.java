package farmacia.backend.medicament;

import java.time.LocalDateTime;

import farmacia.backend.medicament.presentation.Presentation;
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
public class Medicament {
    
    @Id
    @GeneratedValue
    private Long id;

    private String genericName;
    private String comercialName;
    private String descrption;

    @ManyToOne
    @JoinColumn( name= "presentation_id") 
    private Presentation presentation;
    
    private String consetration;
    private String pharmaceForm;
    private String laboratory;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
