package farmacia.backend.refreshToken;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import farmacia.backend.user.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository repository;

    public RefreshToken createRefreshToken(User user, String token) {

        Optional<RefreshToken> existing = repository.findByUser(user);

        RefreshToken refreshToken;

        if (existing.isPresent()) {
            refreshToken = existing.get();
            refreshToken.setToken(token);
            refreshToken.setExpiryDate(LocalDateTime.now().plusDays(1));
            refreshToken.setRevoked(false);
            refreshToken.setUpdatedAt(LocalDateTime.now());
        } else {
            refreshToken = RefreshToken.builder()
                    .user(user)
                    .token(token)
                    .expiryDate(LocalDateTime.now().plusDays(1))
                    .revoked(false)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
        }

        return repository.save(refreshToken);
    }

    public RefreshToken verifyToken(String token) {
        RefreshToken refreshToken = repository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Refresh token no existe"));

        if (refreshToken.isRevoked()) {
            throw new RuntimeException("Token revocado");
        }

        if (refreshToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token expirado");
        }

        return refreshToken;
    }
    
    public void revokeAllUserTokens(User user) {
        repository.findByUser(user).ifPresent(token -> {
            token.setRevoked(true);
            repository.save(token);
        });
    }
}

