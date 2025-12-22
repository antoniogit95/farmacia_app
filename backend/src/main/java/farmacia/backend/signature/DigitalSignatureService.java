package farmacia.backend.signature;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.X509Certificate;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

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
}
