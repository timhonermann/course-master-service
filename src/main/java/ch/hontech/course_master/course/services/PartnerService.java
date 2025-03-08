package ch.hontech.course_master.course.services;

import ch.hontech.course_master.common.exception.NotFoundException;
import ch.hontech.course_master.course.entities.Partner;
import ch.hontech.course_master.course.repositories.PartnerRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartnerService {
    private final PartnerRepository partnerRepository;

    public Partner create(Partner partner) {
        partner.setId(UUID.randomUUID());

        return partnerRepository.save(partner);
    }

    public List<Partner> getAll() {
        return partnerRepository.findAll();
    }

    public Partner get(UUID id) {
        return partnerRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Partner with ID" + id + "not found"));
    }

    public Partner update(Partner partner) {
        return partnerRepository.save(partner);
    }

    public void delete(UUID id) {
        partnerRepository.deleteById(id);
    }
}
