package yan0kom.corpcom.api.dto;

import yan0kom.corpcom.domain.model.Client;
import yan0kom.corpcom.domain.model.Contact;
import yan0kom.corpcom.domain.model.ContactType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static Client toClient(ClientAddInDto dto) {
        var contacts = new ArrayList<Contact>();
        if (dto.getPhones() != null) {
            contacts.addAll(dto.getPhones().stream()
                    .map(phone -> new Contact(null, ContactType.PHONE, phone))
                    .collect(Collectors.toList()));
        }
        if (dto.getEmails() != null) {
            contacts.addAll(dto.getEmails().stream()
                    .map(email -> new Contact(null, ContactType.EMAIL, email))
                    .collect(Collectors.toList()));
        }

        return new Client(null, dto.getName(), contacts);
    }

    public static ClientInfoOutDto toClientInfoOutDto(Client client) {
        var phones = client.getContacts().stream()
                .filter(contact -> contact.getType() == ContactType.PHONE)
                .map(Contact::getData)
                .collect(Collectors.toList());

        var emails = client.getContacts().stream()
                .filter(contact -> contact.getType() == ContactType.EMAIL)
                .map(Contact::getData)
                .collect(Collectors.toList());

        return new ClientInfoOutDto(client.getId(), client.getName(), phones, emails);
    }

    public static ClientListOutDto toClientListOutDto(List<Client> clients) {
        var items = clients.stream()
                .map(client -> new ClientListOutDto.Entry(client.getId(), client.getName()))
                .collect(Collectors.toList());
        return new ClientListOutDto(items);
    }

    public static Contact toContact(ClientContactAddInDto dto) {
        return new Contact(null, ContactType.fromCode(dto.getType()), dto.getData());
    }

    public static ClientContactOutDto toClientContactOutDto(Contact contact) {
        return new ClientContactOutDto(contact.getId(), contact.getType().getCode(), contact.getData());
    }

    public static ClientContactListOutDto toClientContactListOutDto(List<Contact> contacts) {
        var items = contacts.stream().map(Converter::toClientContactOutDto).collect(Collectors.toList());
        return new ClientContactListOutDto(items);
    }
}
