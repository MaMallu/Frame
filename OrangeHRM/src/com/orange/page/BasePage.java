package com.orange.page;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage 
{
	public WebDriver driver;
	
	//create constructor  to provide implemenation in the next level class
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//to verify the title
	public void verifyTitle(String expectedTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String actualTitle=driver.getTitle();
		try
		{
		wait.until(ExpectedConditions.titleIs(expectedTitle));
		System.out.println("Expected Title is :"+expectedTitle);
		
		}
		catch(Exception exp)
		{
			System.out.println("Expected Title is not matching,,So the current Title of the webPage is :::"+actualTitle);
			Assert.fail();

			
		}
	}
	
	//to verify the error Message
	public void verifyElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		 try
			{
				wait.until(ExpectedConditions.visibilityOf(element));
				System.out.println("Element is present::");
			}
		 catch(Exception exp)
		 {
			 System.out.println("Element is NOT present");
			 Assert.fail();
			
			
		}
	}
	
}
