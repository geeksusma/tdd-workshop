package com.geeksusma.tdd_employee_example.employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;

import org.junit.jupiter.api.Test;

class PassportTest {

  @Test
  void should_throwPassportIsMandatory_when_blank() {

    assertThat(catchException(() -> Passport.with(null)))
        .isInstanceOf(PassportIsMandatory.class)
        .hasMessage("Passport can't be empty");

    assertThat(catchException(() -> Passport.with("")))
        .isInstanceOf(PassportIsMandatory.class)
        .hasMessage("Passport can't be empty");
  }


  @Test
  void should_createPassport_when_haValue() {
    String passport = "kdlsjlkdasjlf";

    Passport fullName = Passport.with(passport);

    assertThat(fullName)
        .hasFieldOrPropertyWithValue("value", passport);
  }
}
