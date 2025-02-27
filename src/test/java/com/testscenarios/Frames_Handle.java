package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.utilities.CommonFunctions;

public class Frames_Handle extends CommonFunctions {

	@Test
	public void f() throws Exception {
		chromeBrowserLaunch();
		driver.get("https://mis.nyiso.com/public/");
		Thread.sleep(3000);
		// Zonal link click within the Frame
		loopAllFramesAndReturnCountofElement(By.name("P-24Alist"));
		driver.findElement(By.name("P-24Alist")).click();
		
		Thread.sleep(2000);
		
		loopAllFramesAndReturnCountofElement(By.xpath("/html/body/table/tbody/tr[8]/td[2]/span"));
		String dt = driver.findElement(By.xpath("/html/body/table/tbody/tr[8]/td[2]/span")).getText();
		System.out.println(dt);
	}
}