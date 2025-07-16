package com.geeksusma.tdd_employee_example.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class IdTest {

  @Test
  void should_appendFixedId_when_random() {

    // when
    final Id random = Id.random();

    // then
    idHasNotBlankValue(random);
  }

  @Test
  void should_applyDifferentValues_when_idIsRandom() {

    // when
    final Id anId = Id.random();
    final Id anotherId = Id.random();

    // then
    idHasNotBlankValue(anId);
    idHasNotBlankValue(anotherId);
    idsAreDifferent(anId, anotherId);
  }

  private void idsAreDifferent(Id anId, Id anotherId) {
    assertThat(anId.value()).isNotEqualTo(anotherId.value());
  }

  private static void idHasNotBlankValue(Id random) {
    assertThat(random).isNotNull();
    assertThat(random).hasNoNullFieldsOrProperties();
    assertThat(random).extracting("value").isNotEqualTo("");
  }
}
