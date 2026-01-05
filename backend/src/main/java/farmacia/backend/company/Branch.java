package farmacia.backend.company;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Branch {
    @Id
    @GeneratedValue
    private Long id;

    private Integer codigoSucursal; 
    private String nombre;
    private String municipio;
    private String direccion;
    private Integer codigoPuntoVenta;
    private String actividadEconomica;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
