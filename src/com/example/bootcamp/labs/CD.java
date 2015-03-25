package com.example.bootcamp.labs;

public class CD extends BankingAccount implements IntestBearingAccount {

  private double interestRate;
  
  public CD(Customer customer, double balance, double intrestReate) {
    super(customer, balance);
    this.interestRate = intrestReate;
  }

  @Override
  public void creditInterest() {
      super.credit(getBalance() * (interestRate/12));
  }

  @Override
  public String getAccountType() {
    return "CD";
  }
}
