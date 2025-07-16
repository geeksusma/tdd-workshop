package com.geeksusma.tdd_employee_example.domain.model;

import java.util.UUID;

public class Id {
  private final String value;

  private Id(String value) {
    this.value = value;
  }

  public static Id random() {
    return new Id(UUID.randomUUID().toString());
  }

  public String value() {
    return this.value;
  }
}
