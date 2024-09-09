package com.sartyro.pubberrestapi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target( FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = {IdentityIdArrayValidator.class})
public @interface IdentityIdArray {

    String message() default "Identity array can not be empty and must contain positive ID numbers.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

