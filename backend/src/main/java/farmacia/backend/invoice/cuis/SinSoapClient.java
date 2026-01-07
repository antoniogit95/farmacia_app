package farmacia.backend.invoice.cuis;

import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.WebServiceTemplate;

import lombok.RequiredArgsConstructor;


@Configuration
@RequiredArgsConstructor
public class SinSoapClient {

    private final WebServiceTemplate webServiceTemplate;

    public <T> T call(String url, Object request) {
        return (T) webServiceTemplate.marshalSendAndReceive(url, request);
    }   
}
