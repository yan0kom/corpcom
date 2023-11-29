package yan0kom.corpcom.persistence.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import yan0kom.corpcom.domain.model.Client;
import yan0kom.corpcom.domain.repo.ClientRepo;
import yan0kom.corpcom.persistence.jpa.entity.Converter;
import yan0kom.corpcom.persistence.jpa.repo.ClientJpaRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class ClientRepoImpl implements ClientRepo {
    private final ClientJpaRepo clientJpaRepo;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Client add(Client client) {
        var pe = clientJpaRepo.save(Converter.toClientJpa(client));
        return Converter.toClient(pe);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Client> get(Long id) {
        return clientJpaRepo.findById(id).map(Converter::toClient);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> getList() {
        return clientJpaRepo.streamAll().map(Converter::toClient).collect(Collectors.toList());
    }
}
