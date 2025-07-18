package com.geeksusma.tdd_employee_example.persistence;

public interface EmployeeRepository {
    boolean isPassportFree(String passport);

    void save(String id, String passport, String name, String lastName);
}
