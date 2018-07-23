package com.cafe.manager.api.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 6:11 PM
 */

@Documented
@Constraint(validatedBy = UniqueTableNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueTableNumber {

    String message() default "Table number already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
