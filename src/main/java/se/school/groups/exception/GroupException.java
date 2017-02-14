package se.school.groups.exception;

/**
 * Created by illia.kriukov on 1/14/17.
 */
public class GroupException extends RuntimeException {

    public GroupException(String message) {
        super(message);
    }

    public GroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public GroupException(Throwable cause) {
        super(cause);
    }

}