package it.polimi.mymoto.exception.custom;

public class EntityDeleteException extends RuntimeException {
    public <T> EntityDeleteException(Class<T> entityClass) {
        super(entityClass.getSimpleName() + " delete failed");
    }

    public EntityDeleteException(String message) {
        super(message);
    }
}
