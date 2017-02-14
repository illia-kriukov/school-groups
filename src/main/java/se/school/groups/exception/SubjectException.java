package se.school.groups.exception;

/**
 * Created by illia.kriukov on 1/14/17.
 */
public class SubjectException extends RuntimeException {

    public SubjectException(String message) {
        super(message);
    }

    public SubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubjectException(Throwable cause) {
        super(cause);
    }

}