package com.cafe.manager.api.validation;

import org.springframework.context.annotation.Bean;

import java.lang.annotation.*;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 3:57 PM
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Bean
public @interface Facade {
}
