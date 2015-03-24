package com.example.bootcamp.labs;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class CheckingAccount {

  public static int lastId = 1000;

  private int number = ++lastId;
  private double amount;
  
  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String print() {
    String text = String.format("Account #%d has a balance of $%.2f", getNumber(), getAmount());
    System.out.println(text);
    return text;
  }
}
