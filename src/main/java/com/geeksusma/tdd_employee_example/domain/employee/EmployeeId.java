package com.geeksusma.tdd_employee_example.domain.employee;

import java.util.UUID;

final class EmployeeId {

    private final UUID value;

    private EmployeeId(UUID value) {
        this.value = value;
    }

    static EmployeeId generate() {
        return new EmployeeId(UUID.randomUUID());
    }
}


