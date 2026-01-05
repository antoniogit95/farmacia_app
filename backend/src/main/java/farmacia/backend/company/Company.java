package farmacia.backend.company;

import java.time.LocalDateTime;

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
public class Company {
    
    @Id
    @GeneratedValue
    private Long id;

    private String nit;
    private String razonSocial;
    private String nombreComercial;

    private String actividadEconomica;
    private String direccionFiscal;

    private String telefono;
    private String email;

    // SIN
    private String modalidadFacturacion; // ELECTRONICA, COMPUTARIZADA
    private String ambiente; // PRUEBAS / PRODUCCION
    private String municipio;
    private String codigoDocumentoSector; // ej: 1 = Compra-Venta
    private String leyendaFactura; // leyenda SIN

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
