package com.cafe.business.core.service.user.impl;

import com.cafe.business.core.entity.user.User;
import com.cafe.business.core.repository.user.UserRepository;
import com.cafe.business.core.service.user.UserService;
import com.cafe.business.core.service.user.common.UserRole;
import com.cafe.business.core.service.user.dto.UserDto;
import com.cafe.business.core.service.user.exception.UserAlreadyExistsForRoleException;
import com.cafe.business.core.service.user.exception.UserAlreadyExistsForUserNameException;
import com.cafe.business.core.service.user.exception.UserNotExistsForRoleException;
import com.cafe.business.core.service.user.exception.UserNotExistsForUserNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 12:57 PM
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User createUser(final String userName, final String password, final UserRole userRole, final UserDto userDto) {
        assertUserName(userName);
        assertPassword(password);
        assertUserRole(userRole);
        assertUserDto(userDto);
        final boolean existsForUserName = checkIfUserExistsForUserName(userName);
        if (existsForUserName) {
            throw new UserAlreadyExistsForUserNameException(userName);
        }

        if (UserRole.MANAGER.equals(userRole) && checkIfManagerExists()) {
            throw new UserAlreadyExistsForRoleException(userRole);
        }
        User user = new User();
        user.setUserName(userName);
        user.setUserRole(userRole);
        user.setPassword(passwordEncoder.encode(password));
        userDto.updateDomainModelProperties(user);
        user = userRepository.save(user);
        return user;
    }

    @Override
    @Transactional
    public User updateUser(final Long userId, final UserDto userDto) {
        assertUserId(userId);
        assertUserDto(userDto);
        User user = getUserById(userId);
        userDto.updateDomainModelProperties(user);
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(final Long userId) {
        assertUserId(userId);
        final User user = userRepository.getOne(userId);
        assertUserNotNullForId(userId, user);
        return user;
    }

    @Override
    public User getUserByUsername(final String userName) {
        assertUserName(userName);
        final User user = userRepository.findByUserName(userName);
        assertUserNotNullForUserName(userName, user);
        return user;
    }

    @Override
    @Transactional
    public void removeUserById(final Long userId) {
        assertUserId(userId);
        final User user = getUserById(userId);
        user.setRemoved(new Date());
        userRepository.save(user);
    }

    @Override
    public List<User> getWaiters() {
        return userRepository.findAllByUserRoleAndRemovedIsNull(UserRole.WAITER);
    }

    @Override
    public User getManager() {
        List<User> user = userRepository.findAllByUserRole(UserRole.MANAGER);
        if (user.isEmpty()) {
            throw new UserNotExistsForRoleException(UserRole.MANAGER);
        }
        return user.get(0);
    }

    @Override
    public boolean checkIfManagerExists() {
        return userRepository.findAllByUserRole(UserRole.MANAGER).size() > 0;
    }

    // Utility methods
    private static void assertUserDto(final UserDto userDto) {
        Assert.notNull(userDto, "User dto should not be null");
        Assert.hasText(userDto.getFirstName(), "User dto first name should not be null");
        Assert.hasText(userDto.getLastName(), "User dto last name should not be null");
    }

    private static void assertUserName(final String userName) {
        Assert.hasText(userName, "User name should not be null");
    }

    private static void assertUserId(final Long userId) {
        Assert.notNull(userId, "User Id should not be null");
    }

    private void assertUserRole(final UserRole userRole) {
        Assert.notNull(userRole, "User role should not be null");
    }

    private void assertPassword(final String password) {
        Assert.hasText(password, "User password should not be null");
    }

    private void assertUserNotNullForId(final Long userId, final User user) {
        if (user == null) {
            throw new RuntimeException(String.format("User with id '%d' not exists", userId));
        }
    }

    private void assertUserNotNullForUserName(final String userName, final User user) {
        if (user == null) {
            throw new UserNotExistsForUserNameException(userName);
        }
    }

    private boolean checkIfUserExistsForUserName(final String userName) {
        return userRepository.findByUserName(userName) != null;
    }
}
