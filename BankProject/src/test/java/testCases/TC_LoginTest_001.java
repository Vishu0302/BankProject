package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	
	@Test
	public void loginTest() throws IOException {
		
		
		logger.info("URL opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username Entered");
		
		lp.setPassword(password);
		logger.info("Password Entered");
		
		lp.clickSubmit();
		logger.info("Submit Clicked");
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		
		}else {
			
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");	
		}
	}	
}