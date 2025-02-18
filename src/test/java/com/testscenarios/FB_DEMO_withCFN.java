package com.testscenarios;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.utilities.CommonFunctions;

public class FB_DEMO_withCFN extends CommonFunctions {

	@Test
	public void abd() throws Exception {
		chromeBrowserLaunch();
		typeURLinBrowser("FB_URL");
		takeScreenshot("AfterLaunchHomaPage");
		sendKeysByAnyLocator(loc.fbLogin_Email_EditBox, "FB_UN");
		sendKeysByAnyLocator(loc.fbLogin_Password_EditBox, "FB_PWSD");
		takeScreenshot("AfterEnterInvalidCredentials");
		clickByAnyLocator(loc.fbLogin_Login_Button);
		Thread.sleep(6000);
		// takeScreenshot("ErrorPage");

	}

	@AfterMethod
	public void abc(ITestResult res) throws Exception {
		screenshotWithStatus(res);
		System.out.println("ss******");
		// Close my webpage
		//driver.quit();
	}
}
