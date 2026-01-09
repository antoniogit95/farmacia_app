package farmacia.backend.invoice.cuis;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import farmacia.backend.company.CompanyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuisService {

    private final CuisRepository repository;
    private final SinSoapClient sinSoapClient;
    private final CompanyService companyService;

    @Transactional
    public Cuis verificarOCrear() {

        return repository
            .findFirstByStatusTrueOrderByFechaVigenciaDesc()
            .filter(Cuis::estaVigente)
            .orElseGet(this::solicitarNuevo);
    }

    private Cuis solicitarNuevo() {
        CuisRequest request = CuisRequest.builder()
                .codigoAmbiente(2) 
                .codigoModalidad(2)
                .codigoSistema("226CB438DB87007E2C71E")
                .codigoSucursal(companyService.getBranch().getCodigoSucursal())
                .nit(companyService.getCompany().getNit())
                .build();

        String codigoCuis = sinSoapClient.solicitarCuis(request);

        Cuis cuis = Cuis.builder()
                .cuis(codigoCuis)
                .fechaVigencia(LocalDateTime.now().plusHours(24))
                .status(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Cuis res = repository.save(cuis);
        return res;
    }
    
}
