package it.polimi.mymoto.exception.custom;

public class EntityNotFoundException extends RuntimeException{
    public <T> EntityNotFoundException(Class<T> entityClass) {
        super(entityClass.getSimpleName() + " not found");
    }
}
