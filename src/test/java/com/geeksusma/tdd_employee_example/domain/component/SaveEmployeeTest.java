package com.geeksusma.tdd_employee_example.domain.component;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import com.geeksusma.tdd_employee_example.data.RamonesMotherObject;
import com.geeksusma.tdd_employee_example.domain.errors.AlreadyExists;
import com.geeksusma.tdd_employee_example.domain.model.Id;
import com.geeksusma.tdd_employee_example.domain.model.PersonalData;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SaveEmployeeTest {

  private SaveEmployee saveEmployee;
  @Mock private EmployeeRepository employeeRepository;

  @BeforeEach
  void setUp() {
    saveEmployee = new SaveEmployee(employeeRepository);
  }

  @Test
  void should_fail_when_employeeAlreadyExists() {
    // given
    String passport = anExistingPassport();

    // when
    Throwable error =
        catchThrowable(
            () ->
                saveEmployee.newEmployee(
                    passport, RamonesMotherObject.JOEY, RamonesMotherObject.RAMONE));
    // then
    employeeAlreadyExists(error);
  }

  @Test
  void should_saveWithId_when_passportIsFree() {
    // given
    PersonalData data = aFreePassportForJoey();

    // when
    saveEmployee.newEmployee(
        RamonesMotherObject.JOEY_PASSPORT, RamonesMotherObject.JOEY, RamonesMotherObject.RAMONE);
    // then
    checkDataIsSaved(data);
  }

  private void checkDataIsSaved(PersonalData data) {
    then(employeeRepository).should().save(any(Id.class), eq(data));
  }

  private PersonalData aFreePassportForJoey() {
    PersonalData data = RamonesMotherObject.joey();
    given(employeeRepository.passportExists(RamonesMotherObject.JOEY_PASSPORT)).willReturn(false);
    return data;
  }

  private static void employeeAlreadyExists(Throwable error) {
    assertThat(error).isInstanceOf(AlreadyExists.class).hasMessage("The employee is already saved");
  }

  private String anExistingPassport() {
    String passport = UUID.randomUUID().toString();
    given(employeeRepository.passportExists(passport)).willReturn(true);
    return passport;
  }
}
