package com.geeksusma.tdd_employee_example.employee;

public class LastNameIsMandatory extends RuntimeException {

  public LastNameIsMandatory(String message) {
    super(message);
  }
}
