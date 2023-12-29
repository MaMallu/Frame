package com.orange.generics;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

import java.io.*;

public class GenericUtils 
{
	public WebDriver driver;
	
	public void getScreenShot(String name)
	{
		try
		{
			TakesScreenshot takescreenshot=(TakesScreenshot)driver;
			File source=takescreenshot.getScreenshotAs(OutputType.FILE);
			File destin=new File("C:\\Users\\Mallukinnis\\eclipse-workspace\\SeleniumPractice\\OrangeHRM\\screenshot"+name+".png");
			FileUtils.copyFile(source, destin);
		}
		catch(Exception exp)
		{
			System.out.println();
		}
	}
		public static void selectByIndex(WebElement element,int index )
		{
			Select sele =new Select(element);
			
			sele.selectByIndex(index);

		}
		
		public static void selectByValue(WebElement element,String value)
		{
			Select sele=new Select(element);
			
			sele.selectByValue(value);	
		}
		
		public static void selectByVisisbleText(WebElement element,String visibleText) 
		{
			Select sele=new Select(element);
			
			sele.selectByVisibleText(visibleText);
		}
		
}

