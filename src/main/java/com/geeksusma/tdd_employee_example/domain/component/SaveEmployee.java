package com.geeksusma.tdd_employee_example.domain.component;

import com.geeksusma.tdd_employee_example.domain.errors.AlreadyExists;
import com.geeksusma.tdd_employee_example.domain.model.Id;
import com.geeksusma.tdd_employee_example.domain.model.PersonalData;

public class SaveEmployee {

  private final EmployeeRepository employeeRepository;

  SaveEmployee(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public void newEmployee(String passport, String name, String lastName) {
    if (employeeRepository.passportExists(passport)) {
      throw new AlreadyExists("The employee is already saved");
    }
    employeeRepository.save(Id.random(), PersonalData.with(name, lastName, passport));
  }
}
