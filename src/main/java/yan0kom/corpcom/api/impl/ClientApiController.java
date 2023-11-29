package yan0kom.corpcom.api.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import yan0kom.corpcom.api.ClientApi;
import yan0kom.corpcom.api.dto.ClientAddInDto;
import yan0kom.corpcom.api.dto.ClientContactAddInDto;
import yan0kom.corpcom.api.dto.ClientContactListOutDto;
import yan0kom.corpcom.api.dto.ClientContactOutDto;
import yan0kom.corpcom.api.dto.ClientInfoOutDto;
import yan0kom.corpcom.api.dto.ClientListOutDto;
import yan0kom.corpcom.api.dto.Converter;
import yan0kom.corpcom.domain.model.ContactType;
import yan0kom.corpcom.domain.service.ClientService;

@RequiredArgsConstructor
@RestController
public class ClientApiController implements ClientApi {
    private final ClientService clientService;

    @Override
    public ResponseEntity<ClientInfoOutDto> addClient(ClientAddInDto dto) {
        var client = clientService.addClient(Converter.toClient(dto));
        return ResponseEntity.ok(Converter.toClientInfoOutDto(client));
    }

    @Override
    public ResponseEntity<ClientContactOutDto> addContact(Long clientId, ClientContactAddInDto dto) {
        var contact = clientService.addContact(clientId, Converter.toContact(dto));
        return ResponseEntity.ok(Converter.toClientContactOutDto(contact));
    }

    @Override
    public ResponseEntity<ClientListOutDto> getList() {
        var list = clientService.getAllClients();
        return ResponseEntity.ok(Converter.toClientListOutDto(list));
    }

    @Override
    public ResponseEntity<ClientInfoOutDto> getInfo(Long clientId) {
        var client = clientService.getClient(clientId);
        return ResponseEntity.ok(Converter.toClientInfoOutDto(client));
    }

    @Override
    public ResponseEntity<ClientContactListOutDto> getContactList(Long clientId) {
        var list = clientService.getClientContacts(clientId);
        return ResponseEntity.ok(Converter.toClientContactListOutDto(list));
    }

    @Override
    public ResponseEntity<ClientContactListOutDto> getContactListByType(Long clientId, String type) {
        var list = clientService.getClientContactsByType(clientId, ContactType.fromCode(type));
        return ResponseEntity.ok(Converter.toClientContactListOutDto(list));
    }
}
