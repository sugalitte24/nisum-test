package challenger.nisum.java.nisum.repository;

import challenger.nisum.java.nisum.model.Users;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, UUID> {

    Boolean existsByEmail( String email);
    Optional<Users> findByEmailAndPassword( String email, String password);
}
