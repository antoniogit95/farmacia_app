package farmacia.backend.invoice.cuis;

import org.hibernate.validator.internal.util.logging.Log_.logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.WebServiceTemplate;

import farmacia.backend.invoice.cufd.CufdRequest;
import farmacia.backend.invoice.cufd.CufdResponse;
import lombok.RequiredArgsConstructor;


@Configuration
@RequiredArgsConstructor
public class SinSoapClient {
    
    private static final String SIN_CODIGOS_URL =
        "https://pilotosiatservicios.impuestos.gob.bo/v2/FacturacionCodigos";

    private final WebServiceTemplate webServiceTemplate;

    public String solicitarCuis(CuisRequest request) {
        try {
            System.out.println("LLego hasta aqui para pedir codigo, creo el request para la factura");
            CuisResponse response =
                (CuisResponse) webServiceTemplate.marshalSendAndReceive(
                    SIN_CODIGOS_URL,
                    request
                );

            System.out.println("LLego hasta aqui para pedir codigo, paso la parte para pedir el codigo");
            if (response == null || response.getCuis() == null) {
                throw new RuntimeException(
                    "Error al obtener CUIS: " +
                    (response != null ? response.getMensajesList() : "sin respuesta")
                );
            }
            System.out.println(response.getCuis());
            return response.getCuis();

            
        } catch (Exception e) {
            System.out.println("Error al llamar al SIN (CUIS)" + e);
            throw e;
        }
    }

    public CufdResponse solicitarCufd(CufdRequest request) {


        Object response = webServiceTemplate.marshalSendAndReceive(
            SIN_CODIGOS_URL,
            request
        );

        if (response == null) {
            throw new RuntimeException("El SIN no respondió al solicitar CUFD");
        }

        return (CufdResponse) response;
    }
}
