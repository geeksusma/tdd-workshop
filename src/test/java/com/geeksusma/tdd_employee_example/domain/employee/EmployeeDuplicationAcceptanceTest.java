package com.geeksusma.tdd_employee_example.domain.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class EmployeeDuplicationAcceptanceTest {

    @Autowired
    private EmployeeApplicationService service;

    @Test
    void should_reject_employee_when_passport_already_exists() {
        CreateEmployeeCommand command =
                new CreateEmployeeCommand("John", "Doe", "DUP-001");

        service.createEmployee(command);

        assertThatThrownBy(() -> service.createEmployee(command))
                .isInstanceOf(IllegalStateException.class);
    }
}
