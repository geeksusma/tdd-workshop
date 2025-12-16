package com.geeksusma.tdd_employee_example.domain.employee;

final class EmployeeProfile {

    private final PersonalData personalData;
    private final Passport passport;

    EmployeeProfile(PersonalData personalData, Passport passport) {
        this.personalData = personalData;
        this.passport = passport;
    }

    Passport passport() {
        return passport;
    }
}

