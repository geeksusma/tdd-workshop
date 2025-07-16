package com.geeksusma.tdd_employee_example.domain.model;

import java.util.Objects;

import com.geeksusma.tdd_employee_example.domain.errors.LastNameIsRequired;
import com.geeksusma.tdd_employee_example.domain.errors.NameIsRequired;
import com.geeksusma.tdd_employee_example.domain.errors.PassportIsRequired;

public class PersonalData {
  private FullName name;
  private Passport passport;

  private PersonalData(String name, String lastName, String passport) {
    this.name = FullName.with(name, lastName);
    this.passport = Passport.with(passport);
  }

  public static PersonalData with(String name, String lastName, String passport) {
    if (isEmpty(name)) {
      throw new NameIsRequired("Name can't be empty or null");
    }
    if (isEmpty(lastName)) {
      throw new LastNameIsRequired("Last Name can't be empty or null");
    }
    if (isEmpty(passport)) {
      throw new PassportIsRequired("Passport can't be empty or null");
    }
    return new PersonalData(name, lastName, passport);
  }

  private static boolean isEmpty(String name) {
    return name == null || name.isEmpty();
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    PersonalData that = (PersonalData) o;
    return Objects.equals(name, that.name) && Objects.equals(passport, that.passport);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, passport);
  }
}
