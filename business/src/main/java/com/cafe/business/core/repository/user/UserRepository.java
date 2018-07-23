package com.cafe.business.core.repository.user;

import com.cafe.business.core.entity.user.User;
import com.cafe.business.core.service.user.common.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 12:46 PM
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds user for provided username
     *
     * @param userName
     * @return User
     */
    User findByUserName(final String userName);

    /**
     * Finds all users with provided user role
     *
     * @param userRole
     * @return List of users
     */
    List<User> findAllByUserRole(final UserRole userRole);

    /**
     * Finds all active user with provided user role
     *
     * @param userRole
     * @return List of active users
     */
    List<User> findAllByUserRoleAndRemovedIsNull(final UserRole userRole);
}
