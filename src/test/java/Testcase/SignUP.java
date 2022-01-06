package Testcase;

import org.testng.annotations.*;

import Baseclass.DriverClass;
import Pages.SignUpPage;
import junit.framework.Assert;

public class SignUP extends DriverClass
{

	@BeforeSuite
	public void launch()
	{
		browserlaunch();
		urlLaunch();
	}
	
	@Test
	public void signinwithvalidvalues()
	{
		SignUpPage s = new SignUpPage(driver);
		String ActualText=s.pageTitle();
		String ExpectedText="Member Enrollment";
		Assert.assertEquals(ExpectedText, ActualText);
		s.titleSelection();
		
	}
	
	@AfterSuite
	public void teardown()
	{
		driver.quit();
	}
}
