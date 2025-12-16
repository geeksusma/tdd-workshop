package com.geeksusma.tdd_employee_example.domain.employee;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
class InMemoryEmployeeRepository implements EmployeeRepository {

    private final Map<Passport, Employee> storage = new HashMap<>();

    @Override
    public void save(Employee employee) {
        storage.put(employee.passport(), employee);
    }

    @Override
    public boolean existsByPassport(Passport passport) {
        return storage.containsKey(passport);
    }
}

