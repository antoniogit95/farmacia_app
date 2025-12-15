package farmacia.backend.sale;

import java.time.LocalDateTime;

import farmacia.backend.client.Client;
import farmacia.backend.user.User;
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
public class Sale {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn (name = "id_user", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn (name = "id_client", referencedColumnName = "id")
    private Client client;

    private String description;
    private double subTotal;
    private double totalDiscount;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
