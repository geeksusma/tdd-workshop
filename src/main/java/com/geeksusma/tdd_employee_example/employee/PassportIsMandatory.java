package com.geeksusma.tdd_employee_example.employee;

public class PassportIsMandatory extends RuntimeException {

  public PassportIsMandatory(String message) {
    super(message);
  }
}
