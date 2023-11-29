package yan0kom.corpcom.domain.service;

import yan0kom.corpcom.domain.model.Client;
import yan0kom.corpcom.domain.model.Contact;
import yan0kom.corpcom.domain.model.ContactType;

import java.util.List;

public interface ClientService {
    Client addClient(Client client);
    Client getClient(Long id);
    List<Client> getAllClients();

    Contact addContact(Long clientId, Contact contact);
    List<Contact> getClientContacts(Long clientId);
    List<Contact> getClientContactsByType(Long clientId, ContactType contactType);
}
