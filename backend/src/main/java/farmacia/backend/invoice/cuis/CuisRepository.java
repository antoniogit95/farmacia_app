package farmacia.backend.invoice.cuis;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisRepository extends JpaRepository<Cuis, Long>{
 
    Optional<Cuis> findFirstByStatusTrueOrderByFechaVigenciaDesc();

}
