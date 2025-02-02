package it.polimi.mymoto.exception.custom;

public class DataValidationException extends RuntimeException {
    public DataValidationException(String message) {
        super(message);
    }

    public DataValidationException()
    {
        super("Data validation failed.");
    }
}
