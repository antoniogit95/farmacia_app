package farmacia.backend.user;

import java.util.Optional;

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
}
