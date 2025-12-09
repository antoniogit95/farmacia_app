package farmacia.backend.lote;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import farmacia.backend.medicament.Medicament;
import farmacia.backend.medicament.MedicamentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoteService {
    
    private final LoteRepository loteRepository;
    private final MedicamentRepository meRepository;

    public ResponseEntity<String> addLoteByIdMedicament(LoteRequest loteRequest){
        try {
            Optional<Medicament> Optional = meRepository.findById(loteRequest.getMedicamentId());

            if (Optional.isPresent()) {
                Lote lote = Lote.builder()
                        .medicament(Optional.get())
                        .lotNomber(loteRequest.getLotNomber())
                        .expirationTime(loteRequest.getExpirationTime())
                        .quantity(loteRequest.getQuantity())
                        .unitPrice(loteRequest.getUnitPrice())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build();
                loteRepository.save(lote);
                return new ResponseEntity<>("exitoso", HttpStatus.CREATED);
            }
            return new ResponseEntity<>("no existe medicamento", HttpStatus.CONFLICT);
        } catch (Exception e) {
           return new ResponseEntity<>("e", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Lote>> getAllLotesByMedicamentId(Long medicamentId){
        List<Lote> response = loteRepository.findAllByMedicamentId(medicamentId);
        return ResponseEntity.ok(response);
    }

    public List<Lote> getAllLotesByMedicament(Medicament medicamentId){
        List<Lote> response = loteRepository.findAllByMedicament(medicamentId);
        return response;
    }
}
