package farmacia.backend.sale.saleDetail;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("api/v1/saledetail")
@RequiredArgsConstructor
public class SaleDetailController {

    private final SaleDetailService saleDetailService;
    
    @GetMapping("/saleid/{id}")
    public ResponseEntity<List<SaleDetail>> getDetailBySale(@PathVariable Long id){
        return saleDetailService.getDetailBySaleId(id);
    } 
}
