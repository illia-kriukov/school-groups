package se.school.groups.error;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by illia.kriukov on 1/14/17.
 */
public class ValidationError {

    private final String errorMessage;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> errors = new ArrayList<>();

    public ValidationError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void addValidationError(String error) {
        errors.add(error);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<String> getErrors() {
        return errors;
    }

}