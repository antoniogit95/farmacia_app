package farmacia.backend.invoice;

import java.time.LocalDate;
import java.time.LocalDateTime;

import farmacia.backend.company.Company;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
/**
 * Cuf --> Codigo Unico de Facturacion Diaria
 */
public class cufd {
    
    @Id
    @GeneratedValue
    private Long id;

    private String cufd;
    private String codigoControl;

    private LocalDate fecha;
    private Integer codigoSucursal;
    private Integer codigoPuntoVenta;

    private LocalDateTime fechaVigencia;

    @ManyToOne
    private Company company;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
