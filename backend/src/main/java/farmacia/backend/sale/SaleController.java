package farmacia.backend.sale;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/sale")
public class SaleController {
    
    private final SaleService saleService;

    @PostMapping("/add")
    public ResponseEntity<String> addSale(@RequestBody SaleRequest saleRequest){
        return saleService.addSale(saleRequest);
    }

    @PostMapping("/reports")
    public ResponseEntity<List<Sale>> getReports(@RequestBody SaleRequestReport report){
        return saleService.getReportSale(report);
    }
}
