package ch.hontech.course_master.course.dtos;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;

@Builder
public record CourseCreationDto(
    LocalDate startsAt,
    LocalDate endsAt,
    UUID clientId,
    UUID partnerId,
    UUID courseTypeId
) {
}
