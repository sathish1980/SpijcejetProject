package Pages;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CommonMethods.ReusableComponenets;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class SignUpPage extends ReusableComponenets
{
	
	//((//div[text()='Title']//parent::div)[1]//child::div[2]//div)[1]
	
	WebDriver driver;
	
	public SignUpPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String pageTitle()
	{
		Fluentwaitforelementobevisible(driver, driver.findElement(By.xpath("(//div[@data-testid='application-id']//div)[43]")));
		WebElement pageTitle= driver.findElement(By.xpath("(//div[@data-testid='application-id']//div)[43]"));
		return returnText(pageTitle);
	}
	
	public void titleSelection()
	{
		WebElement titleClick=driver.findElement(By.xpath("((//div[text()='Title']//parent::div)[1]//div)[3]"));
		waitforelementobeclick(driver, titleClick);
		click(titleClick);
		WebElement valueClickInList=driver.findElement(By.xpath("//div[text()='Mrs']"));
		click(valueClickInList);
	}
	
	public void firstname()
	{
		WebElement fname=driver.findElement(By.xpath("(//div[text()='First and Middle Name']//following::input)[1]"));
		sendKeys(fname,"sathish");
		
	}
	
	public void lastname()
	{
		WebElement lname=driver.findElement(By.xpath("(//div[text()='Last Name']//following::input)[1]"));
		sendKeys(lname,"kumar");
		
	}
	
	public void contactNumber()
	{
		WebElement ctNumber=driver.findElement(By.xpath("(//div[text()='Contact Number']//following::input)[1]"));
		sendKeys(ctNumber,"9159211184");
		
	}
	
	public void passsword()
	{
		WebElement pwrd=driver.findElement(By.xpath("(//div[text()='Password']//following::input)[1]"));
		sendKeys(pwrd,"Admin@123");
		
	}
	
	public void Confirmpasssword()
	{
		WebElement cpwrd=driver.findElement(By.xpath("(//div[text()='Confirm Password']//following::input)[1]"));
		sendKeys(cpwrd,"Admin@123");
		
	}
	
	public void emailId()
	{
		WebElement eid=driver.findElement(By.xpath("(//div[text()='Email Address']//following::input)[1]"));
		sendKeys(eid,"kumar.sathish189@gmail.com");
		
	}
	
	public void DOB(int expectedyear,String expectedmonth,int expecteddate)
	{
		WebElement eid=driver.findElement(By.xpath("(//div[text()='Date of Birth']//following::input)[1]"));
		//sendKeys(eid,"11/05/1990");
		click(eid);
		String actualmonth;
		

		WebElement Year =driver.findElement(By.xpath("((//div[text()='SUN']//ancestor::div)[15]//div)[7]")); 
		
		int actualyear=Integer.parseInt(Year.getText());
			 
			WebElement Month =driver.findElement(By.xpath("((//div[text()='SUN']//ancestor::div)[15]//div)[5]")); 
			WebElement Next =driver.findElement(By.xpath("((//div[text()='SUN']//ancestor::div)[15]//div)[8]")); 
			WebElement Previous =driver.findElement(By.xpath("((//div[text()='SUN']//ancestor::div)[15]//div)[2]"));
		if	(expectedyear==actualyear && Month.getText()== expectedmonth)
		{
			
		}
		else if(expectedyear<actualyear)
		{
			
		do
		{
		click(Previous);
		Year =driver.findElement(By.xpath("((//div[text()='SUN']//ancestor::div)[15]//div)[7]")); 
		actualyear=Integer.parseInt(Year.getText());
		Month =driver.findElement(By.xpath("((//div[text()='SUN']//ancestor::div)[15]//div)[5]")); 
		actualmonth=Month.getText().trim();
		if((expectedyear==actualyear)&&actualmonth.equals(expectedmonth))
		{
		break;
		}
		}
		while(expectedyear<=actualyear || actualmonth.equals(expectedmonth))	;
		}
		else if(expectedyear>actualyear)
		{
			do
			{
			click(Next);
			Year =driver.findElement(By.xpath("((//div[text()='SUN']//ancestor::div)[15]//div)[7]")); 
			actualyear=Integer.parseInt(Year.getText());
			System.out.println(actualyear);
			Month =driver.findElement(By.xpath("((//div[text()='SUN']//ancestor::div)[15]//div)[5]")); 
			actualmonth=Month.getText().trim();
			if((expectedyear==actualyear)&&actualmonth.equals(expectedmonth))
			{
			break;
			}
			}
			while(expectedyear>=actualyear || actualmonth.equals(expectedmonth))	;
		}
		
		
		List<WebElement> totalRow = driver.findElements(By.xpath("((//div[text()='SUN']//ancestor::div)[15]//div)[19]//div[@tabindex=0]"));
		int siz=totalRow.size();
		
		for(int i=1;i<siz;i++)
		{
			String date=driver.findElement(By.xpath("((//div[text()='SUN']//ancestor::div)[15]//div)[19]//div[@tabindex=0]["+i+"]//div")).getText();
			
			if (Integer.parseInt(date)==expecteddate)
			{
				driver.findElement(By.xpath("((//div[text()='SUN']//ancestor::div)[15]//div)[19]//div[@tabindex=0]["+i+"]")).click();
				break;
				
			}
		}
	}
	
	public void agreeCheckbox()
	{
		waitforelementobeclick(driver,driver.findElement(By.xpath("(//*[name()='rect'])[1]")));
		
		WebElement valueClickInList=driver.findElement(By.xpath("(//*[name()='rect'])[1]"));
		click(valueClickInList);
	}
	
	public void chatboxclick()
	{
		
		List<WebElement > framevalue=driver.findElements(By.tagName("iframe"));
		int sizf=framevalue.size();
		for(int i=0;i<sizf;i++)
		{
		
		driver.switchTo().frame(i);
		List<WebElement > elementtobecheck=driver.findElements(By.xpath("(//div[@id='app-LandbotLauncher']//div)[4]"));
		int elementsiz=elementtobecheck.size();
		if(elementsiz>0)
		{
		
		WebElement chtbox=driver.findElement(By.xpath("(//div[@id='app-LandbotLauncher']//div)[4]"));
		click(chtbox);
		waitforelementobeclick(driver,driver.findElement(By.xpath("//*[name()='svg' and @class='LandbotLauncherContent__bubble__svg']")));
		WebElement close= driver.findElement(By.xpath("//*[name()='svg' and @class='LandbotLauncherContent__bubble__svg']"));
		click(close);
		driver.switchTo().defaultContent();
		break;
		}
		driver.switchTo().defaultContent();
		}
	}
	
}
