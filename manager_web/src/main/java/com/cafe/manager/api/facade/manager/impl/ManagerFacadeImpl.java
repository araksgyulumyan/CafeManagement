package com.cafe.manager.api.facade.manager.impl;

import com.cafe.business.core.entity.user.User;
import com.cafe.business.core.service.user.UserService;
import com.cafe.business.core.service.user.common.UserRole;
import com.cafe.business.core.service.user.dto.UserDto;
import com.cafe.business.core.service.user.exception.UserAlreadyExistsForUserNameException;
import com.cafe.manager.api.facade.manager.ManagerFacade;
import com.cafe.manager.api.model.common.response.error.ErrorType;
import com.cafe.manager.api.model.request.user.UserCreationRequestModel;
import com.cafe.manager.api.model.request.user.UserUpdateRequestModel;
import com.cafe.manager.api.model.response.user.UserResponseModel;
import com.cafe.manager.api.validation.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 4:01 PM
 */

@Facade
@Component
public class ManagerFacadeImpl implements ManagerFacade {

    @Autowired
    private UserService userService;

    @Override
    public UserResponseModel create(final UserCreationRequestModel userCreationRequestModel) {
        assertUserCreationRequestModel(userCreationRequestModel);
        try {
            final UserDto userDto = fromCreationRequest(userCreationRequestModel);
            final User user = userService.createUser(userCreationRequestModel.getUserName(), userCreationRequestModel.getPassword(),
                    UserRole.WAITER, userDto);
            return UserResponseModel.fromUser(user);
        } catch (final UserAlreadyExistsForUserNameException ex) {
            final List<ErrorType> errors = new ArrayList<>();
            errors.add(ErrorType.USERNAME_ALREADY_EXISTS);
            return UserResponseModel.withErrors(errors);
        }
    }

    @Override
    public UserResponseModel update(final Long userId, final UserUpdateRequestModel requestModel) {
        assertUserId(userId);
        assertUserUpdateRequestModel(requestModel);
        try {
            final UserDto userDto = new UserDto();
            userDto.setFirstName(requestModel.getFirstName());
            userDto.setLastName(requestModel.getLastName());
            final User user = userService.updateUser(userId, userDto);
            return UserResponseModel.fromUser(user);
        } catch (final UserAlreadyExistsForUserNameException ex) {
            final List<ErrorType> errors = new ArrayList<>();
            errors.add(ErrorType.USERNAME_ALREADY_EXISTS);
            return UserResponseModel.withErrors(errors);
        }
    }

    @Override
    public void remove(final Long userId) {
        assertUserId(userId);
        userService.removeUserById(userId);
    }

    @Override
    public List<UserResponseModel> getWaiters() {
        final List<User> users = userService.getWaiters();
        final List<UserResponseModel> models = new ArrayList<>(users.size());
        for (final User user : users) {
            models.add(UserResponseModel.fromUser(user));
        }
        return models;
    }

    @Override
    public UserResponseModel getManager() {
        return UserResponseModel.fromUser(userService.getManager());
    }

    @Override
    public UserResponseModel getByUserName(final String userName) {
        assertUserName(userName);
        final User user = userService.getUserByUsername(userName);
        return UserResponseModel.fromUser(user);
    }

    @Override
    public UserResponseModel getById(final Long userId) {
        assertUserId(userId);
        final User user = userService.getUserById(userId);
        return UserResponseModel.fromUser(user);
    }

    // Utility methods
    private UserDto fromCreationRequest(final UserCreationRequestModel userCreationRequestModel) {
        final UserDto userDto = new UserDto();
        userDto.setFirstName(userCreationRequestModel.getFirstName());
        userDto.setLastName(userCreationRequestModel.getLastName());
        return userDto;
    }

    private static void assertUserCreationRequestModel(final UserCreationRequestModel userCreationRequestModel) {
        Assert.notNull(userCreationRequestModel, "User creation request model should not be null");
        Assert.hasText(userCreationRequestModel.getUserName(), "User creation request model user name should not be null");
        Assert.hasText(userCreationRequestModel.getPassword(), "User creation request model password should not be null");
        Assert.hasText(userCreationRequestModel.getFirstName(), "User creation request model first name should not be null");
        Assert.hasText(userCreationRequestModel.getLastName(), "User creation request model last name should not be null");
    }

    private static void assertUserId(final Long userId) {
        Assert.notNull(userId, "User Id should not be null");
    }

    private static void assertUserName(final String userName) {
        Assert.hasText(userName, "User name should not be null");
    }

    private static void assertUserUpdateRequestModel(final UserUpdateRequestModel userUpdateRequestModel) {
        Assert.notNull(userUpdateRequestModel, "User creation request model should not be null");
        Assert.hasText(userUpdateRequestModel.getFirstName(), "User update request model first name should not be null");
        Assert.hasText(userUpdateRequestModel.getLastName(), "User update request model last name should not be null");
    }

}
