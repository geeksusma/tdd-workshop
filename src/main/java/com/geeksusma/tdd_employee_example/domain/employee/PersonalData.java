package com.geeksusma.tdd_employee_example.domain.employee;

final class PersonalData {

    private final String name;
    private final String lastName;

    PersonalData(String name, String lastName) {
        if (isBlank(name) || isBlank(lastName)) {
            throw new IllegalArgumentException("Personal data is mandatory");
        }
        this.name = name;
        this.lastName = lastName;
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}

