package farmacia.backend.medicament.presentation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/presentation")
public class PresentationController {
    
    private final PresentationService presentationService;

    @GetMapping("/list")
    public ResponseEntity<List<Presentation>> listPresentation(){
        return presentationService.getAllPresentation();
    }
}
