package farmacia.backend.sale;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    
    /**
     * obtain all sales within a specified range..
     * @param star date to stared to search.
     * @param end date to ene the searach.
     * @return all sale.
     */
    List<Sale> findAllByCreatedAtBetween(LocalDateTime star, LocalDateTime end);
}
