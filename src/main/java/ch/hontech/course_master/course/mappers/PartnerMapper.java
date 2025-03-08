package ch.hontech.course_master.course.mappers;

import ch.hontech.course_master.course.dtos.PartnerDto;
import ch.hontech.course_master.course.entities.Partner;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class PartnerMapper {
    public PartnerDto partnerToDto(Partner partner) {
        return PartnerDto.builder()
            .id(partner.getId())
            .name(partner.getName())
            .build();
    }

    public Partner dtoToPartner(PartnerDto partnerDto) {
        return Partner.builder()
            .id(partnerDto.id())
            .name(partnerDto.name())
            .build();
    }

    public Partner dtoToPartner(UUID id, PartnerDto partnerDto) {
        return Partner.builder()
            .id(id)
            .name(partnerDto.name())
            .build();
    }
}
