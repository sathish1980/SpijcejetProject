package Testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import Baseclass.DriverClass;
import CommonMethods.ReusableComponenets;
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
		try
		{
			
		SignUpPage s = new SignUpPage(driver);
		String ActualText=s.pageTitle();
		String ExpectedText="Member Enrollment";
		Assert.assertEquals(ExpectedText, ActualText);
		s.titleSelection();
		s.firstname();
		test.log(LogStatus.INFO,"firstname entered");
		s.lastname();
		s.chatboxclick();
		test.log(LogStatus.INFO,"laster entered");
		s.DOB(1990,"May",11);
		test.log(LogStatus.INFO,"DOB entered");
		s.contactNumber();
		test.log(LogStatus.INFO,"contact number entered");
		s.passsword();
		test.log(LogStatus.INFO,"password entered");
		s.Confirmpasssword();
		test.log(LogStatus.INFO,"confirm password entered");
		s.emailId();
		test.log(LogStatus.INFO,"emailid  entered");
		
		s.agreeCheckbox();
		test.log(LogStatus.INFO,"checkbox clicked");
		test.log(LogStatus.PASS, "Mandatory values are enetered sucessfully");
		}
		catch(Exception E)
		{
			String scren = ReusableComponenets.takescreenshot(driver);
			test.log(LogStatus.FAIL, E);
			test.log(LogStatus.FAIL, test.addScreenCapture(scren));
			System.out.println(E);
		}
		
	}
	
	@AfterSuite
	public void teardown()
	{
		driver.quit();
		reportclose();
	}
}
