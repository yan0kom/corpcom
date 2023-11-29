package yan0kom.corpcom.persistence.jpa.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yan0kom.corpcom.persistence.jpa.entity.ClientJpa;

import java.util.stream.Stream;

@Repository
public interface ClientJpaRepo extends CrudRepository<ClientJpa, Long> {
    @Query("SELECT c FROM ClientJpa c")
    Stream<ClientJpa> streamAll();
}
