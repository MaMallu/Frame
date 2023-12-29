package com.orange.Tests;

import org.testng.annotations.Test;

import com.orange.generics.ExcelDataGoogle;
import com.orange.page.LoginPage;

public class InvalidLoginTest extends BaseTest
{
	
	@Test
	public void testInvalidLogin()
	{
		LoginPage loginpage=new LoginPage(driver);
		
		String loginTitle=ExcelDataGoogle.getData(FILE_PATH, "Sheet1", 0, 1);
		
		String errorMessage =ExcelDataGoogle.getData(FILE_PATH, "Sheet1", 1, 2);
		
		int rowCount =ExcelDataGoogle.getRowCount(FILE_PATH, "Sheet1");
		
		loginpage.verifyTheTitle(loginTitle);
		
		for(int i=1;i<=rowCount;i++)
		{
			String username=ExcelDataGoogle.getData(FILE_PATH,"Sheet1", i, 0);
			String password=ExcelDataGoogle.getData(FILE_PATH,"Sheet1", i, 1);
			
			//enter the user name
			loginpage.enterUseerName(username);
			//enter the password
			loginpage.enterPassword(password);
			//click on login button
			loginpage.clickOnLoginBTN();
			
			
			//vverify the error messgae
			loginpage.verifyerrorMessage(errorMessage);
			System.out.println(" ==================");
			
		}
		
	}
}
