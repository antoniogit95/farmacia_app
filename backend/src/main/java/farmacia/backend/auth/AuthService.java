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
            String token = jwtService.getToken(user);
            sesionService.saveSesion((User) user);
            return ResponseEntity.ok(AuthResponse.builder()
                .token(token)
                .message("Token con exito")
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
                .token(null)
                .message("Usuario creado Satisfactoriamente")
                .build();
    }

    public LocalDateTime getTimestamp(){
        LocalDateTime now = LocalDateTime.now();
        return now;
    }

}
