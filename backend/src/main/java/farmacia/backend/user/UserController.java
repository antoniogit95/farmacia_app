package farmacia.backend.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;

    @PostMapping("/register")
    Public ResponseEntity<TojenResponse> register(@RequestBody User user){
        TokenRespomse token = userService.register(user);
        return ResponseEntity.ok(token);
    }
}
