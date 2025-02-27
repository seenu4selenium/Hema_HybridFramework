package com.testscenarios;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Justrecharge {
	WebDriver driver;

	@Test
	public void f() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.justrechargeit.com/SignIn.aspx");
		Thread.sleep(2000);
		// to get the current page(window) name
		String mainWindowName = driver.getWindowHandle();
		System.out.println(mainWindowName);
		System.out.println("**************************************");

		driver.findElement(By.xpath("//*[@id=\"signinpanel\"]/tbody/tr/td[3]/table/tbody/tr[2]/td/a/img")).click();
		Thread.sleep(2000);
		// Get all window(s) names
		Set<String> allWindowNames = driver.getWindowHandles();
		for (String childWindowName : allWindowNames) {
			// System.out.println(childWindowName);
			// Verify the current page name is matching to popup window or not?
			if (!mainWindowName.equals(childWindowName)) {
//				  Handle pop - up
				driver.switchTo().window(childWindowName);
				driver.findElement(By.name("email")).sendKeys("navya@gmail.com");
				Thread.sleep(2000);
				driver.close();
			}
		}
		//Move cursor point to parent page
		driver.switchTo().window(mainWindowName);
		
		driver.findElement(By.name("txtUserName")).sendKeys("Hema");

	}
}