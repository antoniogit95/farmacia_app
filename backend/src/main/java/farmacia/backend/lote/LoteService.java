package farmacia.backend.lote;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
                        .salePrice(loteRequest.getSalePrice())
                        .status(loteRequest.isStatus())
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

    public ResponseEntity<String> editLote(LoteRequest loteRequest){
        try {
            Optional<Lote> optional = loteRepository.findById(loteRequest.getId());

            Lote lote= optional.get();
            lote.setQuantity(loteRequest.getQuantity());
            lote.setUnitPrice(loteRequest.getUnitPrice());
            lote.setExpirationTime(loteRequest.getExpirationTime());
            lote.setUpdatedAt(LocalDateTime.now());
            lote.setSalePrice(loteRequest.getSalePrice());
            lote.setStatus(loteRequest.isStatus());
            loteRepository.save(lote);

            return ResponseEntity.ok("exitoso");
        } catch (Exception e) {
           return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<Lote>> getAllLotesByMedicamentId(Long medicamentId){
        List<Lote> lotes = loteRepository.findAllByMedicamentId(medicamentId);
        List<Lote> response = new ArrayList<>();
        for (Lote lote : lotes) {
            if(lote.getQuantity() > 0){
                response.add(lote);
            }
        }
        return ResponseEntity.ok(response);
    }

    public List<Lote> getAllLotesByMedicament(Medicament medicamentId){
        List<Lote> response = loteRepository.findAllByMedicament(medicamentId);
        return response;
    }

    public Lote getLotebyId(Long id){
        Optional<Lote> loteOptional = loteRepository.findById(id); 
        return loteOptional.isPresent()? loteOptional.get() : null; 
    }

    public void addVenta(Lote lote, int quantity){
        lote.setQuantity(lote.getQuantity() - quantity);
        lote.setUpdatedAt(LocalDateTime.now());
        loteRepository.save(lote);
    }

    public ResponseEntity<List<Lote>> getAllLotes(){
        List<Lote> response = loteRepository.findAll();
        return ResponseEntity.ok(response);
    }
}
