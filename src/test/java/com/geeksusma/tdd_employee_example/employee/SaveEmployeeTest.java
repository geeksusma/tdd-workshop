package com.geeksusma.tdd_employee_example.employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

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
  void should_throwEmployeeAlreadyExist_when_passportIsInUse() {
    given(employeeRepository.passportExist("test")).willReturn(true);

    Throwable error = catchThrowable(() -> saveEmployee.save(Passport.with("test"), null));

    assertThat(error).isInstanceOf(EmployeeExists.class).hasMessage("The passport is in use");
    then(employeeRepository).should().passportExist("test");
  }

  @Test
  void should_saveEmployee_when_passportIsFree() {
    given(employeeRepository.passportExist("test")).willReturn(false);

    saveEmployee.save(Passport.with("test"), FullName.with("Joey", "Ramone"));

    then(employeeRepository)
        .should()
        .save(any(Id.class), eq(PersonalData.with("test", "Joey", "Ramone")));
  }
}
