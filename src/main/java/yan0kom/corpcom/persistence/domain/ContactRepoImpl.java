package yan0kom.corpcom.persistence.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import yan0kom.corpcom.domain.model.Contact;
import yan0kom.corpcom.domain.model.ContactType;
import yan0kom.corpcom.domain.repo.ContactRepo;
import yan0kom.corpcom.persistence.jpa.entity.Converter;
import yan0kom.corpcom.persistence.jpa.repo.ClientJpaRepo;
import yan0kom.corpcom.persistence.jpa.repo.ContactJpaRepo;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class ContactRepoImpl implements ContactRepo {
    private final ClientJpaRepo clientJpaRepo;
    private final ContactJpaRepo contactJpaRepo;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Contact add(Long clientId, Contact contact) {
        var clientJpa = clientJpaRepo.findById(clientId).orElseThrow();
        var contactJpa = contactJpaRepo.save(Converter.toContactJpa(clientJpa, contact));
        return Converter.toContact(contactJpa);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contact> getList(Long clientId) {
        return contactJpaRepo.streamByClient(clientId)
                .map(Converter::toContact)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contact> getListByType(Long clientId, ContactType contactType) {
        return contactJpaRepo.streamByClientAndType(clientId, contactType.getCode())
                .map(Converter::toContact)
                .collect(Collectors.toList());
    }
}
