package farmacia.backend.invoice.cufd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CufdRequest {

    private Integer codigoAmbiente;
    private Integer codigoModalidad;
    private String codigoSistema;
    private Integer codigoSucursal;
    private Integer codigoPuntoVenta;
    private String cuis;
    private String nit;
}
