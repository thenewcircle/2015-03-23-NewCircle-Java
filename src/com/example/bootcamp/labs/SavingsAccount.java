package com.example.bootcamp.labs;

public class SavingsAccount extends BankingAccount implements IntestBearingAccount {

  public static final double DEFAULT_RATE = 0.02;

  private double interestRate;

  public SavingsAccount(Customer customer, double balance) {
    super(customer, balance);
    this.interestRate = DEFAULT_RATE;
  }

  public SavingsAccount(Customer customer, double balance, double interestRate) {
    super(customer, balance);
    this.interestRate = interestRate;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public double calculateOnMonthsInterest() {
    return getBalance() * getMonthlyRate();
  }

  public double getMonthlyRate() {
    return getInterestRate()/12;
  }

  @Override
  public void creditInterest() {
    credit(calculateOnMonthsInterest());
  }

  @Override
  public String getAccountType() {
    return "Savings";
  }
}
