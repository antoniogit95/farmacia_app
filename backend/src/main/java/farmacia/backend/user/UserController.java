package farmacia.backend.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import farmacia.backend.auth.AuthResponse;
import farmacia.backend.auth.AuthService;
import farmacia.backend.auth.LoginRequest;
import farmacia.backend.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    private final AuthService authService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updatePersonal(
            @PathVariable Long id,
            @RequestBody RequestUser user
        ){
        
        return userService.update(id, user);
    }

    @GetMapping("/existuser")
    public ResponseEntity<Boolean> existUser(@RequestParam String username){
        return ResponseEntity.ok(userService.existByUser(username));
    }

    @PostMapping("/create")
    public ResponseEntity<AuthResponse> create(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PutMapping ("/block/{id}")
    public ResponseEntity<User> userBlock(@PathVariable Long id){
        return userService.userBlock(id);
    }

    @PutMapping("/resetpassword/{id}")
    public ResponseEntity<User> resetPassword(
            @PathVariable Long id,
            @RequestBody LoginRequest request
        ){
        
        return userService.resetPassword(id, request);
    }

}
