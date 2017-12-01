package qa.consulting.com.qactestingproject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePagePOM 
{
	@FindBy(css="a.c-btn--primary")
	WebElement signIn;
	
	public WebElement getLoginBtn()
	{
		return signIn;
	}
}
