package yan0kom.corpcom.persistence.jpa.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import yan0kom.corpcom.persistence.jpa.entity.ContactJpa;

import java.util.stream.Stream;

public interface ContactJpaRepo extends CrudRepository<ContactJpa, Long> {
    @Query(value = "SELECT * FROM contacts WHERE client_id = :clientId", nativeQuery = true)
    Stream<ContactJpa> streamByClient(@Param("clientId") Long clientId);

    @Query(value = "SELECT * FROM contacts WHERE client_id = :clientId AND type = :type", nativeQuery = true)
    Stream<ContactJpa> streamByClientAndType(@Param("clientId") Long clientId, @Param("type") String type);
}
