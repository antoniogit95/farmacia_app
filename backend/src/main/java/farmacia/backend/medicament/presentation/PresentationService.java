package farmacia.backend.medicament.presentation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PresentationService {
    private final PresentationRepository presentationRepository;

    public ResponseEntity<List<Presentation>> getAllPresentation(){
        List<Presentation> presentations = presentationRepository.findAll();
        return ResponseEntity.ok(presentations);
    }

    /**
     * Add a presentation, but if one already exists, it only retrieves the data from the presentation.
     * @param name
     * @return presentation
     */
    public Presentation getAddByName(String name){
        Optional<Presentation> optional = presentationRepository.findByName(name);
        Presentation presentation;
        System.out.println("llego a sacar la presentacion:  " + name);
        if(optional.isEmpty()){
            presentation = Presentation.builder()
                .name(name)
                .createdAt(getTimestamp())
                .updatedAt(getTimestamp())
                .build();
            presentationRepository.save(presentation);
        }else{
            presentation = optional.get();
        }
        return presentation;
    }

    public LocalDateTime getTimestamp(){
        LocalDateTime now = LocalDateTime.now();
        return now;
    }
}
