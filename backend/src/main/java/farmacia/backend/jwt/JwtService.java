package farmacia.backend.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import farmacia.backend.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {

    private static final String SECRET_KEY = "gflIYt8y9eWGqNgOtd0GDSW4SV0rzonGqPCz7kEsXuE";

    // ================================
    // GENERAR ACCESS TOKEN (15 min)
    // ================================
    public String generateAccessToken(User user) {
        return generateToken(new HashMap<>(), user, 1000L * 60 * 15); // 15 min
    }

    // ================================
    // GENERAR REFRESH TOKEN (8 horas)
    // ================================
    public String generateRefreshToken(User user) {
        return generateToken(new HashMap<>(), user, 1000L * 60 * 60 * 8); // 8Horas
    }

    // ================================
    // GENERAR TOKEN GENERICO
    // ================================
    private String generateToken(Map<String, Object> extraClaims, User user, Long expiration) {

        return Jwts.builder()
                .setClaims(extraClaims)
                .claim("role", user.getRole().name()) // mejor guardar string
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSecretKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // ================================
    // CLAVE SECRETA (IMPORTANTE)
    // ================================
    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes()); // mejor que SecretKeySpec
    }

    // ================================
    // OBTENER USERNAME
    // ================================
    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    // ================================
    // VALIDAR TOKEN
    // ================================
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // ================================
    // OBTENER TODOS LOS CLAIMS
    // ================================
    private Claims getAllClaims(String token){
        return Jwts
            .parser()
            .verifyWith((SecretKey) getSecretKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }

    // ================================
    // OBTENER CLAIM GENERICO
    // ================================
    public <T> T getClaim(String token, Function<Claims, T> resolver) {
        final Claims claims = getAllClaims(token);
        return resolver.apply(claims);
    }

    // ================================
    // EXPIRACION
    // ================================
    public Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    public boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    // ================================
    // VALIDAR SOLO TOKEN (sin userDetails)
    // ================================
    public boolean isTokenValid(String token) {
        try {
            getAllClaims(token);
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }
}