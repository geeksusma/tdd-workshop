package com.geeksusma.tdd_employee_example.domain.model;

import static com.geeksusma.tdd_employee_example.data.RamonesMotherObject.JOEY;
import static com.geeksusma.tdd_employee_example.data.RamonesMotherObject.RAMONE;
import static com.geeksusma.tdd_employee_example.matchers.RamonesMatcher.isJoeyRamone;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.UUID;

import com.geeksusma.tdd_employee_example.data.RamonesMotherObject;
import com.geeksusma.tdd_employee_example.domain.errors.LastNameIsRequired;
import com.geeksusma.tdd_employee_example.domain.errors.NameIsRequired;
import com.geeksusma.tdd_employee_example.domain.errors.PassportIsRequired;

import org.junit.jupiter.api.Test;

class PersonalDataTest {

  @Test
  void should_failAsNameIsRequired_when_emptyName() {

    assertThat(catchThrowable(() -> PersonalData.with(null, null, null)))
        .isInstanceOf(NameIsRequired.class)
        .hasMessage("Name can't be empty or null");
    assertThat(catchThrowable(() -> PersonalData.with("", null, null)))
        .isInstanceOf(NameIsRequired.class)
        .hasMessage("Name can't be empty or null");
  }

  @Test
  void should_failAsLastNameIsRequired_when_emptyLastName() {
    assertThat(catchThrowable(() -> PersonalData.with("John", null, null)))
        .isInstanceOf(LastNameIsRequired.class)
        .hasMessage("Last Name can't be empty or null");
    assertThat(catchThrowable(() -> PersonalData.with(JOEY, "",null)))
        .isInstanceOf(LastNameIsRequired.class)
        .hasMessage("Last Name can't be empty or null");
  }

  @Test
  void should_failAsPassportRequired_when_emptyPassport() {
    assertThat(catchThrowable(() -> PersonalData.with("John", RAMONE, null)))
            .isInstanceOf(PassportIsRequired.class)
            .hasMessage("Passport can't be empty or null");
    assertThat(catchThrowable(() -> PersonalData.with(JOEY, RAMONE, "")))
            .isInstanceOf(PassportIsRequired.class)
            .hasMessage("Passport can't be empty or null");
  }

  @Test
  void should_createPersonalData_when_hasNameAndLastName() {

    // when
    final PersonalData rightData = PersonalData.with(JOEY, RAMONE, UUID.randomUUID().toString());

    // then
    isJoeyRamone(rightData);
  }
}
