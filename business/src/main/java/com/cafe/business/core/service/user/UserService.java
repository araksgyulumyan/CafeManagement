package com.cafe.business.core.service.user;

import com.cafe.business.core.entity.user.User;
import com.cafe.business.core.service.user.common.UserRole;
import com.cafe.business.core.service.user.dto.UserDto;

import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 12:56 PM
 */
public interface UserService {

    /**
     * Creates user
     *
     * @param userName
     * @param password
     * @param userRole
     * @param userDto
     * @return User
     */
    User createUser(final String userName, final String password, final UserRole userRole, final UserDto userDto);

    /**
     * Updates user
     *
     * @param userId
     * @param userDto
     * @return user
     */
    User updateUser(final Long userId, final UserDto userDto);

    /**
     * Get user for provided ID
     *
     * @param userId
     * @return User
     * @throws RuntimeException if user doesn't exist for provided id
     */
    User getUserById(final Long userId);

    /**
     * Find user for provided user name
     *
     * @param userName
     * @return User
     * @throws RuntimeException if user doesn't exist for provided username
     */
    User getUserByUsername(final String userName);

    /**
     * Removes user for provided identifier
     *
     * @param userId
     */
    void removeUserById(final Long userId);

    /**
     * Get all waiters
     *
     * @return list of waiters
     */
    List<User> getWaiters();

    /**
     * Get manager
     *
     * @return manager
     */
    User getManager();

    /**
     * Checks if user with role manager already exists
     *
     * @return true if user exists and false in other case
     */
    boolean checkIfManagerExists();


}
