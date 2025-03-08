package ch.hontech.course_master.course.mappers;

import ch.hontech.course_master.course.dtos.ClientDto;
import ch.hontech.course_master.course.entities.Client;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public ClientDto clientToDto(Client client) {
        return ClientDto.builder()
            .id(client.getId())
            .name(client.getName())
            .build();
    }

    public Client dtoToClient(UUID id, ClientDto clientDto) {
        return Client.builder()
            .id(id)
            .name(clientDto.name())
            .build();
    }

    public Client dtoToClient(ClientDto clientDto) {
        return Client.builder()
            .id(clientDto.id())
            .name(clientDto.name())
            .build();
    }
}
