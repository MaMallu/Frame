package com.orange.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchHomePage extends BasePage
{
	
	//decalations
	public static WebDriver driver;
	
	By text_box=By.name("q");
	
	
	//initalztaion
	public GoogleSearchHomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	//utilzation
	public void enterTextInTextBox(String searchText)
	{
		WebElement searchElement=driver.findElement(text_box);
		searchElement.clear();
		searchElement.sendKeys(searchText);
	}
 


}
