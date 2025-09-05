package com.geeksusma.tdd_employee_example.employee;

import java.util.Objects;

public class PersonalData {

  private final Passport passport;

  private final FullName fullName;

  private PersonalData(Passport passport, FullName fullName) {
    this.passport = passport;
    this.fullName = fullName;
  }

  public Passport getPassport() {
    return passport;
  }

  public FullName getFullName() {
    return fullName;
  }

 static PersonalData with(String passport, String name, String lastName) {
    return new PersonalData(Passport.with(passport), FullName.with(name, lastName));
  }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonalData that = (PersonalData) o;
        return Objects.equals(passport, that.passport) && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport, fullName);
    }
}
