package farmacia.backend.laboratory;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/laboratory")
public class LaboratoryController {
     
    private final LaboratoryService service;

    @PostMapping("/add")
    public ResponseEntity<Laboratory> create(@RequestBody LaboratoryRequest request) {
        return service.save(request);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Laboratory>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratory> findById(@PathVariable Long id) {
        return service.getLaboratoryById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Laboratory> update(@PathVariable Long id, @RequestBody Laboratory laboratory) {
        System.out.println("ENTRO AL UPDATE");
        return service.update(id, laboratory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return service.delete(id);
    }    
}
