package com.geeksusma.tdd_employee_example.employee;

import java.util.Objects;

public class Passport {
  private final String value;

  private Passport(String value) {
    this.value = value;
  }

  public static Passport with(String passport) {

    if (passport == null || passport.isBlank()) {
      throw new PassportIsMandatory("Passport can't be empty");
    }

    return new Passport(passport);
  }

  String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Passport passport = (Passport) o;
    return Objects.equals(value, passport.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
}
