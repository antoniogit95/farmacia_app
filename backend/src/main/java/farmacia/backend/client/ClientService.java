package farmacia.backend.client;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import farmacia.backend.person.Person;
import farmacia.backend.person.PersonRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
    
    private final ClientRepository clientRepository;
    private final PersonRepository personRepository;

    public Client existClientByNit(String nit){
        Optional<Client> optionalClient = clientRepository.findByNit(nit);
        if (optionalClient.isPresent()) {
            return optionalClient.get();
        } else {
            return null;
        }
    }

    public ResponseEntity<Client> save(ClientRequest request){

        try {
            Person person = Person.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .telefono(request.getTelefono())
                .ci(request.getCi())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
            personRepository.save(person);
            
            Client client = Client.builder()
                .nit(request.getCi())
                .companyName(request.getSurname()+" "+request.getName())
                .notifications(request.isNotifications())
                .person(person)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
            clientRepository.save(client);
            return ResponseEntity.ok(client);  
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }
}
