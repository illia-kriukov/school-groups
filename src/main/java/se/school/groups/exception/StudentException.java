package se.school.groups.exception;

/**
 * Created by illia.kriukov on 1/14/17.
 */
public class StudentException extends RuntimeException {

    public StudentException(String message) {
        super(message);
    }

    public StudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentException(Throwable cause) {
        super(cause);
    }

}