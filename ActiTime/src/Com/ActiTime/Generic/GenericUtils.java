package Com.ActiTime.Generic;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class GenericUtils 
{
	public static void getScreenShot(WebDriver driver ,String name)
	{
		TakesScreenshot ts =(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(src, new File("./ScreenShot/"+name+".png"));
		} 
		catch (IOException e)
		{
		}
	}
	
	public static void selectByIndex(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public static void selectByValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	public static void selectByVisibleText(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	public static void getAllOptionListBox(WebElement element)
	{
		Select sel = new Select(element);
		List<WebElement> allopt = sel.getOptions();
		int count = allopt.size();
		Reporter.log("List Box size"+count,true);
		for(int i=0; i<count; i++) 
		{
			WebElement opt = allopt.get(i);
			String text = opt.getText();
			Reporter.log("List Box Options"+text,true);
			
		}
	}
	public static void javaScriptPopupClickOnOkButton(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	public static void javaScriptPopupClickOnCancelButton(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
		
	}
	public static void javaScriptPopupEnterText(WebDriver driver,String text)
	{
		Alert a = driver.switchTo().alert();
		a.sendKeys(text);
		try 
		{
			Thread.sleep(2000);
			a.accept();
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void windowPopup(String path)
	{
		try {
			Runtime.getRuntime().exec(path);
		} catch (IOException e) {
		}
		
	}
}
