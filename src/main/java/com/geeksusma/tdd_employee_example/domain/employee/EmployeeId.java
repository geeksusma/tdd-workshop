package com.geeksusma.tdd_employee_example.domain.employee;

import java.util.UUID;

final class EmployeeId {

    private final UUID value;

    EmployeeId(UUID value) {
        this.value = value;
    }
}

