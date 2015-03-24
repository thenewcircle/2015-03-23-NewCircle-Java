package com.example.bootcamp.calc;

public class Calc {


  public static void main(String[] args) {

    calc(args);

  }

  public static void calc(String...args) {

    String operator = args[0];
    double amount = Double.parseDouble(args[1]);

    for (int i = 2; i < args.length; i++) {

      double val = Double.parseDouble(args[i]);
      
      if ("+".equals(operator)) {
        amount += val;

      } else if ("-".equals(operator)) {
        amount -= val;

      } else if ("x".equals(operator)) {
        amount *= val;

      } else if ("/".equals(operator)) {
        amount /= val;
      }     
    
    }
    System.out.println("Amount: " + amount);

  }
}