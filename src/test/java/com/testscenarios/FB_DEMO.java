package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.objectrepository.Locators;

public class FB_DEMO {
	// Create an Object for Locators class, to get the Locators
	// CLASSNAME objectName = NEW CLASSNAME();
	Locators loc = new Locators();

	
	@Test
	public void f() throws Exception {
		// Read the properties file data
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData\\td.properties");
		Properties prop = new Properties();
		// Load the test data from Property file to PROP object
		prop.load(fi);

		WebDriver driver;
		driver = new ChromeDriver();
		driver.get(prop.getProperty("FB_URL"));

		//Locators is enable / disabled?
		//if any existing data present, has to clear that?
		//send the data
		driver.findElement(loc.fbLogin_Email_EditBox).sendKeys(prop.getProperty("FB_UN"));
		driver.findElement(loc.fbLogin_Password_EditBox).sendKeys(prop.getProperty("FB_PWSD"));
		driver.findElement(loc.fbLogin_Login_Button).click();
	}
}
