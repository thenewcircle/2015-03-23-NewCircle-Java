package com.example.bootcamp.employee;

public class Employee {

  static int vacationDays = 10;
  
  String name;
  String ssn;
  String emailAddress;
  int yearOfBirth;

  void print() {
    System.out.println("Name: " + name);
    System.out.println("SSN: " + ssn);
    System.out.println("Email Address: " + emailAddress);
    System.out.println("Year Of Birth: " + yearOfBirth);
    System.out.println("Vacation days: " + vacationDays);
  }

  public int getVacationDays() {
    return vacationDays;
  }

  public static void setVacationDays(int vacationDays) {
    Employee.vacationDays = vacationDays;
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
  
}

