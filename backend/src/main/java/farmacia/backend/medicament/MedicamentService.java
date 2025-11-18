package farmacia.backend.medicament;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicamentService {
    
    private final MedicamentRepository mRepository;

    public ResponseEntity<String> addMedicament(Medicament medicamentRequest){
        try {
            Medicament medicament = Medicament.builder()
                .genericName(medicamentRequest.getGenericName())
                .comercialName(medicamentRequest.getComercialName())
                .descrption(medicamentRequest.getDescrption())
                .presentation(medicamentRequest.getPresentation())
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

    public LocalDateTime getTimestamp(){
        LocalDateTime now = LocalDateTime.now();
        return now;
    }
}
