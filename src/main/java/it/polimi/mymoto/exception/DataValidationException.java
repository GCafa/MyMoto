package it.polimi.mymoto.exception;

public class DataValidationException extends RuntimeException {
    public DataValidationException(String message) {
        super("Data validation failed. " + message);
    }
}
