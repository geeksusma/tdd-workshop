package com.geeksusma.tdd_employee_example.employee;

public interface EmployeeRepository {

    boolean passportExist(String passport);

    void save(Id id, PersonalData with);
}
