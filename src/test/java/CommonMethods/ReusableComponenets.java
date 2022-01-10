package CommonMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

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
	
	public void Fluentwaitforelementobevisible(WebDriver driver, WebElement elementToWait)
	{
		FluentWait wait1 = new FluentWait(driver);
		wait1.withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);
		wait1.until(ExpectedConditions.visibilityOfAllElements(elementToWait));
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
	
	public void sendKeys(WebElement elementoenter,String chartoeneter)
	{
		if(elementoenter.isDisplayed()==true &&elementoenter.isEnabled()==true)
		{
			elementoenter.clear();
			elementoenter.sendKeys(chartoeneter);
		}
		
	}
	
	public static String takescreenshot(WebDriver driver)
	{
		Date date = new Date();
	      //This method returns the time in millis
	    long timeMilli = date.getTime();
		String date_v= String.valueOf(timeMilli);
		//System.out.println(date_v);
		TakesScreenshot ts =(TakesScreenshot)driver;
		File sourcefile= ts.getScreenshotAs(OutputType.FILE);
		File Destinationfile= new File(System.getProperty("user.dir")+"//Screenshot//Testcase_1_"+date_v+".png");
		try {
			FileUtils.copyFile(sourcefile, Destinationfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Destinationfile.toString();
	}
}
