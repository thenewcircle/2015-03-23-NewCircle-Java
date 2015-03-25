package com.example.bootcamp.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Employee {

  public static int BASE_VACATION_DAYS = 10;
  
  private final String ssn;
  private String name = "unknown";
  private String emailAddress = "unknown";
  private final int yearOfBirth;
  private int extraVacationDays;
  private List<Integer> agesOfChildren;

//  public Employee() {
//    // These two values must be set because
//    // they are declared as final attributes;
//    this.yearOfBirth = 0;
//    this.ssn = null;
//  }
  
  public Employee(String ssn, String name) {
    
    // Cannot execute code before the "sibling" constructor is called
    
    // this is a vialble option, but gets unreadable if too long
    // this(ssn, (name != null ? name : "Default Name"), null, 0, 0, Collections.emptyList());

    this(validate(ssn), validate(name), null, 0, 0, Collections.emptyList());

    // This validates the value, but AFTER the other constructor did some work
    name = (name != null ? name : "Default Name");
    
    // OK to update after the constructor, but again, possibly overwriding with the other constructor did.
    name = "Moo";
  }
  
  public Employee(String ssn, String name, String emailAddress, 
      int yearOfBirth, int extraVacationDays, 
      List<Integer> agesOfChildren) {

      this.ssn = ssn;
      this.name = name;
      this.emailAddress = emailAddress;
      this.extraVacationDays = extraVacationDays;
      this.agesOfChildren = agesOfChildren;
      this.yearOfBirth = yearOfBirth;
  }

  private static String validate(String value) {
    if (value == null) {
      throw new IllegalArgumentException("The value must be specified.");
    } else {
      return value;
    }
  }

  final void print() {
    print(null);
  }
  
  final void print(String header) {
    print(header, null);
  }
  
  void print(final String header, String footer) {

    if (header != null) {
      System.out.println(header);
    }
    System.out.println("Name: " + getName());
    System.out.println("SSN: " + getSsn());
    System.out.println("Email Address: " + getEmailAddress());
    System.out.println("Year Of Birth: " + getYearOfBirth());
    System.out.println("Base Vacation days: " + getBaseVacationDays());
    System.out.println("Extra Vacation days: " + getExtraVacationDays());
    System.out.println("Total Vacation days: " + getVactionDays());
    System.out.println("Childen: " + getAgesOfChildren());
    if (footer != null) {
      System.out.println(footer);
    }
  }

  public List<Integer> getAgesOfChildren() {
    return agesOfChildren;
  }

  public void setAgesOfChildren(Integer...agesOfChildren) {
    this.agesOfChildren = Arrays.asList(agesOfChildren);
  }

  public void setAgesOfChildren(Collection<Integer> agesOfChildren) {
    this.agesOfChildren = new ArrayList<>(agesOfChildren);
  }

  public static int getBaseVacationDays() {
    return BASE_VACATION_DAYS;
  }

  public String getName() {
    return name;
  }

  public String getSsn() {
    return ssn;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public int getYearOfBirth() {
    return yearOfBirth;
  }

  public int getExtraVacationDays() {
    return extraVacationDays;
  }

  public void setExtraVacationDays(int extraVacationDays) {
    this.extraVacationDays = extraVacationDays;
  }

  public int getVactionDays() {
    return BASE_VACATION_DAYS + extraVacationDays;
  }

  public static Employee createEmployeeWithEmail(String ssn, String emailAddress, int yearOfBirth, Integer...ageOfChildren) {
    return new Employee(ssn, null, emailAddress, yearOfBirth, 0, Arrays.asList(ageOfChildren));
  }

  public static Employee createEmployeeWithName(String ssn, String name, int yearOfBirth, Integer...ageOfChildren) {
    return new Employee(ssn, ssn, null, yearOfBirth, 0, Arrays.asList(ageOfChildren));
  }
}


