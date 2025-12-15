package farmacia.backend.client;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Client {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column (unique = true)
    private String nit;
    private String companyName;


    //private Person person;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
