package farmacia.backend.medicament.presentation;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationRepository extends JpaRepository<Presentation, Long>{
 
    Optional<Presentation> findByName(String name);
}
