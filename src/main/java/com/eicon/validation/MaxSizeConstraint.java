package com.eicon.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = MaxSizeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxSizeConstraint {

	String message() default "A lista informada contem mais que 10 produtos.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
