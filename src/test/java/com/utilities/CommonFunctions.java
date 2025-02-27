package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import com.objectrepository.Locators;

public class CommonFunctions {
	// Common Variables
	public static WebDriver driver;
	public Locators loc = new Locators();
	public Properties prop = new Properties();
	public FileInputStream fi;
	String testdataFilePath = ".\\src\\test\\resources\\TestData\\td.properties";
	// String testdataFilePath =
	// ".\\src\\test\\resources\\TestData\\PROD_TestData.properties";
	// String testdataFilePath =
	// ".\\src\\test\\resources\\TestData\\UAT_TD.properties";

	// Launch Chrome browser
	public void chromeBrowserLaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("ChromBrowser launched successfuuly***");
	}

	public void typeURLinBrowser(String inputdata) throws Exception {
		fi = new FileInputStream(testdataFilePath);
		prop.load(fi);
		driver.get(prop.getProperty(inputdata));
	}

	// Common functions
	/** Send data to any editbox ****/
	public void sendKeysByAnyLocator(By locator, String inputdata) throws Exception {
		// Read the properties file data
		fi = new FileInputStream(testdataFilePath);
		// Load the test data from Property file to PROP object
		prop.load(fi);

		WebElement element = driver.findElement(locator);
		// Is locator displayed on current screen?
		if (driver.findElements(locator).size() > 0) {
			// Check the locator is enable /disable state
			if (element.isEnabled()) {
				highlightElement(element);
				// Clean the existing data
				element.clear();
				highlightElement(element);
				element.sendKeys(prop.getProperty(inputdata));
			} else {
				System.out.println("***Element is disabled state....***");
			}
		} else {
			System.out.println("***Element is not Displayed on current Page....***");
		}
		System.out.println(locator + " Successfully Data has sent to edit box***");
	}

	/** Click on any button/link/image/radio button/check box ****/
	public void clickByAnyLocator(By locator) throws Exception {
		WebElement element = driver.findElement(locator);
		// Is locator displayed on current screen?
		if (driver.findElements(locator).size() > 0) {
			// Check the locator is enable /disable state
			if (element.isEnabled()) {
				highlightElement(element);
				element.click();
			} else {
				System.out.println("***Element is disabled state....***");
			}
		} else {
			System.out.println("***Element is not Displayed on current Page....***");
		}
		System.out.println(locator + " Successfully clicked on element***");
	}

	/*** highlight web Element ***/
	public void highlightElement(WebElement element) throws InterruptedException {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			for (int i = 0; i < 1; i++) {
				executor.executeScript("arguments[0].style.border='7px solid red'", element);
				Thread.sleep(200);
				executor.executeScript("arguments[0].style.border='7px groove green'", element);
			}
		} catch (Exception e) {
			System.out.println("Exception - " + e.getMessage());
		}
	}

	/****************** Dropdown selection **************************************/

	public void selectByVisibleText(By locater, String visibleText) {

		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByVisibleText(visibleText);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void selectByIndex(By locater, int index) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByIndex(index);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void selectByValue(By locater, String value) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByValue(value);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void printAllDropdownValues(By locater) {
		WebElement element = driver.findElement(locater);

		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				List<WebElement> dropdownValues = dropdown.getOptions();
				// Print the size of dropdown values
				System.out.println(dropdownValues.size());
				// Print the dropdown values
				for (int i = 0; i < dropdownValues.size(); i++) {
					System.out.println(dropdownValues.get(i).getText());
				}
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void selectCustomiseOptionFromTheDropdownValues(By locater, String visibleText) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {

				Select dropdown = new Select(element);
				List<WebElement> dropdownValues = dropdown.getOptions();
				// Print the size of dropdown values
				System.out.println(dropdownValues.size());
				// Print the dropdown values
				for (int i = 0; i < dropdownValues.size(); i++) {
					System.out.println(dropdownValues.get(i).getText());

					// Select Aug option from the dropdown
					if (dropdownValues.get(i).getText().equals(visibleText)) {
						dropdown.selectByIndex(i);
						break;
					}
				}

			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	// TimeStamp
	
	/*****
	 * takescreenshot
	 * 
	 * @throws Exception
	 ************/
	public void takeScreenshot(String name) throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = ".\\Screenshots\\";
		FileHandler.copy(scrFile, new File(screenshotPath + name + timestamp() + ".PNG"));
		System.out.println("Screenshot taken*** ");
	}

	public void screenshotWithStatus(ITestResult res) throws Exception {
		String projectDir = System.getProperty("user.dir");
		String screenshotPath = projectDir + "\\Screenshots\\";
		String className = res.getTestClass().getName().trim();
		String methodName = res.getName().trim();
		// STATUS_PackageName.ClassName_MethodName_Timestamp.PNG
		if (res.getStatus() == ITestResult.SUCCESS) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile,
					new File(screenshotPath + "PASS_" + className + "_" + methodName + "_" + timestamp() + ".PNG"));
		}
		if (res.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile,
					new File(screenshotPath + "FAIL_" + className + "_" + methodName + "_" + timestamp() + ".PNG"));
		}

	}

	/*********** timestamp **********/
	public String timestamp() {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("ddMMMyyy_HHmmss");
		String timeTamp = df.format(d);
		return timeTamp;
	}

	public void getSystemDateAndTime() {
		Date d = new Date();
		System.out.println(d);

		System.out.println("****************");

		long currentTimeInMillis = System.currentTimeMillis();
		Date today = new Date(currentTimeInMillis);
		System.out.println(today);

		System.out.println("****************");

		Calendar cal = Calendar.getInstance();
		today = cal.getTime();
		System.out.println(today);
	}

	// Get current system time
	/**
	 * @Method:getcurrenttime This method is used to return system time in seconds.
	 */
	public static void getcurrenttime() {
		long currentDateMS = new Date().getTime();
		int seconds = (int) ((currentDateMS / 1000) % 3600);
		System.out.println(currentDateMS);
		System.out.println(seconds);
	}

	public static void GetUnixTimeStampSystem() {
		long unixTimestamp = System.currentTimeMillis() / 1000L;
		System.out.println("Unix timestamp: " + unixTimestamp);
	}

	public static void getUnixTimeStampDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 8);
		cal.set(Calendar.YEAR, 2022);

		Date givenDate = cal.getTime();
		long unixTimestamp = givenDate.toInstant().getEpochSecond();
		System.out.println("Unix timestamp: " + unixTimestamp);

	}

	/******************** Frames Handling *******************/

	public int iframeCount() {
		driver.switchTo().defaultContent();
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		int numberOfFrames = 0;
		numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are: " + numberOfFrames);
		return numberOfFrames;
	}

	public void switchToFrameByInt(int i) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(i);
	}

	public int loopAllFramesAndReturnCountofElement(By locator) {

		int elementpresenceCount = 0;
		int loop = 0;
		int maxFramecount = iframeCount();// 3
		// if given locater has present on webpage, then the element size would be '1'
		// else '0'
		elementpresenceCount = driver.findElements(locator).size();// 0
		while (elementpresenceCount == 0 && loop < maxFramecount) {
			try {
				switchToFrameByInt(loop);
				elementpresenceCount = driver.findElements(locator).size();// 0
				System.out.println("Try LoopAllframesAndReturnWebEL : " + loop + "; ElementpresenceCount: "
						+ elementpresenceCount);
				if (elementpresenceCount > 0 || loop > maxFramecount) {
					break;
				}
			} catch (Exception ex) {
				System.out.println("Catch LoopAllframesAndReturnWebEL Old: " + loop + "; " + ex);
			}
			loop++;
		}
		return elementpresenceCount;
	}
}
