package com.testscenarios;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TS_04_PracticeAutomationtesting {
	WebDriver driver;

	@Test
	public void TC_27_guestmode() throws Exception {
		driver = new ChromeDriver();

		driver.get("https://practice.automationtesting.in");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("My Account")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("srikamunagala@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Automation@14031811");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Shop")).click();
		//Scroll
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,600)");
		
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("(//*[text()='Add to basket'])[1]")));
//		  click on first product - add to basket
		driver.findElement(By.xpath("(//*[text()='Add to basket'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Get the first product text
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[contains(@class,'masonry-done')]/li[1]/a/h3")));

		String expectedResults = driver.findElement(By.xpath("//*[contains(@class,'masonry-done')]/li[1]/a/h3")).getText();
		System.out.println("expectedResults is :" +expectedResults);
		
		//click on CART item	using Java script click
		//jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[6]/a")));
		//driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[6]/a")).click();
		jse.executeScript("window.scrollBy(0,1)");
		Thread.sleep(3000);
		WebElement cart = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[6]/a"));
		
		//Double click on element
		Actions act = new Actions(driver);
		act.doubleClick(cart).build().perform();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String actualResults = "Android Quick Start Guide!";
		//Verify "Android Quick Start Guide" content is displayed or not using Hard Assertion
		assertEquals(actualResults, expectedResults);
		System.out.println("Hard assertion is passed*******************");
		
		
		
//		WebElement View = driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a"));
//		View.getText();
	}
}
