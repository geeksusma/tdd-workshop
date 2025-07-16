package com.geeksusma.tdd_employee_example.domain.errors;

public class LastNameIsRequired extends RuntimeException {

    public LastNameIsRequired(String message) {
        super(message);
    }
}
