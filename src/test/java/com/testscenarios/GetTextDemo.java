package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetTextDemo {
  @Test
  public void f() throws Exception {
	  WebDriver driver;
	  driver = new ChromeDriver();
//	  driver.get("https://automationexercise.com/");
//	  driver.manage().window().maximize();
//	  String eleText = driver.findElement(By.xpath("//*[text()='Full-Fledged practice website for Automation Engineers']")).getText();
//	  System.out.println(eleText);
//	  
	  driver.get("https://collegeweeklive.com/go-signup/");
	  Thread.sleep(6000);
	  driver.findElement(By.id("submit")).click();
	  Thread.sleep(2000);
	  String fnErrMsg = driver.findElement(By.id("firstNameError")).getText();
	  System.out.println(fnErrMsg);
	  
  }
}
