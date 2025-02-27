package com.testscenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TS_03_PracticeAutomationtesting {
	@Test
	public void f() throws Exception {
		WebDriver driver;
		driver = new ChromeDriver();

		driver.get("https://practice.automationtesting.in/my-account/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("srikamunagala@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Automation@14031811");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Addresses")).click();

		WebElement Text = driver.findElement(By.xpath("//*[contains(text(),'following addresses')]"));
		if (Text.getText().contains("The following addresses will be used on the checkout page by default.")) {
			System.out.println("Address page is opened");
		} else {
			System.out.println("Address page is not opened");
		}

		driver.findElement(By.xpath("(//*[text()='Edit'])[1]")).click();

		driver.findElement(By.id("billing_first_name")).sendKeys("srika");
		driver.findElement(By.id("billing_last_name")).sendKeys("Munagala");
		driver.findElement(By.id("billing_phone")).sendKeys("1223456789");

		driver.findElement(By.xpath("(//*[@class='select2-chosen'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//*[text()='Japan'])[2]")).click();

		driver.findElement(By.id("billing_address_1")).sendKeys("1084 parkhilll cir");
		driver.findElement(By.id("billing_city")).sendKeys("naperville");

		// State
		driver.findElement(By.xpath("(//*[@class='select2-chosen'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//*[text()='Iwate'])[2]")).click();

		driver.findElement(By.id("billing_postcode")).sendKeys("12345");

		// Click on save_address
		driver.findElement(By.name("save_address")).click();
	}
}
