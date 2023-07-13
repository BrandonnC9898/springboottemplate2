package com.brandonn.springboottemplate2.shared.validator;

import com.brandonn.springboottemplate2.shared.annotation.ValidDateFormat;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidDateFormatValidator implements ConstraintValidator<ValidDateFormat, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isValidDate(value, "d/M/u") ||
                isValidDate(value, "dd/MM/uuuu") ||
                isValidDate(value, "dd/MM/uuuu") ||
                isValidDate(value, "dd/MM/yyyy") ||
                isValidDate(value, "d-M-u") ||
                isValidDate(value, "dd-MM-uuuu") ||
                isValidDate(value, "dd-MM-uuuu") ||
                isValidDate(value, "dd-MM-yyyy");
    }

    // Private methods
    private boolean isValidDate(String value, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            LocalDate.parse(value, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
