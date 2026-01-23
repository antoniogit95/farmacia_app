package farmacia.backend.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import farmacia.backend.person.Person;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{


    Optional<User> findByUsername(String username);

    Optional<User> findByPerson(Person person);
    
    
}
