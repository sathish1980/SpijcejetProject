package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CommonMethods.ReusableComponenets;

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
		
		WebElement pageTitle= driver.findElement(By.xpath("(//div[@data-testid='application-id']//div)[43]"));
		waitforelementobevisible(driver, pageTitle);
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

}
