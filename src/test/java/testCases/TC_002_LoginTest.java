package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.baseClass;

public class TC_002_LoginTest extends  baseClass{

@Test(groups= {"Sanity","Master"})
public void test_login() {
	try {
	logger.info(" *** Starting TC_002_LoginTest ***");
	HomePage hp = new HomePage(driver);
	hp.clickMyAccount();
	logger.info("Clicked My Account");
	
	hp.clickLogin();
	logger.info("Clicked Login");
	
	logger.info("Providing Login details");
	LoginPage lp = new LoginPage(driver);
	lp.setEmail(rb.getString("email"));
	lp.setPassword(rb.getString("password"));
	
	lp.clickLogin();
	logger.info("Clicked Login button");
	
	MyAccountPage macc = new MyAccountPage(driver);
	boolean targetPage = macc.isMyAccountPageExists();

	Assert.assertEquals(targetPage,true, "Account not created");
	}
	catch(AssertionError e) {
		logger.error(e.getMessage());
		Assert.fail();
	}
	
	logger.info(" *** Finished TC_002_LoginTest ***");
}
}
