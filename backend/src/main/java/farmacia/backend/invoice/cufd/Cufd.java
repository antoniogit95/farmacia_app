package farmacia.backend.invoice.cufd;

import java.time.LocalDate;
import java.time.LocalDateTime;

import farmacia.backend.company.Company;
import jakarta.persistence.Column;
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
public class Cufd {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String cufd;

    @Column(nullable = false)
    private String codigoControl;

    private LocalDate fecha;

    @Column(nullable = false)
    private LocalDateTime fechaVigencia;

    @Column(nullable = false)
    private boolean status;

    public boolean estaVigente() {
        return status && fechaVigencia.isAfter(LocalDateTime.now());
    }

    @ManyToOne
    private Company company;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
