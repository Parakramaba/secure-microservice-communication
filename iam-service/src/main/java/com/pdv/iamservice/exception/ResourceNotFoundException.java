package com.pdv.iamservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A ResourceNotFoundException is thrown when a certain resource that is requested by the API call cannot be found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long SerialVersionUID = 1L;

    /**
     * Constructs a new ResourceNotFoundException with null as its detail message.
     */
    public ResourceNotFoundException() { super();}

    /**
     * Constructs a new ResourceNotFoundException with specified detail message.
     * @param message the detail message. The message is saved and can be retrieved later
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
