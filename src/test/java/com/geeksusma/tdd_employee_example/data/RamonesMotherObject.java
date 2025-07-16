package com.geeksusma.tdd_employee_example.data;

import com.geeksusma.tdd_employee_example.domain.model.PersonalData;

public class RamonesMotherObject {
    public static final String JOEY = "Joey";
    public static final String JOEY_PASSPORT = "joey-passport";
    public static final String RAMONE = "Ramone";

    public static PersonalData joey() {
        return PersonalData.with(JOEY, RAMONE, JOEY_PASSPORT);
    }
}
