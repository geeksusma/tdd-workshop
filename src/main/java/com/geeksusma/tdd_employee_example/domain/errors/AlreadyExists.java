package com.geeksusma.tdd_employee_example.domain.errors;

public class AlreadyExists extends RuntimeException {

  public AlreadyExists(String message) {
    super(message);
  }
}
