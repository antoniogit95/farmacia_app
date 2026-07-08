package farmacia.backend.laboratory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LaboratoryService {
    private final LaboratoryRepository repository;

    
    public ResponseEntity<Laboratory> save(LaboratoryRequest request) {
        Laboratory laboratory = Laboratory.builder()
            .name(request.getName())
            .distributorName(request.getDistributorName())
            .phone(request.getPhone())
            .email(request.getEmail())
            .status(true)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build(); 
        repository.save(laboratory);
        return ResponseEntity.ok(laboratory);
    }

    public ResponseEntity<Laboratory> update(Long id, Laboratory laboratory) {
        try {
            System.out.println("lego aqui");
            Optional<Laboratory> existingOptional = repository.findById(id);
            Laboratory existing = existingOptional.get();
            existing.setName(laboratory.getName());
            existing.setDistributorName(laboratory.getDistributorName());
            existing.setPhone(laboratory.getPhone());
            existing.setEmail(laboratory.getEmail());
            existing.setAddress(laboratory.getAddress());
            existing.setStatus(laboratory.getStatus());
            repository.save(existing);
            return ResponseEntity.ok(existing);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    public ResponseEntity<List<Laboratory>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<Laboratory> getLaboratoryById(Long id) {
        return repository.findById(id)
            .map(lab -> ResponseEntity.ok(lab))
            .orElse(ResponseEntity.badRequest().build());
    }

    public ResponseEntity<Boolean> delete(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok(true);
    }
}
