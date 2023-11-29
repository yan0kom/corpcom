package yan0kom.corpcom.persistence.jpa.entity;

import yan0kom.corpcom.domain.model.Client;
import yan0kom.corpcom.domain.model.Contact;
import yan0kom.corpcom.domain.model.ContactType;

import java.util.stream.Collectors;

public class Converter {
    public static ContactJpa toContactJpa(ClientJpa clientJpa, Contact contact) {
        var contactJpa = new ContactJpa();
        contactJpa.id = contact.getId();
        contactJpa.client = clientJpa;
        contactJpa.data = contact.getData();
        contactJpa.type = contact.getType().getCode();
        return contactJpa;
    }

    public static ClientJpa toClientJpa(Client client) {
        var clientJpa = new ClientJpa();
        clientJpa.id = client.getId();
        clientJpa.name = client.getName();
        clientJpa.contacts = client.getContacts().stream()
                .map(contact -> toContactJpa(clientJpa, contact))
                .collect(Collectors.toList());
        return clientJpa;
    }

    public static Contact toContact(ContactJpa pe) {
        return new Contact(pe.id, ContactType.fromCode(pe.type), pe.data);
    }

    public static Client toClient(ClientJpa pe) {
        var contacts = pe.contacts.stream()
                .map(Converter::toContact)
                .collect(Collectors.toList());
        return new Client(pe.id, pe.name, contacts);
    }
}
