package com.geeksusma.tdd_employee_example.domain.errors;

public class NameIsRequired extends RuntimeException {
  public NameIsRequired(String message) {
    super(message);
  }
}
