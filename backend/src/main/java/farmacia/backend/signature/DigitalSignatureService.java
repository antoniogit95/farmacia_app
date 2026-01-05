package farmacia.backend.signature;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import farmacia.backend.sale.Sale;
import jakarta.annotation.PostConstruct;

@Service
public class DigitalSignatureService {
    @Value("${server.ssl.key-store}")
    private String keyStorePath;

    @Value("${server.ssl.key-store-password}")
    private String keyStorePassword;

    @Value("${server.ssl.key-alias}")
    private String keyAlias;

    private PrivateKey privateKey;
    private X509Certificate certificate;

    private static final ObjectMapper mapper = new ObjectMapper()
        .configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

    @PostConstruct
    public void loadKeyStore() throws Exception {

        KeyStore keyStore = KeyStore.getInstance("PKCS12");

        try (InputStream is = new ClassPathResource(
                keyStorePath.replace("classpath:", "")
        ).getInputStream()) {

            keyStore.load(is, keyStorePassword.toCharArray());
        }

        privateKey = (PrivateKey) keyStore.getKey(
                keyAlias,
                keyStorePassword.toCharArray()
        );

        certificate = (X509Certificate) keyStore.getCertificate(keyAlias);
    }


    public String firmarXml(String xml) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update(xml.getBytes(StandardCharsets.UTF_8));

            byte[] firma = signature.sign();
            return Base64.getEncoder().encodeToString(firma);

        } catch (Exception e) {
            throw new RuntimeException("Error firmando XML", e);
        }
    }

    public String sign(String data) throws Exception {

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes(StandardCharsets.UTF_8));

        byte[] signedData = signature.sign();
        return Base64.getEncoder().encodeToString(signedData);
    }

    public String getCertificateBase64() throws Exception {
        return Base64.getEncoder().encodeToString(certificate.getEncoded());
    }

    public boolean verificarFirma(Sale factura, String firmaBase64, String certificadoBase64) {
        try {
            // 🔍 DEBUG
            System.out.println("Certificado recibido:");
            System.out.println(certificadoBase64);

            // 1️⃣ Decodificar certificado
            byte[] certBytes = Base64.getDecoder().decode(certificadoBase64);

            CertificateFactory factory = CertificateFactory.getInstance("X.509");
            X509Certificate certificate = (X509Certificate)
                    factory.generateCertificate(new ByteArrayInputStream(certBytes));

            // 2️⃣ Clave pública
            PublicKey publicKey = certificate.getPublicKey();

            // 3️⃣ Inicializar verificador
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);

            // 4️⃣ Datos originales (MISMO ORDEN)
            byte[] data = convertirFacturaABytes(factura);
            signature.update(data);

            // 5️⃣ Verificar
            byte[] firmaBytes = Base64.getDecoder().decode(firmaBase64);
            return signature.verify(firmaBytes);

        } catch (Exception e) {
            throw new RuntimeException("Error al verificar firma digital", e);
        }
    }

    private byte[] convertirFacturaABytes(Sale factura) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        return mapper.writeValueAsBytes(factura);
    }
}
