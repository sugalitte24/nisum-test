package challenger.nisum.java.nisum.repository;

import challenger.nisum.java.nisum.model.Phones;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonesRepository extends JpaRepository<Phones, UUID> {
}
