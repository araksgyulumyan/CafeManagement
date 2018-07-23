package com.cafe.business.core.service.user.exception;

import com.cafe.business.core.service.user.common.UserRole;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:02 PM
 */
public class UserAlreadyExistsForRoleException extends RuntimeException {

    private static final long serialVersionUID = 6363736379745563107L;

    // Properties
    private final UserRole userRole;

    // Constructors
    public UserAlreadyExistsForRoleException(final UserRole userRole) {
        super(String.format("User with role %s already exists", userRole.name()));
        this.userRole = userRole;
    }

    // Getters
    public UserRole getUserRole() {
        return userRole;
    }
}
