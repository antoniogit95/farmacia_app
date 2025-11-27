package farmacia.backend.medicament;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import farmacia.backend.medicament.presentation.PresentationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicamentService {
    
    private final MedicamentRepository mRepository;
    private final PresentationService pService;

    public ResponseEntity<String> addMedicament(MedicamentRequest medicamentRequest){
        try {
            Medicament medicament = Medicament.builder()
                .genericName(medicamentRequest.getGenericName())
                .comercialName(medicamentRequest.getComercialName())
                .descrption(medicamentRequest.getDescrption())
                .presentation(pService.getAddByName(medicamentRequest.getPresentation()))
                .laboratory(medicamentRequest.getLaboratory())
                .createdAt(getTimestamp())
                .updatedAt(getTimestamp())
                .build();
            mRepository.save(medicament);
            return new ResponseEntity<>("add exitosamente", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>("not found", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Medicament>> getAllMedicaments(){
        List<Medicament> medicaments = mRepository.findAll();
        return ResponseEntity.ok(medicaments);
    }

    public LocalDateTime getTimestamp(){
        LocalDateTime now = LocalDateTime.now();
        return now;
    }
}
