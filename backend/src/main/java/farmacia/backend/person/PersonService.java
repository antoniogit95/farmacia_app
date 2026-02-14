package farmacia.backend.person;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public boolean existsByCi(String ci) {
        return personRepository.existsByCi(ci);
    }
    
    public Person getPersonById( Long id){
        return null;
    }
}
