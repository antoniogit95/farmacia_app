package farmacia.backend.sale;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SaleRequestReport {
    
    LocalDate start;
    LocalDate end;
    
}
