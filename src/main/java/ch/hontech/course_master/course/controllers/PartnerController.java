package ch.hontech.course_master.course.controllers;

import ch.hontech.course_master.course.dtos.PartnerDto;
import ch.hontech.course_master.course.mappers.PartnerMapper;
import ch.hontech.course_master.course.services.PartnerService;
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
@RequestMapping("/api/v1/partners")
public class PartnerController {
    private final PartnerService partnerService;

    private final PartnerMapper partnerMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PartnerDto create(@RequestBody PartnerDto partnerDto) {
        final var partner = partnerService.create(partnerMapper.dtoToPartner(partnerDto));

        return partnerMapper.partnerToDto(partner);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PartnerDto> getAll() {
        return partnerService.getAll().stream()
            .map(partnerMapper::partnerToDto)
            .toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PartnerDto get(@PathVariable("id") UUID id) {
        final var partner = partnerService.get(id);

        return partnerMapper.partnerToDto(partner);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PartnerDto update(@PathVariable("id") UUID id, @RequestBody PartnerDto partnerDto) {
        final var partner = partnerService.update(partnerMapper.dtoToPartner(id, partnerDto));

        return partnerMapper.partnerToDto(partner);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id) {
        partnerService.delete(id);
    }
}
