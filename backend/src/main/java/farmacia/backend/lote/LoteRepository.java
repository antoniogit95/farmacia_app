package farmacia.backend.lote;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import farmacia.backend.medicament.Medicament;


@Repository
public interface LoteRepository extends JpaRepository<Lote, Long>{

    List<Lote> findAllByMedicamentId(Long id);
    List<Lote> findAllByMedicament(Medicament medicament);
}
