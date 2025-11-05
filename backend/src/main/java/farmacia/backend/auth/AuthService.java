package farmacia.backend.auth;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import farmacia.backend.person.Person;
import farmacia.backend.person.PersonRepository;
import farmacia.backend.user.User;
import farmacia.backend.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AuthResponse login(LoginRequest request){
        AuthResponse response = new AuthResponse();
        response.setMessage("error de usuario");
        response.setSuccess(false);
        return response;
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
                .active(false)
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
