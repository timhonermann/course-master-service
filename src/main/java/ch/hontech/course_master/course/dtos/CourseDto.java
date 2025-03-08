package ch.hontech.course_master.course.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;

@Builder
public record CourseDto(
    UUID id,
    LocalDateTime createdAt,
    LocalDate startsAt,
    LocalDate endsAt,
    ClientDto client,
    PartnerDto partner,
    CourseTypeDto courseType
) {
}
