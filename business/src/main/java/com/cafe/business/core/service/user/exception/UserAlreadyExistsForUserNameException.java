package com.cafe.business.core.service.user.exception;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:02 PM
 */
public class UserAlreadyExistsForUserNameException extends RuntimeException {

    private static final long serialVersionUID = 6280304866146038315L;

    // Properties
    private final String userName;

    // Constructors
    public UserAlreadyExistsForUserNameException(final String userName) {
        super(String.format("User with username %s already exists", userName));
        this.userName = userName;
    }

    // Getters
    public String getUserName() {
        return userName;
    }
}
