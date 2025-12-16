package com.geeksusma.tdd_employee_example.domain.employee;

import org.springframework.stereotype.Service;

@Service
class EmployeeApplicationService {

    private final EmployeeRepository repository;
    private final EmployeeIdGenerator idGenerator;

    EmployeeApplicationService(EmployeeRepository repository,
                               EmployeeIdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    EmployeeId createEmployee(CreateEmployeeCommand command) {
        Passport passport = new Passport(command.passport());

        if (repository.existsByPassport(passport)) {
            throw new IllegalStateException("Employee already exists");
        }

        Employee employee =
                new Employee(
                        idGenerator.generate(),
                        new PersonalData(command.name(), command.lastName()),
                        passport
                );

        repository.save(employee);

        return employeeId(employee);
    }

    private EmployeeId employeeId(Employee employee) {
        return idGenerator.lastGenerated();
    }
}

