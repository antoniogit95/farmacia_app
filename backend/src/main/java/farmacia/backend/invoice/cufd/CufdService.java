package farmacia.backend.invoice.cufd;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import farmacia.backend.company.CompanyService;
import farmacia.backend.invoice.cuis.CuisService;
import farmacia.backend.invoice.cuis.SinSoapClient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CufdService {

    private final CufdRepository repository;
    private final SinSoapClient sinSoapClient;
    private final CuisService cuisService;
    private final CompanyService companyService;

    @Transactional
    public Cufd verificarOCrear() {

        return repository.findFirstByStatusTrueOrderByFechaVigenciaDesc()
                .filter(Cufd::estaVigente)
                .orElseGet(this::solicitarNuevo);
    }

    private Cufd solicitarNuevo() {
        CufdRequest request = CufdRequest.builder()
                .codigoAmbiente(2)
                .codigoModalidad(1)
                .codigoSistema("226CB438DB87007E2C71E")
                .codigoSucursal(0)
                .codigoPuntoVenta(0)
                .cuis(cuisService.verificarOCrear().getCuis())
                .nit(companyService.getCompany().getNit())
                .build();

        CufdResponse response = sinSoapClient.solicitarCufd(request);

        Cufd cufd = Cufd.builder()
            .cufd(response.getCodigo())
            .codigoControl(response.getCodigoControl())
            .fechaVigencia(LocalDateTime.now().plusHours(24))
            .status(true)
            .build();

        return repository.save(cufd);
    }   
}
