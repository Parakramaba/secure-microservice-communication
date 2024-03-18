package com.pdv.iamservice.exception;

/**
 * Contains a set of reusable constants for error messages.
 */
public final class ErrorMessages {

    // RESOURCE NOT FOUND
    public static final String ROLE_NOT_FOUND_MSG = "Role not found";

    // VALIDATION
    public static final String USER_NAME_ALREADY_EXISTS_MSG = "The username you entered is already using by another user." +
            "Please enter a different username";

    private ErrorMessages(){}
}
