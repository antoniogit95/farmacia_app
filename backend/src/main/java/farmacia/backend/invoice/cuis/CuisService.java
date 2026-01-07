package farmacia.backend.invoice.cuis;

import org.springframework.stereotype.Service;

import farmacia.backend.company.Branch;
import farmacia.backend.company.Company;
import farmacia.backend.company.CompanyService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuisService {
    private static final String SIN_URL =
        "https://pilotosiatservicios.impuestos.gob.bo/v2/FacturacionCodigos";

    private final SinSoapClient sinSoapClient;
    private final CompanyService companyService;

    public CuisResponse obtenerCuis() {

        Company company = companyService.getCompany();
        Branch branch = companyService.getBranch();

        CuisRequest request = CuisRequest.builder()
            .codigoAmbiente(2)
            .codigoModalidad(1)
            .codigoSistema("226CB438DB87007E2C71E")
            .codigoSucursal(branch.getCodigoSucursal())
            .nit(company.getNit())
            .build();
        
        return sinSoapClient.call(SIN_URL, request);
    }
    
}
