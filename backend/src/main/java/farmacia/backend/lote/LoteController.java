package farmacia.backend.lote;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/lote")
public class LoteController {
    
    //private final LoteService loteService;

    @PostMapping("/add")
    public ResponseEntity<String> addLote(Lote lote){
        return new ResponseEntity<>("congratulation", HttpStatus.OK);
    }
}
