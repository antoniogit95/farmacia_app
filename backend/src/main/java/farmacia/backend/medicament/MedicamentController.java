package farmacia.backend.medicament;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/medicament")
public class MedicamentController {
    
    public final MedicamentService mService;

    @PostMapping("/add")
    public ResponseEntity<String> addMedicament(@RequestBody MedicamentRequest medicament){        
        System.out.println("llego aqui");
        return mService.addMedicament(medicament);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Medicament>> getAllMedicament(){
        return mService.getAllMedicaments();
    }
}
