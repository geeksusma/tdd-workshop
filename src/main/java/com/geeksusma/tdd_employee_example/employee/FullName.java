package com.geeksusma.tdd_employee_example.employee;

import java.util.Objects;

public class FullName {
  private final String name;
  private final String lastName;

  private FullName(String name, String lastName) {
    this.name = name;
    this.lastName = lastName;
  }

  public static FullName with(String name, String lastName) {

    if (name == null || name.isBlank()) {
      throw new NameIsMandatory("Name can't be empty");
    }

    if (lastName == null || lastName.isBlank()) {
      throw new LastNameIsMandatory("Last Name can't be empty");
    }

    return new FullName(name, lastName);
  }

  public String first() {
    return name;
  }


  public String last() {
    return lastName;
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
