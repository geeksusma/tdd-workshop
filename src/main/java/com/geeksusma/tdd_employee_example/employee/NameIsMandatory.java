package com.geeksusma.tdd_employee_example.employee;

public class NameIsMandatory extends RuntimeException {

    public NameIsMandatory(String message) {
        super(message);
    }
}
