package farmacia.backend.medicament;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MedicamentRequest {

    private Long id;
    private String genericName;
    private String comercialName;
    private String descrption;
    private String consetration;
    private String pharmaceForm;
    private String presentation;
    private String laboratory;
}
