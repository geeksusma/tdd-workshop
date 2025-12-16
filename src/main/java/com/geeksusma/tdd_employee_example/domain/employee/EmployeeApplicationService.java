package com.geeksusma.tdd_employee_example.domain.employee;

import org.springframework.stereotype.Service;

@Service
class EmployeeApplicationService {

    private final EmployeeRepository repository;

    EmployeeApplicationService(EmployeeRepository repository) {
        this.repository = repository;
    }

    EmployeeId createEmployee(CreateEmployeeCommand command) {
        Passport passport = new Passport(command.passport());

        if (repository.existsByPassport(passport)) {
            throw new IllegalStateException("Employee already exists");
        }

        EmployeeId employeeId = EmployeeId.generate();
        Employee employee =
                new Employee(
                        employeeId,
                        new EmployeeProfile(
                                new PersonalData(command.name(), command.lastName()),
                                passport
                        )
                );


        repository.save(employee);

        return employeeId;
    }
}

