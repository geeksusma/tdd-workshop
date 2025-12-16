package com.geeksusma.tdd_employee_example.domain.employee;

interface EmployeeRepository {

    void save(Employee employee);

    boolean existsByPassport(Passport passport);
}
