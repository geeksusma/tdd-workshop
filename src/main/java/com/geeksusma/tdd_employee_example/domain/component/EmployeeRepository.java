package com.geeksusma.tdd_employee_example.domain.component;

import com.geeksusma.tdd_employee_example.domain.model.Id;
import com.geeksusma.tdd_employee_example.domain.model.PersonalData;

public interface EmployeeRepository {
  void save(Id id, PersonalData data);

  boolean passportExists(String passport);
}
