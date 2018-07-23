package com.cafe.business.core.service.user.exception;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:01 PM
 */
public class UserNotExistsForUserNameException extends RuntimeException {

    private static final long serialVersionUID = 2936288433914000410L;

    // Properties
    private final String userName;

    // Constructors
    public UserNotExistsForUserNameException(final String userName) {
        super(String.format("User with username '%s' not exists", userName));
        this.userName = userName;
    }

    // Getters
    public String getUserName() {
        return userName;
    }
}
