package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.baseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends baseClass {
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_loginDDT(String email, String password, String exp) {
		try {
		logger.info(" *** Starting TC_002_LoginTest ***");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked My Account");
		
		hp.clickLogin();
		logger.info("Clicked Login");
		
		logger.info("Providing Login details");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		
		lp.clickLogin();
		logger.info("Clicked Login button");
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
		
		if(exp.equals("valid")) {
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("invalid")) {
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}

		}
		catch(Exception e) {
			Assert.fail();
		}

		
		logger.info(" *** Finished TC_002_LoginTest ***");
		
		
	}

}
