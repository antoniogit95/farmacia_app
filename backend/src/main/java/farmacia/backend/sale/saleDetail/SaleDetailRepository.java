package farmacia.backend.sale.saleDetail;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import farmacia.backend.lote.Lote;
import farmacia.backend.sale.Sale;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {
    
    List<SaleDetail> findAllByLote(Lote lote);

    List<SaleDetail> findAllBySale_Id(Long id);

}
