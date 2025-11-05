package farmacia.backend.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    
    private final AuthService authService;

    @GetMapping
    public ResponseEntity<String> pruebaGet(){
        return new ResponseEntity<>("mensaje desde back end", HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping(value = "/checkci")
    public ResponseEntity<Boolean> getChekci(@RequestBody LoginRequest request){
        return ResponseEntity.ok(false);
    }

     @PostMapping(value = "/checkusername")
    public ResponseEntity<Boolean> getChekUsername(@RequestBody LoginRequest request){
        return ResponseEntity.ok(false);
    }
}
