package com.example.bootcamp.labs;

import java.io.StringWriter;
import java.io.Writer;

import org.junit.Assert;
import org.junit.Test;

public class BankTest {

  @Test
  public void testPrintAccount() throws Exception {
    
    Assert.assertEquals(CheckingAccount.lastId, 1000);
    
    CheckingAccount account = new CheckingAccount();
    Assert.assertEquals(1001, account.getNumber());
    
    Assert.assertEquals(0d, account.getAmount(), 0.001);
    
    account.print();

    String expected = "Account #1001 has a balance of $0.00";
    String actual = account.print();
    Assert.assertEquals(expected, actual);
  
  }
  
}
