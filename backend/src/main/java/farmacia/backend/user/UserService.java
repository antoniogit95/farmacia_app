package farmacia.backend.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import farmacia.backend.auth.LoginRequest;
import farmacia.backend.person.Person;
import farmacia.backend.person.PersonRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    private final PersonRepository personRepository;

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

    public ResponseEntity<User> update(Long id, RequestUser request){
        try {
            Optional<User> optionalUser = userRepository.findById(id);

            if(optionalUser.isEmpty()){
                return ResponseEntity.notFound().build();
            }

            User user = optionalUser.get();
            Person person = user.getPerson();

            person.setName(request.getName());
            person.setSurname(request.getSurname());
            person.setTelefono(request.getTelefono());
            person.setEmail(request.getEmail());
            person.setUpdatedAt(LocalDateTime.now());

            personRepository.save(person);

            user.setUsername(request.getUsername());
            user.setRole(request.getRole());
            user.setUpdatedAt(LocalDateTime.now());

            userRepository.save(user);

            return  ResponseEntity.ok(user);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public boolean existByUser(String user){
        return userRepository.existsByUsername(user);
    } 

    public ResponseEntity<User> userBlock(Long id){
        try {
            
            Optional<User> userOptional = userRepository.findById(id);

            if(userOptional.isEmpty()){
                return ResponseEntity.notFound().build();
            }

            User user = userOptional.get();

            if(user.isStatus()){
                user.setStatus(false);
            }else{
                user.setStatus(true);
            }

            user.setUpdatedAt(LocalDateTime.now());

            userRepository.save(user);

            return ResponseEntity.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();         
        }
    }

    public ResponseEntity<User> resetPassword(Long id, LoginRequest request){
        try {
            
            Optional<User> userOptional = userRepository.findById(id);

            if(userOptional.isEmpty()){
                return ResponseEntity.notFound().build();
            }

            User user = userOptional.get();

            user.setPassword(request.getPassword());
            user.setUpdatedAt(LocalDateTime.now());

            userRepository.save(user);

            return ResponseEntity.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();         
        }
    }

}
