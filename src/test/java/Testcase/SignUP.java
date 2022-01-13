package Testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import Baseclass.DriverClass;
import CommonMethods.ReusableComponenets;
import Pages.SignUpPage;
import Util.ExcelRead;
import junit.framework.Assert;

public class SignUP extends DriverClass
{
	int count=0;

	@BeforeSuite
	public void launch()
	{
		browserlaunch();
		urlLaunch();
	}
	
	@Test(priority=0,dataProvider="Signupuser")
	public void signinwithvalidvalues(String u_name,String L_name,String Date,String M_Number,String Pass_D,String C_Pass_D,String E_mail_ID)
	{
		try
		{
		
		SignUpPage s = new SignUpPage(driver);
		String ActualText=s.pageTitle();
		String ExpectedText="Member Enrollment";
		Assert.assertEquals(ExpectedText, ActualText);
		Thread.sleep(2000);
		s.titleSelection();
		s.firstname(u_name);
		Thread.sleep(2000);
		//s.firstname(u_name);
		test.log(LogStatus.INFO,"firstname entered");
		s.lastname(L_name);
		if(count<1)
		{
		s.chatboxclick();
		}
		test.log(LogStatus.INFO,"laster entered");
		s.DOB(Date);
		test.log(LogStatus.INFO,"DOB entered");
		s.contactNumber(M_Number);
		test.log(LogStatus.INFO,"contact number entered");
		s.passsword(Pass_D);
		test.log(LogStatus.INFO,"password entered");
		s.Confirmpasssword(C_Pass_D);
		test.log(LogStatus.INFO,"confirm password entered");
		s.emailId(E_mail_ID);
		test.log(LogStatus.INFO,"emailid  entered");
		s.agreeCheckbox();
		test.log(LogStatus.INFO,"checkbox clicked");
		String scren = ReusableComponenets.takescreenshot(driver);
		test.log(LogStatus.PASS, "Mandatory values are enetered sucessfully",test.addScreenCapture(scren));
		count= count+1;
		}
		catch(Exception E)
		{
			String scren = ReusableComponenets.takescreenshot(driver);
			test.log(LogStatus.FAIL, E);
			test.log(LogStatus.FAIL, test.addScreenCapture(scren));
			System.out.println(E);
		}
		
	}
	
	
	
	@Test(priority=1,dataProvider="Signupgreater18")
	public void signinwithgreaterthan18years(String u_name,String L_name,String Date,String M_Number,String Pass_D,String C_Pass_D,String E_mail_ID)
	{
		try
		{
		
		SignUpPage s = new SignUpPage(driver);
		String ActualText=s.pageTitle();
		String ExpectedText="Member Enrollment";
		Assert.assertEquals(ExpectedText, ActualText);
		Thread.sleep(2000);
		s.titleSelection();
		s.firstname(u_name);
		Thread.sleep(2000);
		//s.firstname(u_name);
		test.log(LogStatus.INFO,"firstname entered");
		s.lastname(L_name);
		if(count<1)
		{
		s.chatboxclick();
		}
		test.log(LogStatus.INFO,"laster entered");
		s.DOB(Date);
		
		test.log(LogStatus.INFO,"DOB entered");
		Assert.assertEquals(s.greaterTheneighteen(),"Age should be more than 18 year");
		//s.contactNumber(M_Number);
		String scren = ReusableComponenets.takescreenshot(driver);
		test.log(LogStatus.PASS, "Mandatory values are enetered sucessfully",test.addScreenCapture(scren));
		count= count+1;
		}
		catch(Exception E)
		{
			String scren = ReusableComponenets.takescreenshot(driver);
			test.log(LogStatus.FAIL, E);
			test.log(LogStatus.FAIL, test.addScreenCapture(scren));
			System.out.println(E);
		}
		
	}
	
	
	
	@DataProvider(name = "Signupuser")
	public Object[][] exceldata() throws IOException
	{
		return ExcelRead.read("username");
	}
	
	@DataProvider(name = "Signupgreater18")
	public Object[][] Signupgreatereighteen() throws IOException
	{
		return ExcelRead.read("invaliddatavalidation");
	}
	
	@AfterSuite
	public void teardown()
	{
		driver.quit();
		report.flush();
	}
}
