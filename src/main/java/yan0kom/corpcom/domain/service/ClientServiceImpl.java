package yan0kom.corpcom.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yan0kom.corpcom.domain.model.Client;
import yan0kom.corpcom.domain.model.Contact;
import yan0kom.corpcom.domain.model.ContactType;
import yan0kom.corpcom.domain.repo.ClientRepo;
import yan0kom.corpcom.domain.repo.ContactRepo;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;
    private final ContactRepo contactRepo;

    @Override
    public Client addClient(Client client) {
        return clientRepo.add(client);
    }

    @Override
    public Client getClient(Long id) {
        return clientRepo.get(id).orElseThrow();
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepo.getList();
    }

    @Override
    public Contact addContact(Long clientId, Contact contact) {
        return contactRepo.add(clientId, contact);
    }

    @Override
    public List<Contact> getClientContacts(Long clientId) {
        return contactRepo.getList(clientId);
    }

    @Override
    public List<Contact> getClientContactsByType(Long clientId, ContactType contactType) {
        return contactRepo.getListByType(clientId, contactType);
    }
}
