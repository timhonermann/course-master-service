package ch.hontech.course_master.course.services;

import ch.hontech.course_master.common.exception.NotFoundException;
import ch.hontech.course_master.course.entities.Client;
import ch.hontech.course_master.course.repositories.ClientRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client create(Client client) {
        client.setId(UUID.randomUUID());

        return clientRepository.save(client);
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client get(UUID id) {
        return clientRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Client with ID" + id + "not found"));
    }

    public Client update(Client client) {
        return clientRepository.save(client);
    }

    public void delete(UUID id) {
        clientRepository.deleteById(id);
    }
}
