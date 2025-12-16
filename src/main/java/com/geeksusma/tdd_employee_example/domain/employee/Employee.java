package com.geeksusma.tdd_employee_example.domain.employee;

final class Employee {

    private final EmployeeId id;
    private final EmployeeProfile profile;

    Employee(EmployeeId id, EmployeeProfile profile) {
        this.id = id;
        this.profile = profile;
    }

    Passport passport() {
        return profile.passport();
    }
}

