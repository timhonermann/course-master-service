package ch.hontech.course_master.common.exception;

import lombok.Builder;

@Builder
public record ErrorMessage(
    String status,
    String message,
    String description
) {
}
