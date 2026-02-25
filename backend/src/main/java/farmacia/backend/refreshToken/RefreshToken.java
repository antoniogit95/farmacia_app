package farmacia.backend.refreshToken;

import java.time.LocalDateTime;

import farmacia.backend.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class RefreshToken {
    
    @Id
    @GeneratedValue
    private Long id;

    private String token;

    @OneToOne
    private User user;

    private LocalDateTime expiryDate;

    private boolean revoked;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
