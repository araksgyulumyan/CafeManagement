package com.cafe.manager.api.validation;

import com.cafe.business.core.service.table.exception.TableNotExistsForTableNumberException;
import com.cafe.manager.api.facade.table.CafeTableFacade;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 6:12 PM
 */
public class UniqueTableNumberValidator implements ConstraintValidator<UniqueTableNumber, Integer> {

    private CafeTableFacade cafeTableFacade;

    public UniqueTableNumberValidator(CafeTableFacade cafeTableFacade) {
        this.cafeTableFacade = cafeTableFacade;
    }

    @Override
    public boolean isValid(Integer tableNumber, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(tableNumber)) {
            return false;
        }
        try {
            cafeTableFacade.getByTableNumber(tableNumber);
            return false;
        } catch (final TableNotExistsForTableNumberException ex) {
            return true;
        }
    }
}
