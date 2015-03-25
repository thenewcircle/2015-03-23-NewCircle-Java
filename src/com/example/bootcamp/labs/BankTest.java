package com.example.bootcamp.labs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

  private Customer tom;
  private CheckingAccount tomsAccount;

  private CheckingAccount billsAccount;
  
  @Before
  public void beforeMethod() {
    tom = new Customer("555-55-5555", "Tom", "Jones");
    tomsAccount = new CheckingAccount(tom, 109.87);
    Assert.assertEquals(CheckingAccount.getlastId(), tomsAccount.getNumber());

    Customer bill = new Customer("666-66-6666", "Bill", "Smith");
    billsAccount = new CheckingAccount(bill, 1_000_000.00);
    Assert.assertEquals(CheckingAccount.getlastId(), billsAccount.getNumber());
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
  public void createAccount() {
    // Verity that Tom's account was created properly
    // Cannot test the ID here.
    Assert.assertEquals(109.87, tomsAccount.getBalance(), 0.001);
    Assert.assertSame(tom, tomsAccount.getCustomer());

    // Make sure that the next ID given to bill is not the same as tom's.
    Assert.assertEquals(CheckingAccount.getlastId(), billsAccount.getNumber());
    Assert.assertNotEquals(billsAccount.getNumber(), tomsAccount.getNumber());
  }

  @Test
  public void testPrintAccount() {
    String expected = String.format("Account #%d has a balance of $109.87", tomsAccount.getNumber());
    Assert.assertEquals(expected, tomsAccount.print());

    // Any good reason to test this again?
    expected = String.format("Account #%d has a balance of $1000000.00", billsAccount.getNumber());
    Assert.assertEquals(expected, billsAccount.print());
  }
  
  @Test
  public void testDebit() {
    Assert.assertFalse(tomsAccount.debit(0));
    Assert.assertEquals(109.87, tomsAccount.getBalance(), 0.001);

    Assert.assertFalse(tomsAccount.debit(-1));
    Assert.assertEquals(109.87, tomsAccount.getBalance(), 0.001);
    
    Assert.assertTrue(tomsAccount.debit(10));
    Assert.assertEquals(99.87, tomsAccount.getBalance(), 0.001);
  }
  
  @Test
  public void testCredit() {
    Assert.assertFalse(tomsAccount.credit(0));
    Assert.assertEquals(109.87, tomsAccount.getBalance(), 0.001);

    Assert.assertFalse(tomsAccount.credit(-1));
    Assert.assertEquals(109.87, tomsAccount.getBalance(), 0.001);

    Assert.assertTrue(tomsAccount.credit(10));
    Assert.assertEquals(tomsAccount.getBalance(), 119.87, 0.001);
  }

  @Test
  public void testTransfer() {
    // Cannot transfer $0
    Assert.assertFalse(tomsAccount.transferTo(billsAccount, 0));
    Assert.assertEquals(109.87, tomsAccount.getBalance(), 0.001);
    Assert.assertEquals(1_000_000, billsAccount.getBalance(), 0.001);

    // Cannot transfer negative amounts
    Assert.assertFalse(tomsAccount.transferTo(billsAccount, -1));
    Assert.assertEquals(109.87, tomsAccount.getBalance(), 0.001);
    Assert.assertEquals(1_000_000, billsAccount.getBalance(), 0.001);

    // Canfnot over draft an account.
    Assert.assertFalse(tomsAccount.transferTo(billsAccount, Integer.MAX_VALUE));
    Assert.assertEquals(109.87, tomsAccount.getBalance(), 0.001);
    Assert.assertEquals(1_000_000, billsAccount.getBalance(), 0.001);

    Assert.assertTrue(tomsAccount.transferTo(billsAccount, 100_000));
    Assert.assertEquals(1_000_000 - 100_000, billsAccount.getBalance(), 0.001);
    Assert.assertEquals(109.87 + 100_000, tomsAccount.getBalance(), 0.001);
  }
}
