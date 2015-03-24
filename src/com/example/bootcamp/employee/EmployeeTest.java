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

    System.out.println("Name: " + e1.name);
    System.out.println("SSN: " + e1.ssn);
    System.out.println("Email Address: " + e1.emailAddress);
    System.out.println("Year Of Birth: " + e1.yearOfBirth);

    System.out.println("Name: " + e2.name);
    System.out.println("SSN: " + e2.ssn);
    System.out.println("Email Address: " + e2.emailAddress);
    System.out.println("Year Of Birth: " + e2.yearOfBirth);
  
  
    Employee e3 = e1;
    e3.name = "test";
    
    System.out.println("New Name: " + e1.name);
    System.out.println("New Name: " + e3.name);

    System.out.println("e1==e2: " + (e1 == e2) );
    System.out.println("e1==e3: " + (e1 == e3) );

  }

  public void changeSomething() {
    
  }

}
