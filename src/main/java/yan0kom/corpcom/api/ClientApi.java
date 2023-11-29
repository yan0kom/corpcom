package yan0kom.corpcom.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import yan0kom.corpcom.api.dto.ClientAddInDto;
import yan0kom.corpcom.api.dto.ClientContactAddInDto;
import yan0kom.corpcom.api.dto.ClientContactListOutDto;
import yan0kom.corpcom.api.dto.ClientContactOutDto;
import yan0kom.corpcom.api.dto.ClientInfoOutDto;
import yan0kom.corpcom.api.dto.ClientListOutDto;

@RequestMapping("/api/client")
public interface ClientApi {
    @PostMapping
    ResponseEntity<ClientInfoOutDto> addClient(@RequestBody ClientAddInDto in);

    @PostMapping("/{id}/contact")
    ResponseEntity<ClientContactOutDto> addContact(@PathVariable("id") Long clientId, @RequestBody ClientContactAddInDto in);

    @GetMapping
    ResponseEntity<ClientListOutDto> getList();

    @GetMapping("/{id}")
    ResponseEntity<ClientInfoOutDto> getInfo(@PathVariable("id") Long clientId);

    @GetMapping("/{id}/contact")
    ResponseEntity<ClientContactListOutDto> getContactList(@PathVariable("id") Long clientId);

    @GetMapping("/{id}/contact/{type}")
    ResponseEntity<ClientContactListOutDto> getContactListByType(@PathVariable("id") Long clientId, @PathVariable("type") String type);
}
