package com.geeksusma.tdd_employee_example.employee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class IdTest {

  @Test
  void should_assignFixedValue_when_random() {

    // when
    Id random = Id.random();

    // then
    assertThat(random).hasNoNullFieldsOrProperties();
  }

  @Test
  void should_ensureNotColissions_when_randomIdsAreGenerated() {

    // when
    Id anId = Id.random();
    Id anotherId = Id.random();

    // then
    assertThat(anId.value()).isNotEqualTo(anotherId.value());
  }
}
