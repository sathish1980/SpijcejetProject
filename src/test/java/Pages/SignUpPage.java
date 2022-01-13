package Pages;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonMethods.ReusableComponenets;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class SignUpPage extends ReusableComponenets
{
	
	@FindBy(xpath="(//div[@data-testid='application-id']//div)[43]")
	WebElement page_Title;
	@FindBy(xpath="((//div[text()='Title']//parent::div)[1]//div)[3]")
	WebElement titleClick;
	@FindBy(xpath="//div[text()='Mrs']")
	WebElement valueClickInList;
	@FindBy(xpath="(//div[text()='First and Middle Name']//following::input)[1]")
	WebElement fname;

	
	WebDriver driver;
	
	public SignUpPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public String pageTitle()
	{
		Fluentwaitforelementobevisible(driver, page_Title);
		//WebElement pageTitle= driver.findElement(By.xpath("(//div[@data-testid='application-id']//div)[43]"));
		return returnText(page_Title);
	}
	
	public void titleSelection()
	{
		//WebElement titleClick=driver.findElement(By.xpath("((//div[text()='Title']//parent::div)[1]//div)[3]"));
		waitforelementobeclick(driver, titleClick);
		click(titleClick);
		//WebElement valueClickInList=driver.findElement(By.xpath("//div[text()='Mrs']"));
		click(valueClickInList);
		
	}
	
	public void firstname(String F_name)
	{
		
		//WebElement fname=driver.findElement(By.xpath("(//div[text()='First and Middle Name']//following::input)[1]"));
		Tab_ACtions(driver,fname);
		sendKeys(fname,F_name);
		
		
	}
	
	public void lastname(String L_Name)
	{
		WebElement lname=driver.findElement(By.xpath("(//div[text()='Last Name']//following::input)[1]"));
		Tab_ACtions(driver,lname);
		sendKeys(lname,L_Name);
		
		
	}
	
	public void contactNumber(String CT_Number)
	{
		WebElement ctNumber=driver.findElement(By.xpath("(//div[text()='Contact Number']//following::input)[1]"));
		Tab_ACtions(driver,ctNumber);
		sendKeys(ctNumber,CT_Number);
		
	}
	
	public void passsword(String Pass)
	{
		WebElement pwrd=driver.findElement(By.xpath("(//div[text()='Password']//following::input)[1]"));
		Tab_ACtions(driver,pwrd);
		sendKeys(pwrd,Pass);
		
	}
	
	public void Confirmpasssword(String C_Pass)
	{
		WebElement cpwrd=driver.findElement(By.xpath("(//div[text()='Confirm Password']//following::input)[1]"));
		Tab_ACtions(driver,cpwrd);
		sendKeys(cpwrd,C_Pass);
		
	}
	
	public void emailId(String Email_id)
	{
		WebElement eid=driver.findElement(By.xpath("(//div[text()='Email Address']//following::input)[1]"));
		Tab_ACtions(driver,eid);
		sendKeys(eid,Email_id);
		
	}
	
	public void DOB(String Data)
	{
		
		String[] splitDate=Data.split("/");
		int expectedyear=Integer.parseInt(splitDate[2]);
		String expectedmonth=splitDate[1];
		int expecteddate=Integer.parseInt(splitDate[0]);
		
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
		//Fluentwaitforelementobeclickable(driver,driver.findElement(By.xpath("(//*[name()='rect'])[1]")));
		WebElement valueClickInList=driver.findElement(By.xpath("(//*[name()='rect'])[1]"));
		checkBoxclick(valueClickInList);
	}
	
	public String greaterTheneighteen()
	{
		Fluentwaitforelementobevisible(driver,driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div[5]/div/div[4]")));
		WebElement errorMessageWebelement=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div[5]/div/div[4]"));
		String erMessage= errorMessageWebelement.getText();
		return erMessage;
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
