package Baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Util.PropoertyFile;



public class DriverClass
{
	PropoertyFile P = new PropoertyFile();
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	static String reportpath= System.getProperty("user.dir")+"\\Reports\\";
	
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

	public void browserlaunch()
	{
		String browser= P.propreaddata().getProperty("Browser");
	
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_latest\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		driver= new ChromeDriver(c);
		driver.manage().window().maximize();
		
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "D:\\Software\\edgedriver_win64\\msedgedriver.exe");
			driver= new EdgeDriver();
		}
		extreport();
}
	
	public void urlLaunch()
	{
		String url= P.propreaddata().getProperty("URL");
		driver.get(url);
		
	}
}
