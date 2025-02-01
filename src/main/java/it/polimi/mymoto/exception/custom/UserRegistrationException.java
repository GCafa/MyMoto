package it.polimi.mymoto.exception.custom;

public class UserRegistrationException extends RuntimeException {
    public UserRegistrationException() {
        super("User registration failed");
    }

    public UserRegistrationException(String message) {
        super(message);
    }
}
