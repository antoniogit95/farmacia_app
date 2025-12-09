package farmacia.backend.medicament;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long>{

    Optional<Medicament> findByComercialNameAndConsetrationAndLaboratory(
            String comercialName, String consentration, String laboratory);
}
