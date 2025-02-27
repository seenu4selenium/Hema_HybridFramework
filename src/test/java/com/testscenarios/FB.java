package com.testscenarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class FB {

	@Test
	public void test() {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("navya.bingi11@gmail.com");
//		driver.find_element_by_id("passwd-id").send_keys("some text");

		driver.findElement(By.name("pass")).sendKeys("hjgvadjh");
		driver.findElement(By.name("login")).click();
	}

}
