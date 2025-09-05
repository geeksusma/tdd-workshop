package com.geeksusma.tdd_employee_example.employee;

import java.util.Objects;
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
      return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Id id = (Id) o;
    return Objects.equals(value, id.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
}
