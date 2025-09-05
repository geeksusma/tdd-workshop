package com.geeksusma.tdd_employee_example.employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;

import org.junit.jupiter.api.Test;

class FullNameTest {

  @Test
  void should_throwNameIsMandatory_when_creatingWithEmptyName() {

    assertThat(catchException(() -> FullName.with(null, "Ramone")))
        .isInstanceOf(NameIsMandatory.class)
        .hasMessage("Name can't be empty");

    assertThat(catchException(() -> FullName.with("", "Ramone")))
        .isInstanceOf(NameIsMandatory.class)
        .hasMessage("Name can't be empty");
  }

  @Test
  void should_throwLastNameIsMandatory_when_creatingWithEmptyLastName() {

    assertThat(catchException(() -> FullName.with("Joey", null)))
        .isInstanceOf(LastNameIsMandatory.class)
        .hasMessage("Last Name can't be empty");

    assertThat(catchException(() -> FullName.with("Joey", "")))
        .isInstanceOf(LastNameIsMandatory.class)
        .hasMessage("Last Name can't be empty");
  }

  @Test
  void should_createFullNane_when_hasNameAndLastName() {
    String name = "Joey";
    String lastName = "Ramone";

    FullName fullName = FullName.with(name, lastName);

    assertThat(fullName)
        .hasFieldOrPropertyWithValue("name", name)
        .hasFieldOrPropertyWithValue("lastName", lastName);
  }
}
