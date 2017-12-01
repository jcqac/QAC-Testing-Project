package qa.consulting.com.qactestingproject;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AutoTraderTest 
{
	//WebBrowser
	private WebDriver webDriver;
		
	//Site data
	private String urlHome = "https://www.autotrader.co.uk/";

	//Reporting
	private static ExtentReports report;
	private ExtentTest test; 
	private ScreenShot screenshot = new ScreenShot();

	//Spreadsheet
	private SpreadSheetReader ssreader;
	private String registerSheet = "registeruser.xlsx";
	private String loginUser = "loginuser.xlsx";
	private String falseUser = "falseuser.xlsx";
	
	//private Actions builder;
	
	
	@BeforeClass
	public static void init()
	{
		report = new ExtentReports();
		String fileName = "AutoTrader-test" + ".html";
		String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
		report.attachReporter(new ExtentHtmlReporter(filePath));
	}
	@Before
	public void setup()
	{
		webDriver = new ChromeDriver();
	}
	
	@After
	public void tearDown()
	{
		webDriver.quit();
	}
	
	@AfterClass
	public static void destroy()
	{
		report.flush();
	}
	
	@Test
	public void signInTest1() throws Exception
	{
		ExtentTest test = report.createTest("SignInTest-1");
		test.log(Status.INFO, "Sign In Test using bad details");
		
		try 
		{
			webDriver.navigate().to(urlHome);
			
			HomePagePOM homepage = PageFactory.initElements(webDriver, HomePagePOM.class);
			homepage.getLoginBtn().click();
			
			LoginPagePOM loginpage = PageFactory.initElements(webDriver, LoginPagePOM.class);
			loginpage.getSignInTab().click();
			
			ssreader = new SpreadSheetReader(falseUser);
			
			
			loginpage.getSignInEmail().sendKeys(ssreader.readCell(1, 0, "Sheet1"));
			loginpage.getSignInPwd().sendKeys(ssreader.readCell(1, 1, "Sheet1"));
			
			loginpage.getSignInBtn().click();
			
			if(webDriver.getCurrentUrl().contains("failed"))
			{
				test.log(Status.PASS, "Unable to logon using false details");
			}
			else
			{
				test.log(Status.FAIL, "Able to logon using false details");
			}
			
		}
		catch (AssertionError ae)
		{
			test.log(Status.FAIL, "Test failed");
			test.log(Status.FAIL, ae);
			test.addScreenCaptureFromPath(screenshot.take(webDriver, "error"));
			//test.log(Status.DEBUG, screenshot.take(webDriver, "error"+uname));
			//test.log(Status.DEBUG, "Test failed - more info below:\n" + ae.getMessage());
			report.flush();
			throw ae;
		}
		catch (Exception e) 
		{
			test.log(Status.FATAL,e);
			report.flush();
			throw e;
		}
	}
	
	@Test
	public void signInTest2() throws Exception
	{
		ExtentTest test = report.createTest("SignInTest-2");
		test.log(Status.INFO, "Sign In Test using good details");
		
		try 
		{
			webDriver.navigate().to(urlHome);
			
			HomePagePOM homepage = PageFactory.initElements(webDriver, HomePagePOM.class);
			homepage.getLoginBtn().click();
			
			LoginPagePOM loginpage = PageFactory.initElements(webDriver, LoginPagePOM.class);
			loginpage.getSignInTab().click();
			
			ssreader = new SpreadSheetReader(loginUser);
			
			
			loginpage.getSignInEmail().sendKeys(ssreader.readCell(1, 0, "Sheet1"));
			loginpage.getSignInPwd().sendKeys(ssreader.readCell(1, 1, "Sheet1"));
			
			loginpage.getSignInBtn().click();
			
			if(webDriver.getCurrentUrl().contains("failed"))
			{
				test.log(Status.FAIL, "Unable to logon using correct details");
			}
			else
			{
				test.log(Status.PASS, "Able to logon using correct details");
			}
			
		}
		catch (AssertionError ae)
		{
			test.log(Status.FAIL, "Test failed");
			test.log(Status.FAIL, ae);
			test.addScreenCaptureFromPath(screenshot.take(webDriver, "error"));
			//test.log(Status.DEBUG, screenshot.take(webDriver, "error"+uname));
			//test.log(Status.DEBUG, "Test failed - more info below:\n" + ae.getMessage());
			report.flush();
			throw ae;
		}
		catch (Exception e) 
		{
			test.log(Status.FATAL,e);
			report.flush();
			throw e;
		}
	}
	
	@Test
	public void signInTest3() throws Exception
	{
		ExtentTest test = report.createTest("SignInTest-3");
		test.log(Status.INFO, "Sign In Test without password");
		
		try 
		{
			webDriver.navigate().to(urlHome);
			
			HomePagePOM homepage = PageFactory.initElements(webDriver, HomePagePOM.class);
			homepage.getLoginBtn().click();
			
			LoginPagePOM loginpage = PageFactory.initElements(webDriver, LoginPagePOM.class);
			loginpage.getSignInTab().click();
			
			ssreader = new SpreadSheetReader(loginUser);
			
			
			loginpage.getSignInEmail().sendKeys(ssreader.readCell(1, 0, "Sheet1"));
			
			loginpage.getSignInBtn().click();
			
			if(webDriver.getCurrentUrl().contains("failed"))
			{
				test.log(Status.PASS, "Unable to login using no password");
			}
			else
			{
				test.log(Status.FAIL, "Able to login using no password");
			}
			
			
			Thread.sleep(10000);
			
		}
		catch (AssertionError ae)
		{
			test.log(Status.FAIL, "Test failed");
			test.log(Status.FAIL, ae);
			test.addScreenCaptureFromPath(screenshot.take(webDriver, "error"));
			//test.log(Status.DEBUG, screenshot.take(webDriver, "error"+uname));
			//test.log(Status.DEBUG, "Test failed - more info below:\n" + ae.getMessage());
			report.flush();
			throw ae;
		}
		catch (Exception e) 
		{
			test.log(Status.FATAL,e);
			report.flush();
			throw e;
		}
	}
	
	@Test
	public void signInTest4() throws Exception
	{
		ExtentTest test = report.createTest("SignInTest-3");
		test.log(Status.INFO, "Sign In Test without email");
		
		try 
		{
			webDriver.navigate().to(urlHome);
			
			HomePagePOM homepage = PageFactory.initElements(webDriver, HomePagePOM.class);
			homepage.getLoginBtn().click();
			
			LoginPagePOM loginpage = PageFactory.initElements(webDriver, LoginPagePOM.class);
			loginpage.getSignInTab().click();
			
			ssreader = new SpreadSheetReader(loginUser);
			
			loginpage.getSignInPwd().sendKeys(ssreader.readCell(1, 1, "Sheet1"));
			
			loginpage.getSignInBtn().click();
			
			if(webDriver.getCurrentUrl().contains("failed"))
			{
				test.log(Status.PASS, "Unable to login using no username");
			}
			else
			{
				test.log(Status.FAIL, "Able to login using no username");
			}
			
		}
		catch (AssertionError ae)
		{
			test.log(Status.FAIL, "Test failed");
			test.log(Status.FAIL, ae);
			test.addScreenCaptureFromPath(screenshot.take(webDriver, "error"));
			//test.log(Status.DEBUG, screenshot.take(webDriver, "error"+uname));
			//test.log(Status.DEBUG, "Test failed - more info below:\n" + ae.getMessage());
			report.flush();
			throw ae;
		}
		catch (Exception e) 
		{
			test.log(Status.FATAL,e);
			report.flush();
			throw e;
		}
	}
	
}
