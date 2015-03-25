package com.example.bootcamp.labs;

public class Customer {

  private String ssn;
  private String firstName;
  private String lastName;
  
  public Customer(String ssn, String firstName, String lastName) {
    this.ssn = ssn;
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  public String getSsn() {
    return ssn;
  }
  
  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFullName() {
    return firstName + " " + lastName;
  }
}
