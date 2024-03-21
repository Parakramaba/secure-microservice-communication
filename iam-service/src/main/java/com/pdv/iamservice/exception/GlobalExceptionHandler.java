package com.pdv.iamservice.exception;

import com.pdv.iamservice.record.response.ErrorDetailsRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * This GlobalExceptionHandler class provides set of methods to handle general exceptions.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // BAD REQUEST:400
    /**
     * This handler method returns a ResponseEntity with the details of the ValidationException.
     * @param ex ValidationException object, not null
     * @param request WebRequest object, not null
     * @return the details of the exception, not null
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(final ValidationException ex,
                                                             final WebRequest request) {
        ErrorDetailsRecord errorDetails = new ErrorDetailsRecord(HttpStatus.BAD_REQUEST.value(),
                request.getDescription(false),
                ex.getMessage(),
                LocalDateTime.now(),
                null);

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    /**
     * This handler method returns a ResponseEntity with set of validation messages of fields,
     * which cause to throw MethodArgumentNotValidException.
     * @param ex MethodArgumentNotValidException object, not null
     * @param request WebRequest object, not null
     * @return the detail of the exception with a set of validation messages, not null
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex,
                                                                   final WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error
                -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ErrorDetailsRecord errorDetails = new ErrorDetailsRecord(HttpStatus.BAD_REQUEST.value(),
                request.getDescription(false),
                "Invalid input data",
                LocalDateTime.now(),
                errors);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    // BAD REQUEST:400

    // NOT FOUND:404
    /**
     * This handler method returns a ResponseEntity with the details of the ResourceNotFoundException.
     * @param ex ResourceNotFoundException object, not null
     * @param request WebRequest object, not null
     * @return the details of the exception, not null
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(final ResourceNotFoundException ex,
                                                             final WebRequest request) {
        ErrorDetailsRecord errorDetails = new ErrorDetailsRecord(HttpStatus.NOT_FOUND.value(),
                request.getDescription(false),
                ex.getMessage(),
                LocalDateTime.now(),
                null);

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
