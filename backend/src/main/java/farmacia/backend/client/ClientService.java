package farmacia.backend.client;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
    
    private final ClientRepository clientRepository;

    public Client existClientByNit(String nit){
        Optional<Client> optionalClient = clientRepository.findByNit(nit);
        if (optionalClient.isPresent()) {
            return optionalClient.get();
        } else {
            return null;
        }
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }
}
