package qa.consulting.com.qactestingproject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPagePOM 
{
	@FindBy(css="#signin-email")
	WebElement signInEmail;
	
	@FindBy(css="#signin-password")
	WebElement signInPasswd;
	
	@FindBy(css="#js-social__signin-tab")
	WebElement signInTab;
	
	@FindBy(css="#signInSubmit")
	WebElement signInBtn;
	
	@FindBy(css="#email")
	WebElement signUpEmail;
	
	@FindBy(css="#password")
	WebElement signUpPasswd;
	
	@FindBy(css="#js-social__signup-tab")
	WebElement signUpTab;
	
	@FindBy(css="#social--signup--submit")
	WebElement signUpBtn;
	
	public WebElement getSignInEmail()
	{
		return signInEmail;
	}
	
	public WebElement getSignInPwd()
	{
		return signInPasswd;
	}
	
	public WebElement getSignInTab()
	{
		return signInTab;
	}
	
	public WebElement getSignInBtn()
	{
		return signInBtn;
	}
	
	public WebElement getSignUpEmail()
	{
		return signUpEmail;
	}
	
	public WebElement getSignUpPwd()
	{
		return signUpPasswd;
	}
	
	public WebElement getSignUpTab()
	{
		return signUpTab;
	}
	
	public WebElement getSignUpBtn()
	{
		return signUpBtn;
	}
	
}
