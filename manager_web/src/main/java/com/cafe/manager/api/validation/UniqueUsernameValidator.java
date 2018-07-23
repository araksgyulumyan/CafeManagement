package com.cafe.manager.api.validation;

import com.cafe.business.core.service.user.exception.UserNotExistsForUserNameException;
import com.cafe.manager.api.facade.manager.ManagerFacade;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 3:53 PM
 */

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private ManagerFacade managerFacade;

    public UniqueUsernameValidator(ManagerFacade managerFacade) {
        this.managerFacade = managerFacade;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(username)) {
            return false;
        }
        try {
            managerFacade.getByUserName(username);
            return false;
        } catch (final UserNotExistsForUserNameException ex) {
            return true;
        }
    }

}
