package farmacia.backend.signature;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import farmacia.backend.sale.SaleRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/firma")
public class FirmaController {

    private final DigitalSignatureService signatureService;

    @PostMapping("/factura")
    public ResponseEntity<?> firmarFactura(@RequestBody SaleRequest factura) throws Exception {

        // 1️⃣ Convertimos la factura a texto (simulación)
        String facturaTexto = new ObjectMapper()
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(factura);

        // 2️⃣ Firmamos
        String firmaBase64 = signatureService.sign(facturaTexto);

        // 3️⃣ Respuesta
        Map<String, Object> response = new HashMap<>();
        response.put("factura", factura);
        response.put("firmaDigital", firmaBase64);
        response.put("certificado", signatureService.getCertificateBase64());

        return ResponseEntity.ok(response);
    }
}
