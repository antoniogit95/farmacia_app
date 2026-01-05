package farmacia.backend.invoice;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import farmacia.backend.company.Branch;
import farmacia.backend.sale.Sale;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Invoice {
    
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "branh_id")
    private Branch branch;
    // Datos fiscales
    private Long numeroFactura;        
    private String cuf;        
    private String cufd;     

    private LocalDateTime fechaEmision;



    private BigDecimal montoTotal;
    private BigDecimal montoTotalSujetoIva;

    private Integer codigoMetodoPago;
    private Integer codigoMoneda;
   
    // Estado fiscal
    @Enumerated(EnumType.STRING)
    private InvoiceStatus status; // PENDIENTE, VALIDADA, ANULADA, RECHAZADA

    // XML
    @Lob
    private String xmlFactura;

    private String hashXml;

    // Respuesta SIN
    private String codigoRecepcion;
    private String mensajeSin;

    private LocalDateTime createdAt;
}
