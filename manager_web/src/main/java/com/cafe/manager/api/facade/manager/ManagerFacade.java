package com.cafe.manager.api.facade.manager;

import com.cafe.manager.api.model.request.user.UserCreationRequestModel;
import com.cafe.manager.api.model.request.user.UserUpdateRequestModel;
import com.cafe.manager.api.model.response.user.UserResponseModel;

import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 4:00 PM
 */

public interface ManagerFacade {

    UserResponseModel create(final UserCreationRequestModel userCreationRequestModel);

    UserResponseModel update(final Long userId, final UserUpdateRequestModel requestModel);

    void remove(final Long userId);

    List<UserResponseModel> getWaiters();

    UserResponseModel getManager();

    UserResponseModel getByUserName(final String userName);

    UserResponseModel getById(final Long userId);
}
