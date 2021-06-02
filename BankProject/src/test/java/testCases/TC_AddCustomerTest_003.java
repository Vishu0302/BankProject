package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is Provided");
		lp.setPassword(password);
		logger.info("Password is Provided");
		lp.clickSubmit();
		logger.info("Click Submit Button");
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("Link Clicked");
		logger.info("Providing Customer Details");
		addcust.custName("Vishal");
		addcust.custgender("male");
		logger.info("Name and Gender Entered");
		addcust.custdob("03", "02", "1996");
		logger.info("DOB Entered");
		addcust.custaddress("Harinagar");
		addcust.custcity("Meerut");
		addcust.custstate("UP");
		addcust.custpinno("250001");
		logger.info("Address Details Entered");
		addcust.custtelephoneno("8439816674");
		
		String email = randomString()+"gmail.com";
		addcust.custemailid(email);
		logger.info("Phone and Email Entered");
		addcust.custsubmit();
		
		Thread.sleep(5000);
		logger.info("Validation Started");
		boolean res =driver.getPageSource().contains("Customer Registerd Successfully");
		
		if(res==true) {
			
			Assert.assertTrue(true);
			logger.info("TestCase Passed");
		}else {
			
			captureScreen(driver, "addNewCustomer");
			logger.info("TestCase Failed");
			Assert.assertTrue(false);
		}
		
	}
	
	
}