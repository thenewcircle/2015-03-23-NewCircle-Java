package com.example.bootcamp.employee;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

public class EmployeeTest {

  @Test
  public void testEmployee() {
    Employee e1 = Employee.createEmployeeWithName("555-12-345", "John", 1995);
    Assert.assertEquals(1995, e1.getYearOfBirth());
    e1.setEmailAddress("john@company.com");
    e1.setAgesOfChildren(1,2,3,4,5);
    
    Employee e2 = Employee.createEmployeeWithEmail("456-78-901", "tom@example.com", 1974, 10, 14);
    Assert.assertEquals(1974, e2.getYearOfBirth());
    e2.setAgesOfChildren(23, 25, 29);

    // e2.name = "";
    // String value = e2.getName();
    
    e2.print("==Employee of the Month", "===============");
    System.out.println();

  }
}
