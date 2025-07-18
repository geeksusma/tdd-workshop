package com.geeksusma.tdd_employee_example.service;

import com.geeksusma.tdd_employee_example.exception.IllegalLastNameException;
import com.geeksusma.tdd_employee_example.exception.IllegalNameException;
import com.geeksusma.tdd_employee_example.exception.IllegalPassportException;
import com.geeksusma.tdd_employee_example.exception.PassportIsDuplicatedException;
import com.geeksusma.tdd_employee_example.persistence.EmployeeRepository;
import java.util.UUID;

public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository employeeRepository) {

      this.employeeRepository = employeeRepository;
  }

  public void save(String passport, String name, String lastName) {
    validatePassport(passport);
    validateName(name);
    validateLastName(lastName);

    checkIdPassportIsFree(passport);

    String id = generateId();

    save(id, passport, name, lastName);
  }

    private void save(String id, String passport, String name, String lastName) {
        employeeRepository.save(id, passport, name, lastName);
    }

    private String generateId() {

    return UUID.randomUUID().toString();
  }

  private void checkIdPassportIsFree(String passport) {
    if (!employeeRepository.isPassportFree(passport)) {
      throw new PassportIsDuplicatedException();
    }
  }

  private void validateLastName(String lastName) {
    if (lastName == null || lastName.isEmpty()) {
      throw new IllegalLastNameException();
    }
  }

  private void validateName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalNameException();
    }
  }

  private void validatePassport(String passport) {
    if (passport == null || passport.isEmpty()) {
      throw new IllegalPassportException();
    }
  }
}
