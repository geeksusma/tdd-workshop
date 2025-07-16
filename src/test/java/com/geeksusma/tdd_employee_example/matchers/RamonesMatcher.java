package com.geeksusma.tdd_employee_example.matchers;

import static org.assertj.core.api.Assertions.assertThat;

import com.geeksusma.tdd_employee_example.domain.model.PersonalData;

public class RamonesMatcher {

    public static void isJoeyRamone(PersonalData data) {
        assertThat(data).isNotNull();
        assertThat(data).hasFieldOrPropertyWithValue("name.name", "Joey");
        assertThat(data).hasFieldOrPropertyWithValue("name.lastName", "Ramone");
        assertThat(data).extracting("passport").isNotNull();
    }
}
