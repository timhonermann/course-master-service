package ch.hontech.course_master.course.controllers;

import ch.hontech.course_master.course.dtos.ClientDto;
import ch.hontech.course_master.course.mappers.ClientMapper;
import ch.hontech.course_master.course.services.ClientService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    private final ClientMapper clientMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto create(@RequestBody ClientDto clientDto) {
        final var client = clientService.create(clientMapper.dtoToClient(clientDto));

        return clientMapper.clientToDto(client);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> getAll() {
        return clientService.getAll().stream()
            .map(clientMapper::clientToDto)
            .toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto get(@PathVariable("id") UUID id) {
        final var client = clientService.get(id);

        return clientMapper.clientToDto(client);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto update(@PathVariable("id") UUID id, @RequestBody ClientDto clientDto) {
        final var client = clientService.update(clientMapper.dtoToClient(id, clientDto));

        return clientMapper.clientToDto(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id) {
        clientService.delete(id);
    }

}
