package com.example.bootcamp.labs;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class CheckingAccount extends BankingAccount {

  public CheckingAccount(Customer customer) {
    this(customer, 0.0);
  }

  public CheckingAccount(Customer customer, double balance) {
    super(customer, balance);
  }

  @Override
  public String getAccountType() {
    return "Checking";
  }
}

