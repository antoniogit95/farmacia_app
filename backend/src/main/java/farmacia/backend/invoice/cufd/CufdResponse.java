package farmacia.backend.invoice.cufd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CufdResponse {
     
    private String codigo;
    private String codigoControl;
    private String fechaVigencia;
    private String mensajesList;

}
