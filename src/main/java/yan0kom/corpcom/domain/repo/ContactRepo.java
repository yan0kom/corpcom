package yan0kom.corpcom.domain.repo;

import yan0kom.corpcom.domain.model.Contact;
import yan0kom.corpcom.domain.model.ContactType;

import java.util.List;

public interface ContactRepo {
    Contact add(Long clientId, Contact contact);
    List<Contact> getList(Long clientId);
    List<Contact> getListByType(Long clientId, ContactType contactType);
}
