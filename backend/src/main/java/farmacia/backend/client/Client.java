package farmacia.backend.client;

import java.time.LocalDateTime;

import farmacia.backend.person.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
    private boolean notifications;

    @OneToOne
    @JoinColumn (name = "id_person", referencedColumnName = "id")
    private Person person;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
