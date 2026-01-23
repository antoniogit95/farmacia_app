package farmacia.backend.user;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    public User getUserbyId(Long Id){
        Optional<User> userOptional = userRepository.findById(Id);
        return userOptional.isPresent()? userOptional.get() : null;
    }

    public User getUserbyUserName(String name){
        Optional<User> userOptional = userRepository.findByUsername(name);
        return userOptional.isPresent()? userOptional.get() : null;
    }

    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
}
