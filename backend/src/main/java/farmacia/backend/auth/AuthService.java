package farmacia.backend.auth;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import farmacia.backend.jwt.JwtService;
import farmacia.backend.person.Person;
import farmacia.backend.person.PersonRepository;
import farmacia.backend.refreshToken.RefreshToken;
import farmacia.backend.refreshToken.RefreshTokenService;
import farmacia.backend.sesion.SesionService;
import farmacia.backend.user.User;
import farmacia.backend.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final SesionService sesionService;
    private final RefreshTokenService refreshTokenService;

    public ResponseEntity<AuthResponse> login(LoginRequest request){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));    
            User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
            boolean status = ((User) user).isStatus();
            if(!status){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(AuthResponse.builder()
                .message("No tienes permisos de autenticación.")
                .build());
            }
            String token = jwtService.generateAccessToken(user);
            String refreshToken = jwtService.generateRefreshToken(user);
            refreshTokenService.createRefreshToken(user, refreshToken);
            sesionService.saveSesion((User) user);
            return ResponseEntity.ok(AuthResponse.builder()
                .accessToken(token)
                .message("Token con exito")
                .success(true)
                .refreshToken(refreshToken)
                .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(AuthResponse.builder()
            .message("Nombre de usuario o contraseña incorrectos.")
            .build());
        }        
    }

    public  AuthResponse register(RegisterRequest request){
        Person person = Person.builder()
                .ci(request.getCi())
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .telefono(request.getTelefono())
                .createdAt(getTimestamp())
                .updatedAt(getTimestamp())
                .build();
        personRepository.save(person);
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .status(true)
                .role(request.getRole())
                .createdAt(getTimestamp())
                .updatedAt(getTimestamp())
                .person(person)
                .build();
        userRepository.save(user);
        return AuthResponse.builder()
                .accessToken(null)
                .message("Usuario creado Satisfactoriamente")
                .build();
    }

    public AuthResponse refresh(String refreshTokenStr) {
        System.out.println("menaje desdel back para ver --> "+refreshTokenStr);
        RefreshToken refreshToken = refreshTokenService.verifyToken(refreshTokenStr);

        User user = refreshToken.getUser();

        String newAccessToken = jwtService.generateAccessToken(user);

        return AuthResponse.builder()
            .accessToken(newAccessToken)
            .message("Token con exito")
            .success(true)
            .refreshToken(refreshTokenStr).build();
    }

    public LocalDateTime getTimestamp(){
        LocalDateTime now = LocalDateTime.now();
        return now;
    }

}
