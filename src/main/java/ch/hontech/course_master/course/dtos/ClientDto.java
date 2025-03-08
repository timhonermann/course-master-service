package ch.hontech.course_master.course.dtos;

import java.util.UUID;
import lombok.Builder;

@Builder
public record ClientDto(
    UUID id,
    String name
) {
}
