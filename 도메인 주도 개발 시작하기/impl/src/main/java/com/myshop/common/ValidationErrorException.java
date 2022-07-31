package com.myshop.common;

import java.util.List;

public class ValidationErrorException extends RuntimeException {
    private final List<ValidationError> errors;

    public ValidationErrorException(List<ValidationError> errors) {
        this.errors = errors;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }
}
