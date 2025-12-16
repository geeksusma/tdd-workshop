package com.geeksusma.tdd_employee_example.domain.employee;

final class CreateEmployeeCommand {

    private final String name;
    private final String lastName;
    private final String passport;

    CreateEmployeeCommand(String name, String lastName, String passport) {
        this.name = name;
        this.lastName = lastName;
        this.passport = passport;
    }

    String name() {
        return name;
    }

    String lastName() {
        return lastName;
    }

    String passport() {
        return passport;
    }
}

