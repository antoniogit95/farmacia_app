package farmacia.backend.person;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {
    
    private final PersonService personService;

    @GetMapping("/existci")
    public ResponseEntity<Boolean> existCi(@RequestParam String ci){
        return ResponseEntity.ok(personService.existsByCi(ci));
    }

}
