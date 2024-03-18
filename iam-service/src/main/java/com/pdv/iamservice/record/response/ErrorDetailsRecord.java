package com.pdv.iamservice.record.response;

import java.time.LocalDateTime;

/**
 * This record contains the details of the error.
 */
public record ErrorDetailsRecord(int status, 
                                 String error,
                                 String message,
                                 LocalDateTime dateTime,
                                 Object data) {
}
