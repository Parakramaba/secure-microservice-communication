package com.pdv.iamservice.exception;

/**
 * Contains a set of reusable constants for error messages.
 */
public final class ErrorMessages {

    // RESOURCE NOT FOUND
    public static final String ROLE_NOT_FOUND_MSG = "Role not found";
    public static final String USER_NOT_FOUND_MSG = "User not found";

    // VALIDATION
    public static final String USER_NAME_ALREADY_EXISTS_MSG = "The username is already in use";

    // AUTHENTICATION
    public static final String JWT_NOT_MATCH_MSG = "JWT does not match";
    public static final String JWT_EXPIRED_MSG = "Your session is expired. Please sign-in again";

    // AUTHORIZATION
    public static final String ACCESS_DENIED_MSG = "You have no permission to access this resource";

    private ErrorMessages(){}
}
