package farmacia.backend.sale.salePayment;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalePaymentRepository extends JpaRepository<SalePayment, Long> {

    List<SalePayment> findBySaleId(Long saleId);

    @Query("""
    SELECT sp.paymentType, SUM(sp.amount)
    FROM SalePayment sp
    WHERE sp.sale.createdAt BETWEEN :start AND :end
    GROUP BY sp.paymentType
    """)
    List<Object[]> getPayments(LocalDateTime start, LocalDateTime end);

}
