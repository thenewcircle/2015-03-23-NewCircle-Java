package com.example.bootcamp.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Employee {

  private static int baseVacationDays = 10;
  
  private String name;
  private String ssn;
  private String emailAddress;
  private int yearOfBirth;
  private int extraVacationDays;
  private List<Integer> agesOfChildren;
  
  void print() {
    print(null);
  }
  
  void print(String header) {
    print(header, null);
  }
  
  void print(String header, String footer) {
    if (header != null) {
      System.out.println(header);
    }
    System.out.println("Name: " + getName());
    System.out.println("SSN: " + getSsn());
    System.out.println("Email Address: " + getEmailAddress());
    System.out.println("Year Of Birth: " + getYearOfBirth());
    System.out.println("Base Vacation days: " + getBaseVacationDays());
    System.out.println("Extra Vacation days: " + getExtraVacationDays());
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
    return baseVacationDays;
  }

  public static void setBaseVacationDays(int baseVacationDays) {
    Employee.baseVacationDays = baseVacationDays;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
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

  public void setYearOfBirth(int yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
  }

  public int getExtraVacationDays() {
    return extraVacationDays;
  }

  public void setExtraVacationDays(int extraVacationDays) {
    this.extraVacationDays = extraVacationDays;
  }

  public int getVactionDays() {
    return baseVacationDays + extraVacationDays;
  }
}


