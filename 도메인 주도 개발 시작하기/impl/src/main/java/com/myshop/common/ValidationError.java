package com.myshop.common;

public class ValidationError {
    private final String name;
    private final String code;

    public ValidationError(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public static ValidationError of(String code) {
        return new ValidationError(null, code);
    }

    public static ValidationError of(String name, String code) {
        return new ValidationError(name, code);
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean hasName() {
        return name != null;
    }
}
