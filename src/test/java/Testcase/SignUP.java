package Testcase;

import java.io.IOException;
import java.lang.reflect.Method;

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
	int tccount=0;

	
	//@BeforeClass
	public void signupclick()
	{
		SignUpPage sup= new SignUpPage(getdriver());
		//sup.signuplink();
	}
	
	@Test(priority=3,dataProvider="Signupuser",dataProviderClass=DataProviderclass.class)
	public void signinwithvalidvalues(String u_name,String L_name,String Date,String M_Number,String Pass_D,String C_Pass_D,String E_mail_ID)
	{
		try
		{
		
		SignUpPage s = new SignUpPage(getdriver());
		s.signuplink();
		String ActualText=s.pageTitle("Member Enrollment");
		String ExpectedText="Member Enrollment";
		Assert.assertEquals(ExpectedText, ActualText);
		Thread.sleep(2000);
		s.titleSelection();
		s.firstname(u_name);
		Thread.sleep(2000);
		//s.firstname(u_name);
		test.log(LogStatus.INFO,"firstname entered");
		s.lastname(L_name);
		/*if(count<1)
		{
		s.chatboxclick();
		}*/
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
		String scren = ReusableComponenets.takescreenshot(getdriver());
		test.log(LogStatus.PASS, "Mandatory values are enetered sucessfully",test.addScreenCapture(scren));
		count= count+1;
		getdriver().navigate().back();
		}
		catch(Exception E)
		{
			String scren = ReusableComponenets.takescreenshot(getdriver());
			test.log(LogStatus.FAIL, E);
			test.log(LogStatus.FAIL, test.addScreenCapture(scren));
			System.out.println(E);
		}
		
	}
	
	
	
	@Test(priority=2,dataProvider="Signupgreater18",dataProviderClass=DataProviderclass.class)
	public void signinwithgreaterthan18years(String u_name,String L_name,String Date,String M_Number,String Pass_D,String C_Pass_D,String E_mail_ID)
	{
		try
		{
		
		SignUpPage s = new SignUpPage(getdriver());
		s.signuplink();
		String ActualText=s.pageTitle("Member Enrollment");
		String ExpectedText="Member Enrollment";
		Assert.assertEquals(ExpectedText, ActualText);
		Thread.sleep(2000);
		s.titleSelection();
		s.firstname(u_name);
		Thread.sleep(2000);
		//s.firstname(u_name);
		test.log(LogStatus.INFO,"firstname entered as : "+u_name);
		s.lastname(L_name);
		/*if(count<1)
		{
		s.chatboxclick();
		}*/
		test.log(LogStatus.INFO,"laster entered as : "+L_name);
		s.DOB(Date);
		test.log(LogStatus.INFO,"DOB entered : " +Date);
		test.log(LogStatus.INFO, s.greaterTheneighteen());
		Assert.assertEquals(s.greaterTheneighteen(),"Age should be more than 18 years");
		//s.contactNumber(M_Number);
		String scren = ReusableComponenets.takescreenshot(getdriver());
		test.log(LogStatus.PASS, "Mandatory values are enetered sucessfully",test.addScreenCapture(scren));
		count= count+1;
		getdriver().navigate().back();
		}
		catch(Exception E)
		{
			String scren = ReusableComponenets.takescreenshot(getdriver());
			test.log(LogStatus.FAIL, E);
			test.log(LogStatus.FAIL, test.addScreenCapture(scren));
			System.out.println(E);
		}
		
	}
	

	
	@BeforeMethod
	public void setup(Method method) 
	{
		
		tccount=tccount+1;
	    String testMethodName = method.getName(); //This will be:verifySaveButtonEnabled
	    String descriptiveTestName = method.getAnnotation(Test.class).testName(); //This will be: 'Verify if the save button is enabled'
	    test = report.startTest(this.getClass().getName()+" Testcase " +tccount);
	}
	

	
	
}
