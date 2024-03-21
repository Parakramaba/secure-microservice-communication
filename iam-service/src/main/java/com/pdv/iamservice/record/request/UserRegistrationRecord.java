package com.pdv.iamservice.record.request;

import jakarta.validation.constraints.NotBlank;

/**
 * This record contains the details provided by the user for registration.
 */
public record UserRegistrationRecord(
        @NotBlank(message = "User name is required") String userName,
        @NotBlank(message = "Password is required") String password) {
}
