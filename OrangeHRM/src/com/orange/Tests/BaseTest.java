package com.orange.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

abstract public class BaseTest implements AutoConstants 
{
	public WebDriver driver;
	
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	//preCOndtions//setting up the property file .path of propert file,launch driver
	@BeforeMethod
	public void preConditions()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
	}
	
	//postConditions
	@AfterMethod
	public void postCondtions()//pass "ITestResult res"
	{
		System.out.println("hi");
		
		SoftAssert softassert = new SoftAssert();
		softassert.fail();
		System.out.println("mallumani");
		driver.close();
		
		softassert.assertAll();
	}

}
