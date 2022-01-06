package CommonMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableComponenets 
{

	public String returnText(WebElement elementtoGet)
	{
		return elementtoGet.getText();
	}
	
	public void waitforelementobevisible(WebDriver driver, WebElement elementToWait)
	{
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfAllElements(elementToWait));
	}
	
	public void waitforelementobeclick(WebDriver driver, WebElement elementToWait)
	{
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(elementToWait));
	}
	
	public void click(WebElement elementoClick)
	{
		if(elementoClick.isDisplayed()==true &&elementoClick.isEnabled()==true)
		{
			elementoClick.click();
		}
		
	}
}
