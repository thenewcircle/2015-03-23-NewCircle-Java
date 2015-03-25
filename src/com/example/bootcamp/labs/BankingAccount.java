package com.example.bootcamp.labs;

public abstract class BankingAccount {

  // This is my private ID - no one can change it.
  private static int lastId = 1000;
  // But I want to inspect it in a test
  public static int getlastId() { return lastId; }

  private final int number = ++lastId;
  private double balance;
  private Customer customer;

  public abstract String getAccountType();

  public BankingAccount(Customer customer, double balance) {
    this.balance = balance;
    this.customer = customer;
  }

  public int getNumber() {
    return number;
  }

  public double getBalance() {
    return balance;
  }

  public Customer getCustomer() {
    return customer;
  }

  public String print() {
    String text = String.format("%s account #%d has a balance of $%.2f", getAccountType(), getNumber(), getBalance());
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
  public boolean transferTo(BankingAccount fromAccount, double amount) {
    if (fromAccount.canDebit(amount) == false) return false;
    if (this.canCredit(amount) == false) return false;
    
    fromAccount.debit(amount);
    return this.credit(amount);
  }
}
