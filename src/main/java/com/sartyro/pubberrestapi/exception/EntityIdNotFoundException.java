package com.sartyro.pubberrestapi.exception;

import jakarta.persistence.EntityNotFoundException;

public class EntityIdNotFoundException extends EntityNotFoundException {
    private static final String BASE_MESSAGE_1 = "%s entity with that ID not found.";
    private static final String BASE_MESSAGE_2 = "%s entity with %d ID not found.";
    private Class<?> className;
    public EntityIdNotFoundException(Class<?> className){
        super(String.format(BASE_MESSAGE_1, className.getSimpleName()));
    }
    public EntityIdNotFoundException(Class<?> className, Long entityId){
        super(String.format(BASE_MESSAGE_2, className.getSimpleName(),entityId));
    }
    public EntityIdNotFoundException(String message){
        super(message);
    }
}
