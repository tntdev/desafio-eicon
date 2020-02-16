package com.eicon.validation.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = MinSizeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, METHOD, PARAMETER})
@Documented
public @interface MinSizeConstraint {

	String message() default "A lista informada deve contem ao menos 1 produto.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
