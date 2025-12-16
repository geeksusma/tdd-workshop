package com.geeksusma.tdd_employee_example.domain.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EmployeeCreationTest {

    private InMemoryEmployeeRepository repository;
    private EmployeeApplicationService service;

    @BeforeEach
    void setup() {
        repository = new InMemoryEmployeeRepository();
        service = new EmployeeApplicationService(
                repository,
                new EmployeeIdGenerator()
        );
    }

    @Test
    void should_create_employee_when_personal_data_is_valid_and_not_duplicated() {
        CreateEmployeeCommand command =
                new CreateEmployeeCommand("Jane", "Doe", "X999999");

        EmployeeId id = service.createEmployee(command);

        assertThat(repository.existsByPassport(new Passport("X999999"))).isTrue();
        assertThat(id).isNotNull();
    }

    @Test
    void should_fail_when_personal_data_is_missing() {
        CreateEmployeeCommand command =
                new CreateEmployeeCommand("", "Doe", "X888888");

        assertThatThrownBy(() -> service.createEmployee(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void should_fail_when_employee_is_duplicated_by_passport() {
        CreateEmployeeCommand command =
                new CreateEmployeeCommand("John", "Smith", "DUP123");

        service.createEmployee(command);

        assertThatThrownBy(() -> service.createEmployee(command))
                .isInstanceOf(IllegalStateException.class);
    }
}

