package com.geeksusma.tdd_employee_example.domain.employee;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class EmployeeIdGenerator {

    private EmployeeId lastGenerated;

    EmployeeId generate() {
        lastGenerated = new EmployeeId(UUID.randomUUID());
        return lastGenerated;
    }

    EmployeeId lastGenerated() {
        return lastGenerated;
    }
}

