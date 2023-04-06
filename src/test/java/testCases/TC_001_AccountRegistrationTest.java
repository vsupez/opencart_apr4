package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.accountRegistrationPage;
import testBase.baseClass;

public class TC_001_AccountRegistrationTest extends baseClass {
	

	@Test(groups= {"Regression","Master"})
	void test_account_Registration() {
		logger.debug("Application logs");
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on Account link");
		
		hp.clickRegister();
		logger.info("Clicked on register link");
		
		accountRegistrationPage regpage = new accountRegistrationPage(driver);
		logger.info("Providing customer data");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");    //randomly created unique email
		regpage.setPassword(randomAlphaNumericr());
//		regpage.clickYes();
		regpage.clickAgree();

		
		regpage.clickContinue();
		logger.info("Clicked on Continue ");
		String confmsg = regpage.getConfirmationMsg();
		logger.info("Validating expected message");

		Assert.assertEquals(confmsg,"Your Account Has Been Created!", "Not getting expected message");
		
		}catch(AssertionError e) {
			logger.error(e.getMessage());
			Assert.fail();
		}
		
		logger.info("*** Finished TC_001_AccountRegistrationTest ***");
	}

}
