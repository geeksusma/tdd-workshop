package com.geeksusma.tdd_employee_example.domain.employee;

final class Passport {

    private final String value;

    Passport(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Passport is mandatory");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Passport)) return false;
        return value.equals(((Passport) other).value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

