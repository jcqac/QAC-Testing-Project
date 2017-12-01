package qa.consulting.com.qactestingproject;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test 
{
	private WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
	}
	
	@Test
	public void testreadalla()
	{
		 
		driver.get("https://www.autotrader.co.uk/");
 
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
 
		System.out.println(links.size());
 
		for (int i = 1; i<=links.size(); i=i+1)
 
		{
 
			System.out.println(links.get(i).getText());
 
		}
 
	}
}
