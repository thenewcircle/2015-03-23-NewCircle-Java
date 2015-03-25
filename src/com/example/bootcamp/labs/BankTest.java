package com.example.bootcamp.labs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

  private Customer tom;
  private CheckingAccount tomsChecking;
  private SavingsAccount tomsSavings;
  private CD tomsCD;

  private CheckingAccount billsChecking;
  private SavingsAccount billsSavings;
  
  @Before
  public void beforeMethod() {
    tom = new Customer("555-55-5555", "Tom", "Jones");
    tomsChecking = new CheckingAccount(tom, 109.87);
    Assert.assertEquals(CheckingAccount.getlastId(), tomsChecking.getNumber());

    tomsSavings = new SavingsAccount(tom, 100, SavingsAccount.DEFAULT_RATE);
    Assert.assertEquals(CheckingAccount.getlastId(), tomsSavings.getNumber());
    
    tomsCD = new CD(tom, 1000, .15);
    
    Customer bill = new Customer("666-66-6666", "Bill", "Smith");
    billsChecking = new CheckingAccount(bill, 1_000_000.00);
    Assert.assertEquals(CheckingAccount.getlastId(), billsChecking.getNumber());

    billsSavings = new SavingsAccount(bill, 200, SavingsAccount.DEFAULT_RATE);
  }

  @Test
  public void createCustomer() {
    // Verity that Tom (the customer) was created properly
    Assert.assertEquals("555-55-5555", tom.getSsn());
    Assert.assertEquals("Tom", tom.getFirstName());
    Assert.assertEquals("Jones", tom.getLastName());
    Assert.assertEquals("Tom Jones", tom.getFullName());
  }

  @Test
  public void createCheckingAccount() {
    // Verity that Tom's account was created properly
    // Cannot test the ID here.
    Assert.assertEquals(109.87, tomsChecking.getBalance(), 0.001);
    Assert.assertSame(tom, tomsChecking.getCustomer());
    

    // Make sure that the next ID given to bill is not the same as tom's.
    Assert.assertNotEquals(billsChecking.getNumber(), tomsChecking.getNumber());
  }

  @Test
  public void createSavingsAccount() {
    // Verity that Tom's account was created properly
    // Cannot test the ID here.
    Assert.assertEquals(100, tomsSavings.getBalance(), 0.001);
    Assert.assertSame(tom, tomsSavings.getCustomer());
    Assert.assertEquals(0.02, tomsSavings.getInterestRate(), 0.001);

    // Make sure that the next ID given to bill is not the same as tom's.
    Assert.assertNotEquals(tomsSavings.getNumber(), tomsChecking.getNumber());
  }

  @Test
  public void testPrintAccount() {
    String expected = String.format("Checking account #%d has a balance of $109.87", tomsChecking.getNumber());
    Assert.assertEquals(expected, tomsChecking.print());

    expected = String.format("Savings account #%d has a balance of $100.00", tomsSavings.getNumber());
    Assert.assertEquals(expected, tomsSavings.print());
  }
  
  @Test
  public void testDebit() {
    Assert.assertFalse(tomsChecking.debit(0));
    Assert.assertEquals(109.87, tomsChecking.getBalance(), 0.001);

    Assert.assertFalse(tomsChecking.debit(-1));
    Assert.assertEquals(109.87, tomsChecking.getBalance(), 0.001);
    
    Assert.assertTrue(tomsChecking.debit(10));
    Assert.assertEquals(99.87, tomsChecking.getBalance(), 0.001);
  }
  
  @Test
  public void testCredit() {
    Assert.assertFalse(tomsChecking.credit(0));
    Assert.assertEquals(109.87, tomsChecking.getBalance(), 0.001);

    Assert.assertFalse(tomsChecking.credit(-1));
    Assert.assertEquals(109.87, tomsChecking.getBalance(), 0.001);

    Assert.assertTrue(tomsChecking.credit(10));
    Assert.assertEquals(tomsChecking.getBalance(), 119.87, 0.001);
  }

  @Test
  public void testTransfer() {
    // Cannot transfer $0
    Assert.assertFalse(tomsChecking.transferTo(billsChecking, 0));
    Assert.assertEquals(109.87, tomsChecking.getBalance(), 0.001);
    Assert.assertEquals(1_000_000, billsChecking.getBalance(), 0.001);

    // Cannot transfer negative amounts
    Assert.assertFalse(tomsChecking.transferTo(billsChecking, -1));
    Assert.assertEquals(109.87, tomsChecking.getBalance(), 0.001);
    Assert.assertEquals(1_000_000, billsChecking.getBalance(), 0.001);

    // Canfnot over draft an account.
    Assert.assertFalse(tomsChecking.transferTo(billsChecking, Integer.MAX_VALUE));
    Assert.assertEquals(109.87, tomsChecking.getBalance(), 0.001);
    Assert.assertEquals(1_000_000, billsChecking.getBalance(), 0.001);

    Assert.assertTrue(tomsChecking.transferTo(billsChecking, 100_000));
    Assert.assertEquals(1_000_000 - 100_000, billsChecking.getBalance(), 0.001);
    Assert.assertEquals(109.87 + 100_000, tomsChecking.getBalance(), 0.001);
  }

  @Test
  public void testCalculateInterest() {
    
    double monthlyRate = tomsSavings.getMonthlyRate();
    Assert.assertEquals(0.001666, monthlyRate, 0.001);
    Assert.assertEquals(100, tomsSavings.getBalance(), 0.001);
    
    double interest = tomsSavings.calculateOnMonthsInterest();
    Assert.assertEquals(0.1666, interest, 0.001);
    Assert.assertEquals(100, tomsSavings.getBalance(), 0.001);
  }

  @Test 
  public void testCreditOneMonthsInterest() {
    tomsSavings.creditInterest();
    Assert.assertEquals(100.1666, tomsSavings.getBalance(), 0.001);
  }

  @Test
  public void testCreditOneYearsInterest() {
    for (int i = 0; i < 12; i++) {
      tomsSavings.creditInterest();
    }
    Assert.assertEquals(102.0184, tomsSavings.getBalance(), 0.001);
  }

  @Test
  public void testMany() {
    System.out.println();
    System.out.println("**** Test Many ****");

    BankingAccount[] accounts = new BankingAccount[]{
        tomsChecking,
        tomsSavings,
        billsChecking,
        billsSavings,
        tomsCD
    };

    for (BankingAccount account : accounts) {
      if (account instanceof IntestBearingAccount) {
        for (int i = 0; i < 12; i++) {
          IntestBearingAccount savings = (IntestBearingAccount)account;
          savings.creditInterest();
        }
      }
      account.print();
    }
    
    Assert.assertEquals(109.87, tomsChecking.getBalance(), 0.001);
    Assert.assertEquals(102.0184, tomsSavings.getBalance(), 0.001);
    Assert.assertEquals(1_000_000, billsChecking.getBalance(), 0.001);
    Assert.assertEquals(204.0368, billsSavings.getBalance(), 0.001);
    System.out.println("******************");
  }
  
  @Test
  public void testAbstract() {
    // BankingAccount x = new BankingAccount(tom, "Whatever", 0);
    Customer x = IntestBearingAccount.CUSTOMER;
    // IntestBearingAccount account = new IntestBearingAccount();
  }
  
}
