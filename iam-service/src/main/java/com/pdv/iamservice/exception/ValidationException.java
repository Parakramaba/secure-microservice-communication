package com.pdv.iamservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A ValidationException is thrown when the user request contains data that cannot be accepted by the validation logic.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {

    private static final long SerialVersionUID = 1L;

    /**
     * Constructs a new ValidationException with null as its detail message.
     */
    public ValidationException() { super();}

    /**
     * Constructs a new ValidationException with specified detail message.
     * @param message the detail message. This message is saved and can be retrieved later
     */
    public ValidationException(String message) {
        super(message);
    }
}
