package farmacia.backend.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import farmacia.backend.user.Role;
import farmacia.backend.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class JwtService {
    
    private static final String SECRET_KEY="gflIYt8y9eWGqNgOtd0GDSW4SV0rzonGqPCz7kEsXuE";

    public String getToken(User user){
        return getToken(new HashMap<>(), user);
    }

    private String getToken(Map<String, Object> extraClaims, User user){
        Role role = user.getRole();
        System.out.println(role);
        return Jwts.builder()
                .setClaims(extraClaims)
                .claim("role", role)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60   ))
                .signWith(getSecretKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private SecretKey getSecretKey(){
        byte[] keyBytes = SECRET_KEY.getBytes();
        return new SecretKeySpec(keyBytes, "HmacSHA256"); 
    }

    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username  = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Claims getAllClaims(String token){
        return Jwts
            .parser()
            .setSigningKey(getSecretKey())
            .build()
            .parseClaimsJws(token)
            .getBody();

    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpiration (String token){
        return getClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }

}
