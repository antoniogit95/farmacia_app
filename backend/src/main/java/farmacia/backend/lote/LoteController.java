package farmacia.backend.lote;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import farmacia.backend.medicament.Medicament;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/lote")
public class LoteController {
    
    private final LoteService loteService;

    @PostMapping("/add")
    public ResponseEntity<String> addLote(@RequestBody LoteRequest loteRequest){
        return loteService.addLoteByIdMedicament(loteRequest);
    }

    @PostMapping("/edit")
    public ResponseEntity<String> EditLote(@RequestBody LoteRequest loteRequest){
        return loteService.editLote(loteRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Lote>> getLotesByMedicamentId(@PathVariable Long id){

        return loteService.getAllLotesByMedicamentId(id);

    }

    @PostMapping("/medicament")
    public List<Lote> getallLotesByMedicament(@RequestBody Medicament medicament){
        return loteService.getAllLotesByMedicament(medicament);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Lote>> getAllLotes(){
        return loteService.getAllLotes();
    }
}
