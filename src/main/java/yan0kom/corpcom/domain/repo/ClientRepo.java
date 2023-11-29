package yan0kom.corpcom.domain.repo;

import yan0kom.corpcom.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepo {
    Client add(Client client);
    Optional<Client> get(Long id);
    List<Client> getList();
}
