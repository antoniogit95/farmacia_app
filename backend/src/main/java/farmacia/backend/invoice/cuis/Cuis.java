package farmacia.backend.invoice.cuis;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Cuis {

    @Id
    @GeneratedValue
    private Long id; 
    
    @Column(nullable = false)
    private String  cuis;

    @Column(nullable = false)
    private Integer codigoSucursal;

    @Column(nullable = false)
    private Integer codigoPuntoVenta;

    @Column(nullable = false)
    private LocalDateTime fechaVigencia;

    @Column(nullable = false)
    private boolean status;

    public boolean estaVigente() {
        return status && fechaVigencia.isAfter(LocalDateTime.now());
    }

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
