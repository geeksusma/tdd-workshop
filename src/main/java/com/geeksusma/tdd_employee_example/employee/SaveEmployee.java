package com.geeksusma.tdd_employee_example.employee;

public class SaveEmployee {

  private final EmployeeRepository employeeRepository;

  public SaveEmployee(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public void save(Passport passport, FullName fullName) {

    if (employeeRepository.passportExist(passport.value())) {

      throw new EmployeeExists("The passport is in use");
    }

    employeeRepository.save(Id.random(), PersonalData.with(passport.value(), fullName.first(), fullName.last()));
  }
}
