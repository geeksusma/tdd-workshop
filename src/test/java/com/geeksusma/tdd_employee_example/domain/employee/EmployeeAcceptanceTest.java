package com.geeksusma.tdd_employee_example.domain.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EmployeeAcceptanceTest {

    @Autowired
    private EmployeeApplicationService service;

    @Test
    void should_save_employee_when_valid_and_not_duplicated() {
        CreateEmployeeCommand command =
                new CreateEmployeeCommand(
                        "John",
                        "Doe",
                        "P123456"
                );

        EmployeeId employeeId = service.createEmployee(command);

        assertThat(employeeId).isNotNull();
    }
}
