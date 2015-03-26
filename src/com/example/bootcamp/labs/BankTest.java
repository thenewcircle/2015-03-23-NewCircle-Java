package com.example.bootcamp.labs;

import static org.junit.Assert.*;

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
    assertEquals(CheckingAccount.getlastId(), tomsChecking.getNumber());

    tomsSavings = new SavingsAccount(tom, 100, SavingsAccount.DEFAULT_RATE);
    assertEquals(CheckingAccount.getlastId(), tomsSavings.getNumber());
    
    tomsCD = new CD(tom, 1000, .15);
    
    Customer bill = new Customer("666-66-6666", "Bill", "Smith");
    billsChecking = new CheckingAccount(bill, 1_000_000.00);
    assertEquals(CheckingAccount.getlastId(), billsChecking.getNumber());

    billsSavings = new SavingsAccount(bill, 200, SavingsAccount.DEFAULT_RATE);
  }

  @Test
  public void createCustomer() {
    // Verity that Tom (the customer) was created properly
    assertEquals("555-55-5555", tom.getSsn());
    assertEquals("Tom", tom.getFirstName());
    assertEquals("Jones", tom.getLastName());
    assertEquals("Tom Jones", tom.getFullName());
  }

  @Test
  public void createCheckingAccount() {
    // Verity that Tom's account was created properly
    // Cannot test the ID here.
    assertEquals(109.87, tomsChecking.getBalance(), 0.001);
    assertSame(tom, tomsChecking.getCustomer());
    

    // Make sure that the next ID given to bill is not the same as tom's.
    assertNotEquals(billsChecking.getNumber(), tomsChecking.getNumber());
  }

  @Test
  public void createSavingsAccount() {
    // Verity that Tom's account was created properly
    // Cannot test the ID here.
    assertEquals(100, tomsSavings.getBalance(), 0.001);
    assertSame(tom, tomsSavings.getCustomer());
    assertEquals(0.02, tomsSavings.getInterestRate(), 0.001);

    // Make sure that the next ID given to bill is not the same as tom's.
    assertNotEquals(tomsSavings.getNumber(), tomsChecking.getNumber());
  }

  @Test
  public void testPrintAccount() {
    String expected = String.format("Checking account #%d has a balance of $109.87", tomsChecking.getNumber());
    assertEquals(expected, tomsChecking.print());

    expected = String.format("Savings account #%d has a balance of $100.00", tomsSavings.getNumber());
    assertEquals(expected, tomsSavings.print());
  }
  
  @Test
  public void testDebit() {
    assertFalse(tomsChecking.debit(0));
    assertEquals(109.87, tomsChecking.getBalance(), 0.001);

    assertFalse(tomsChecking.debit(-1));
    assertEquals(109.87, tomsChecking.getBalance(), 0.001);
    
    assertTrue(tomsChecking.debit(10));
    assertEquals(99.87, tomsChecking.getBalance(), 0.001);
  }
  
  @Test
  public void testCredit() {
    assertFalse(tomsChecking.credit(0));
    assertEquals(109.87, tomsChecking.getBalance(), 0.001);

    assertFalse(tomsChecking.credit(-1));
    assertEquals(109.87, tomsChecking.getBalance(), 0.001);

    assertTrue(tomsChecking.credit(10));
    assertEquals(tomsChecking.getBalance(), 119.87, 0.001);
  }

  @Test
  public void testTransfer() {
    // Cannot transfer $0
    assertFalse(tomsChecking.transferTo(billsChecking, 0));
    assertEquals(109.87, tomsChecking.getBalance(), 0.001);
    assertEquals(1_000_000, billsChecking.getBalance(), 0.001);

    // Cannot transfer negative amounts
    assertFalse(tomsChecking.transferTo(billsChecking, -1));
    assertEquals(109.87, tomsChecking.getBalance(), 0.001);
    assertEquals(1_000_000, billsChecking.getBalance(), 0.001);

    // Canfnot over draft an account.
    assertFalse(tomsChecking.transferTo(billsChecking, Integer.MAX_VALUE));
    assertEquals(109.87, tomsChecking.getBalance(), 0.001);
    assertEquals(1_000_000, billsChecking.getBalance(), 0.001);

    assertTrue(tomsChecking.transferTo(billsChecking, 100_000));
    assertEquals(1_000_000 - 100_000, billsChecking.getBalance(), 0.001);
    assertEquals(109.87 + 100_000, tomsChecking.getBalance(), 0.001);
  }

  @Test
  public void testCalculateInterest() {
    
    double monthlyRate = tomsSavings.getMonthlyRate();
    assertEquals(0.001666, monthlyRate, 0.001);
    assertEquals(100, tomsSavings.getBalance(), 0.001);
    
    double interest = tomsSavings.calculateOnMonthsInterest();
    assertEquals(0.1666, interest, 0.001);
    assertEquals(100, tomsSavings.getBalance(), 0.001);
  }

  @Test 
  public void testCreditOneMonthsInterest() {
    tomsSavings.creditInterest();
    assertEquals(100.1666, tomsSavings.getBalance(), 0.001);
  }

  @Test
  public void testCreditOneYearsInterest() {
    for (int i = 0; i < 12; i++) {
      tomsSavings.creditInterest();
    }
    assertEquals(102.0184, tomsSavings.getBalance(), 0.001);
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
    
    assertEquals(109.87, tomsChecking.getBalance(), 0.001);
    assertEquals(102.0184, tomsSavings.getBalance(), 0.001);
    assertEquals(1_000_000, billsChecking.getBalance(), 0.001);
    assertEquals(204.0368, billsSavings.getBalance(), 0.001);
    System.out.println("******************");
  }
}
