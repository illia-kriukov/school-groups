package se.school.groups.exception;

/**
 * Created by illia.kriukov on 1/14/17.
 */
public class AccountException extends RuntimeException {

    public AccountException(String message) {
        super(message);
    }

    public AccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountException(Throwable cause) {
        super(cause);
    }

}