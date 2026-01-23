package farmacia.backend.medicament;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import farmacia.backend.medicament.presentation.PresentationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicamentService {
    
    private final MedicamentRepository mRepository;
    private final PresentationService pService;

    private String addMedicamentInternal(MedicamentRequest medicamentRequest){
        try {
            boolean exist = mRepository
                    .findByComercialNameAndConsetrationAndLaboratory(
                        medicamentRequest.getComercialName(),
                        medicamentRequest.getConsetration(),
                        medicamentRequest.getLaboratory()
                    ).isPresent();
            if(exist){
                return "duplicated";
            }else{
                Medicament medicament = Medicament.builder()
                    .genericName(medicamentRequest.getGenericName())
                    .comercialName(medicamentRequest.getComercialName())
                    .descrption(medicamentRequest.getDescrption())
                    .consetration(medicamentRequest.getConsetration())
                    .pharmaceForm(medicamentRequest.getPharmaceForm())
                    .presentation(pService.getAddByName(medicamentRequest.getPresentation()))
                    .laboratory(medicamentRequest.getLaboratory())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
                mRepository.save(medicament);
                return "saved";
            }
        } catch (Exception e) {
            return e+"";
        }
        
    }

    public ResponseEntity<String> addMedicament(MedicamentRequest medicamentRequest){
        String result = addMedicamentInternal(medicamentRequest);
        if (result.equals("duplicated")) {
            return new ResponseEntity<>("El medicamento ya existe", HttpStatus.CONFLICT);
        } else if (result.equals("saved")) {
            return new ResponseEntity<>("Medicamento Registrado con exito", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> editarMedicamento(MedicamentRequest medicamentRequest){
        try {

            Optional<Medicament> medicamentOptional = mRepository.findById(medicamentRequest.getId());
            
            Medicament medicament= medicamentOptional.get();
            medicament.setGenericName(medicamentRequest.getGenericName());
            medicament.setComercialName(medicamentRequest.getComercialName());
            medicament.setDescrption(medicamentRequest.getDescrption());
            medicament.setConsetration(medicamentRequest.getConsetration());
            medicament.setPharmaceForm(medicamentRequest.getPharmaceForm());
            medicament.setLaboratory(medicamentRequest.getLaboratory());
            medicament.setPresentation(pService.getAddByName(medicamentRequest.getPresentation()));
            medicament.setUpdatedAt(LocalDateTime.now());
            mRepository.save(medicament);
            return ResponseEntity.ok("Editado con exito");    
        } catch (Exception e) {
            return new ResponseEntity<>("Error Inesperado", HttpStatus.BAD_REQUEST);
        }
        
    }

    public ResponseEntity<String> addfileMedicament(MultipartFile file){
        String res = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String data[] = line.split("[,;|]");
                if (data.length == 7) {
                    MedicamentRequest m = MedicamentRequest.builder()
                        .genericName(data[0])
                        .comercialName(data[1])
                        .descrption(data[2])
                        .presentation(data[3])
                        .consetration(data[4])
                        .pharmaceForm(data[5])
                        .laboratory(data[6])
                        .build();
                    String result = addMedicamentInternal(m);
                    res = res +"\n" + result;
                }else{
                    res = res + "\n"+ "longitud inesperada: "+ data.length;
                }
                
            }

            return  ResponseEntity.ok(res);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Inesperado", HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<List<Medicament>> getAllMedicaments(){
        List<Medicament> medicaments = mRepository.findAll();
        return ResponseEntity.ok(medicaments);
    }
}
