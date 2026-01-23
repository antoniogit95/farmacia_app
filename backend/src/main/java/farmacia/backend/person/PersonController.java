package farmacia.backend.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/person")
public class PersonController {
    
    @PostMapping("/existCi")
    public boolean existCi(){
        return true;
    }

}
