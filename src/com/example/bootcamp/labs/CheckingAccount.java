package com.example.bootcamp.labs;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class CheckingAccount {

  // This is my private ID - no one can change it.
  private static int lastId = 1000;
  // But I want to inspect it in a test
  public static int getlastId() { return lastId; }

  private final int number = ++lastId;
  private double balance;
  private Customer customer;
  
  public CheckingAccount(Customer customer) {
    this(customer, 0.0);
  }

  public CheckingAccount(Customer customer, double balance) {
    this.customer = customer;
    this.balance = balance;
  }
  
  public Customer getCustomer() {
    return customer;
  }
  
  public int getNumber() {
    return number;
  }

  public double getBalance() {
    return balance;
  }

  public String print() {
    String text = String.format("Account #%d has a balance of $%.2f", getNumber(), getBalance());
    System.out.println(text);
    return text;
  }
  
  public boolean credit(double amount) {
    if (canCredit(amount) == false) {
      return false;
    }
    
    this.balance += amount;
    return true;
  }

  public boolean debit(double amount) {
    if (amount <= 0 || this.balance < amount) {
      return false;
    }

    this.balance -= amount;
    return true;
  }

  private boolean canCredit(double amount) {
    return amount > 0;
  }

  private boolean canDebit(double amount) {
    return amount > 0 && this.balance >= amount;
  }
  
  // renamed to avoid ambiguity
  public boolean transferTo(CheckingAccount fromAccount, double amount) {
    if (fromAccount.canDebit(amount) == false) return false;
    if (this.canCredit(amount) == false) return false;
    
    fromAccount.debit(amount);
    return this.credit(amount);
  }
}

