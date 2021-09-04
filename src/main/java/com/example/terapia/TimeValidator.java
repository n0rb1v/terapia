package com.example.terapia;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class TimeValidator implements ConstraintValidator<IsValidTime, LocalDateTime> {
    @Override
    public boolean isValid(LocalDateTime time, ConstraintValidatorContext constraintValidatorContext) {
        return time != null &&
                time.isAfter(LocalDateTime.now());
    }
}
