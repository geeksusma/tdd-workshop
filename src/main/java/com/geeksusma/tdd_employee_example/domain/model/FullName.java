package com.geeksusma.tdd_employee_example.domain.model;


import java.util.Objects;

public class FullName {

  private String name;
  private String lastName;

  private FullName(String name, String lastName) {
    this.name = name;
    this.lastName = lastName;
  }

  public static FullName with(String name, String lastName) {
    return new FullName(name, lastName);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    FullName fullName = (FullName) o;
    return Objects.equals(name, fullName.name) && Objects.equals(lastName, fullName.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lastName);
  }
}
