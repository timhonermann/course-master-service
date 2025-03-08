package ch.hontech.course_master.controller_advisor;

import ch.hontech.course_master.common.exception.ErrorMessage;
import ch.hontech.course_master.common.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage notFoundExceptionHandler(RuntimeException ex, WebRequest request) {
        var status = String.format(
            "%d %s",
            HttpStatus.NOT_FOUND.value(),
            HttpStatus.NOT_FOUND.getReasonPhrase());

        return ErrorMessage.builder()
            .status(status)
            .message(ex.getMessage())
            .description(request.getDescription(false))
            .build();
    }

}
