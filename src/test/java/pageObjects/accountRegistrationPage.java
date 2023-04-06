package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class accountRegistrationPage extends BasePage{
	
		public accountRegistrationPage(WebDriver driver) {
			super(driver);
		}
		
		@FindBy(id = "input-firstname") WebElement txtFirstName;
		@FindBy(id = "input-lastname") WebElement txtLastName;
		@FindBy(id = "input-email") WebElement txtEmail;
		@FindBy(id = "input-password") WebElement txtPassword;
		@FindBy(id = "input-newsletter-yes") WebElement radioYes;
		@FindBy(id = "input-newsletter-no") WebElement radioNo;
		@FindBy(xpath = "//button[text()='Continue']") WebElement btnContinue;
		@FindBy(xpath="//input[@name='agree']") WebElement chkPolicy;
		
		@FindBy(xpath = "//h1[normalize-space(text())='Your Account Has Been Created!']") WebElement msgConfirmation ;

				
		//Action methods
		public void setFirstName(String fname) {
			txtFirstName.sendKeys(fname);
			
		}
		
		public void setLastName(String lname) {
			txtLastName.sendKeys(lname);
			
		}
		
		public void setEmail(String email) {
			txtEmail.sendKeys(email);
			
		}
		
		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);
			
		}
		
		public void clickContinue() {
			btnContinue.click();
		}
		
		public void clickYes() {
			radioYes.click();
		}
		
		
		public void clickAgree() {
			chkPolicy.click();
		}
		
		public String getConfirmationMsg() {
			try {
			return msgConfirmation.getText();
			}catch(Exception e) {
				return e.getMessage();
			}
		}
		
		
}
