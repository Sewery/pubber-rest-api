package com.sartyro.pubberrestapi.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class IdentityIdArrayValidator implements ConstraintValidator<IdentityIdArray, List<Long>> {

    @Override
    public void initialize(IdentityIdArray constraintAnnotation) {

    }
    @Override
    public boolean isValid(List<Long> value, ConstraintValidatorContext context) {
        return value==null ||( value.stream().noneMatch(n -> n < 0) && !value.isEmpty());
    }
}