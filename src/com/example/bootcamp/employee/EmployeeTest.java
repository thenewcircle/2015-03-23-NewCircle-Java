package com.example.bootcamp.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class EmployeeTest {

  @Test
  public void testEmployee() {
    Employee e1 = new Employee();
    e1.setName("John");
    e1.setSsn("555-12-345");
    e1.setEmailAddress("john@company.com");
    e1.setAgesOfChildren(1,2,3,4,5);
    
    List<Integer> list = Arrays.asList(6,7,8,9);
    list = new ArrayList();
    list.add(3);
    list.add(6);
    list.add(39);
    e1.setAgesOfChildren(list);
    
    Employee e2 = new Employee();
    e2.setName("Tom");
    e2.setSsn("456-78-901");
    e2.setYearOfBirth(1974);

    e2.setAgesOfChildren(23, 25, 29);

    Set<Integer> set = new HashSet<>();
    set.add(6);
    set.add(9);
    set.add(9);
    set.add(9);
    set.add(12);
    
    list = Arrays.asList(6,9,9,912);
    set = new HashSet<>(list);
    
    e2.setAgesOfChildren(set);
    
    e2.print("==Employee of the Month", "===============");
    System.out.println();

  }
}
