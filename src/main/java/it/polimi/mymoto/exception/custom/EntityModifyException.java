package it.polimi.mymoto.exception.custom;

public class EntityModifyException extends RuntimeException {
    public <T> EntityModifyException(Class<T> entityClass) {
        super(entityClass.getSimpleName() + " registration failed");
    }

    public EntityModifyException(String message) {
        super(message);
    }
}
