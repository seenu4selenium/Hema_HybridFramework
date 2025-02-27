package com.testscenarios;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsDemo {
  @Test
  public void f() {
	  
	  String actualResults = "Apple";
	  String expectedResults = "abcpple";
//	  Assertions in TestNG
//	    1. Hard Assertion
//		2. Soft Assertion
//	  System.out.println("Hard Assertion starts");
//	  assertEquals(actualResults, expectedResults);
//	  System.out.println("Hard Assertion end");
	  
	  
	  // Soft Assertion
	  SoftAssert sa = new SoftAssert();
	  System.out.println("soft Assertion starts");
	  sa.assertEquals(actualResults, expectedResults);
	  System.out.println("soft Assertion end");

	  //if softassertion failes, get the results with AssertAll()
	  sa.assertAll();

	  
  }
}
