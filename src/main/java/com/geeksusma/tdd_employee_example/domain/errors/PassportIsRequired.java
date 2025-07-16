package com.geeksusma.tdd_employee_example.domain.errors;

public class PassportIsRequired extends RuntimeException {

  public PassportIsRequired(String message) {
    super(message);
  }
}
