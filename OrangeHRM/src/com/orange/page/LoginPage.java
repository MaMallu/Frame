package com.orange.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
public class LoginPage extends BasePage
{
	public WebDriver driver;
	
	//Declaration
	
	@FindBy(name="username")
	private WebElement usernameTB;
	
	@FindBy(name="password")
	private WebElement passwordTB;
	
	@FindBy(xpath="//button[contains(@type,'submit')]")
	private WebElement loginBTN;
	
	@FindBy(xpath="//button[contains(@type,'submit')]")
	private WebElement errorMessage;

	//initaliztaion
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	//enter user name
	public void enterUseerName(String userName)
	{
		usernameTB.sendKeys(userName);
	}
	
	//enter password
	public void  enterPassword(String password)
	{
		passwordTB.sendKeys(password);
	}
	
	//click login button
	public void clickOnLoginBTN()
	{
		loginBTN.click();
	}
	
	//verify the Title
	public void verifyTheTitle(String expectedTitle)
	{
		verifyTitle(expectedTitle);

		
	}
	
	//vrify the error message
	public void verifyerrorMessage(String expecetedErrorMessage)
	{
	
		verifyElement(errorMessage);
		String actualErrorMessage=errorMessage.getText();
		System.out.println("Actual error Message is :"+actualErrorMessage);
		System.out.println("Expected error message is "+expecetedErrorMessage);
		Assert.assertEquals(actualErrorMessage, expecetedErrorMessage);
		System.out.println("Error message is displayed as expeceted");
	}
}
