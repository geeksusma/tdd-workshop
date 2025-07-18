package com.geeksusma.tdd_employee_example.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import com.geeksusma.tdd_employee_example.exception.IllegalLastNameException;
import com.geeksusma.tdd_employee_example.exception.IllegalNameException;
import com.geeksusma.tdd_employee_example.exception.IllegalPassportException;
import com.geeksusma.tdd_employee_example.exception.PassportIsDuplicatedException;
import com.geeksusma.tdd_employee_example.persistence.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

  private EmployeeService employeeService;
  @Mock private EmployeeRepository employeeRepository;

  @BeforeEach
  void setUp() {
    employeeService = new EmployeeService(employeeRepository);
  }

  @Test
  void should_throw_when_nullPassport() {

    assertThat(catchThrowable(() -> employeeService.save(null, null, null)))
        .isInstanceOf(IllegalPassportException.class);
  }

  @Test
  void should_throw_when_emptyPassport() {

    assertThat(catchThrowable(() -> employeeService.save("", null, null)))
        .isInstanceOf(IllegalPassportException.class);
  }

  @Test
  void should_throw_when_nullName() {

    assertThat(catchThrowable(() -> employeeService.save("test", null, null)))
        .isInstanceOf(IllegalNameException.class);
  }

  @Test
  void should_throw_when_emptyName() {

    assertThat(catchThrowable(() -> employeeService.save("test", "", null)))
        .isInstanceOf(IllegalNameException.class);
  }

  @Test
  void should_throw_when_nullLastName() {

    assertThat(catchThrowable(() -> employeeService.save("test", "test", null)))
        .isInstanceOf(IllegalLastNameException.class);
  }

  @Test
  void should_throw_when_emptyLastName() {

    assertThat(catchThrowable(() -> employeeService.save("test", "test", "")))
        .isInstanceOf(IllegalLastNameException.class);
  }

  @Test
  void should_throw_when_passportIsDuplicated() {
    String passport = "passport";
    given(employeeRepository.isPassportFree(passport)).willReturn(false);

    assertThat(catchThrowable(() -> employeeService.save(passport, "name", "lastname")))
        .isInstanceOf(PassportIsDuplicatedException.class);
  }

  // TODO even this test looks fine, it is fragile, since there is no way to test if the id
  // generated ramdonly
  @Test
  void should_saveWithRamdonId_when_free() {
    String passport = "passport";
    given(employeeRepository.isPassportFree(passport)).willReturn(true);

    employeeService.save(passport, "name", "lastname");

    then(employeeRepository).should().save(anyString(), eq(passport), eq("name"), eq("lastname"));
  }
}
