package com.cafe.business.core.service.user.exception;

import com.cafe.business.core.service.user.common.UserRole;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:04 PM
 */
public class UserNotExistsForRoleException extends RuntimeException {

    private static final long serialVersionUID = 3682254546648341226L;

    // Properties
    private final UserRole userRole;

    // Constructors
    public UserNotExistsForRoleException(final UserRole userRole) {
        super(String.format("User with role '%s' not exists", userRole));
        this.userRole = userRole;
    }

    // Getters
    public UserRole getUserRole() {
        return userRole;
    }
}
