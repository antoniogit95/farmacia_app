package farmacia.backend.invoice.cufd;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CufdRepository extends JpaRepository<Cufd, Long>{
    
    Optional<Cufd> findFirstByStatusTrueOrderByFechaVigenciaDesc();

}
