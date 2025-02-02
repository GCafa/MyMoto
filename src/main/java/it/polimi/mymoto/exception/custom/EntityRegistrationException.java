package it.polimi.mymoto.exception.custom;

public class EntityRegistrationException extends RuntimeException {
    public <T> EntityRegistrationException(Class<T> entityClass) {
        super(entityClass.getSimpleName() + " registration failed");
    }

    public EntityRegistrationException(String message) {
        super(message);
    }
}
