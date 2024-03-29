package com.pdv.iamservice.exception;

import com.pdv.iamservice.record.response.ErrorDetailsRecord;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * This SecurityExceptionHandler class provides set of methods to handle security related exceptions.
 */
@RestControllerAdvice
public class SecurityExceptionHandler {

    // UNAUTHORIZED:401
    /**
     *
     * @param ex object of {@link BadCredentialsException}
     * @param request {@link WebRequest}
     * @return
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleBadCredentialsException(final BadCredentialsException ex,
                                                           final WebRequest request) {
        ErrorDetailsRecord errorDetails = new ErrorDetailsRecord(HttpStatus.UNAUTHORIZED.value(),
                request.getDescription(false),
                ErrorMessages.CREDENTIALS_NOT_MATCH_MSG,
                LocalDateTime.now(),
                null);

        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

    /**
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<?> handleSignatureException(final SignatureException ex,
                                                      final WebRequest request) {
        ErrorDetailsRecord errorDetails = new ErrorDetailsRecord(HttpStatus.UNAUTHORIZED.value(),
                request.getDescription(false),
                ErrorMessages.JWT_NOT_MATCH_MSG,
                LocalDateTime.now(),
                null);

        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

    /**
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<?> handleExpiredJwtException(final ExpiredJwtException ex,
                                                       final WebRequest request) {
        ErrorDetailsRecord errorDetails = new ErrorDetailsRecord(HttpStatus.UNAUTHORIZED.value(),
                request.getDescription(false),
                ErrorMessages.JWT_EXPIRED_MSG,
                LocalDateTime.now(),
                null);

        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }
    // / UNAUTHORIZED:401

    // FORBIDDEN:403
    /**
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDeniedException(final AccessDeniedException ex,
                                                         final WebRequest request) {
        ErrorDetailsRecord errorDetails = new ErrorDetailsRecord(HttpStatus.FORBIDDEN.value(),
                request.getDescription(false),
                ErrorMessages.ACCESS_DENIED_MSG,
                LocalDateTime.now(),
                null);

        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }
    // / FORBIDDEN:403
}
