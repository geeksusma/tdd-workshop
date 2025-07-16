package com.geeksusma.tdd_employee_example.domain.model;

import java.util.Objects;

public class Passport {

  private String value;

  private Passport(String value) {
    this.value = value;
  }

  public static Passport with(String value) {
    return new Passport(value);
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
