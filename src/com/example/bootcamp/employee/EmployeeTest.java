package com.example.bootcamp.employee;

import org.junit.Test;

public class EmployeeTest {

  @Test
  public void testEmployee() {
    Employee e1 = new Employee();
    e1.name = "John";
    e1.ssn = "555-12-345";
    e1.emailAddress = "john@company.com";

    Employee e2 = new Employee();
    e2.name = "Tom";
    e2.ssn = "456-78-901";
    e2.yearOfBirth = 1974;

    e1.print();
    e2.print();
    
    System.out.println();

    // wrong way
    e1.vacationDays = 99;
    // right way
    Employee.vacationDays = 99;
    
    e1.name = "Moo";
    // Employee.name = "moo";
    
    e1.print();
    e2.print();
    
    
    e1.setEmailAddress("asdf");

    // Do not reference this way.
    e1.setVacationDays(123);
    // Do it this way.
    Employee.setVacationDays(123);
  }
}
