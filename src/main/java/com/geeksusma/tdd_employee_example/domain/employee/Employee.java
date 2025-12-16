package com.geeksusma.tdd_employee_example.domain.employee;

final class Employee {

    private final EmployeeId id;
    private final PersonalData personalData;
    private final Passport passport;

    Employee(EmployeeId id, PersonalData personalData, Passport passport) {
        this.id = id;
        this.personalData = personalData;
        this.passport = passport;
    }

    Passport passport() {
        return passport;
    }
}

