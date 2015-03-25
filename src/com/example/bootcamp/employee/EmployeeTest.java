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

    Manager m1 = new Manager("Bob", "345-11-987", "Development");
    m1.setResponsibility("I do whatever I want");
    m1.setExtraVacationDays(20);
    m1.print("BIG BOSS", "=======");

    Employee e3 = m1;
    e3.print("UNKNOWN Employee", "======");

    System.out.println("e2: " + e1.getClass().getName());
    
    Manager m2 = (Manager)e3;
    System.out.println("m2: " + m2.getClass().getName());
    
    Object o1 = m1;
    System.out.println("o1: " + o1.getClass().getName());
    
    // Manager m4 = (Integer)o1;
    // Integer i = (Integer)o1;
    // System.out.println(i);
    
    if (e1 instanceof Manager) {
      Manager m3 = (Manager)e1;
      System.out.println("Wow, e1 realy was a maanger");
      System.out.println("e1: " + e1.getClass().getName());
    
    } else {
      System.out.println("I guess e1 wasn't a manager");
      System.out.println("e1: " + e1.getClass().getName());
    }
    
  }
}
