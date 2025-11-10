package farmacia.backend.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import farmacia.backend.person.Person;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @EntityGraph(attributePaths = "person")
    Optional<User> findByUsername(String username);

    Optional<User> findByPerson(Person person);
    

}
