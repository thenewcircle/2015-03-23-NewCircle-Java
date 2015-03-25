package com.example.bootcamp.labs;

public interface IntestBearingAccount {

  Customer CUSTOMER = new Customer("x", "x", "x");
  
  /** This method should add to the current balance, 1/12 of the account's current interest rate */
  void creditInterest();

}
