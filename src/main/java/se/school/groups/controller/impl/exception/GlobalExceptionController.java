package se.school.groups.controller.impl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import se.school.groups.error.ValidationError;
import se.school.groups.error.ValidationErrorBuilder;
import se.school.groups.exception.AccountException;
import se.school.groups.exception.GroupException;
import se.school.groups.exception.StudentException;
import se.school.groups.exception.SubjectException;

/**
 * Created by illia.kriukov on 1/15/17.
 */
@ControllerAdvice
@RestController
public class GlobalExceptionController {

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ValidationError handleException(MethodArgumentNotValidException e) {
        return ValidationErrorBuilder.fromBindingErrors(e.getBindingResult());
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ValidationError handleException(AccountException e) {
        return ValidationErrorBuilder.fromException(e);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ValidationError handleException(StudentException e) {
        return ValidationErrorBuilder.fromException(e);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ValidationError handleException(SubjectException e) {
        return ValidationErrorBuilder.fromException(e);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ValidationError handleException(GroupException e) {
        return ValidationErrorBuilder.fromException(e);
    }

}