package Baseclass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Util.PropoertyFile;


public class DriverClass
{
	PropoertyFile P = new PropoertyFile();
	//public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	static String reportpath= System.getProperty("user.dir")+"\\Reports\\";

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static void extreport()
	{
		report = new ExtentReports(reportpath+"extenreport.html",true);
		test= report.startTest("Extent report");
		
	}
	
	public static void reportclose()
	{
		//test.close();
		report.flush();
		
	}
	// Parallel execution
	public void setdriver(WebDriver driver)
	{
		this.driver.set(driver);
	}
	
	public WebDriver getdriver()
	{
		return this.driver.get();
	}

	public void browserlaunch(String browser)
	{
		//String browser= P.propreaddata().getProperty("Browser");
	
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		c.addArguments("--incognito");
		   c.addArguments("--ignore-certificate-errors");
		   c.addArguments("--verbose");
		   setdriver(new ChromeDriver(c));
			getdriver().manage().window().maximize();
			
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "D:\\Software\\edgedriver_win64\\msedgedriver.exe");
			setdriver( new EdgeDriver());
		
		}
		extreport();
}
	
	public void urlLaunch()
	{
		//getdriver().manage().window().maximize();
		String url= P.propreaddata().getProperty("URL");
		getdriver().get(url);
		
	}
	
	@Parameters("browser")
	@BeforeTest
	public void launch(String browser)
	{
		browserlaunch(browser);
		urlLaunch();
	}
	
	@AfterTest
	public void teardown()
	{
		getdriver().quit();
		
	}
	
	@AfterSuite
	public void aftersuite()
	{
		report.flush();
		
	}
}
