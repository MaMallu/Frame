package com.orange.Tests;

import org.testng.annotations.Test;

import com.orange.generics.ExcelDataGoogle;
import com.orange.page.LoginPage;

public class ValidLoginTest extends BaseTest
{
	
	@Test
	public void testValidLoginLoginLogout() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		//GoogleSearchHomePage googl=new GoogleSearchHomePage (driver);
		
		String errorMessage=ExcelDataGoogle.getData(FILE_PATH, "Sheet3", 1, 2);
		int rowCount=ExcelDataGoogle.getRowCount(FILE_PATH, "Sheet3");
		 
		String expecteTitle=ExcelDataGoogle.getData(FILE_PATH, "Sheet3", 1, 3);
		
		System.out.println("Row count is="+rowCount);
		
		for(int i=1;i<rowCount;i++)
		{
			int cellCount=ExcelDataGoogle.getCellCount(FILE_PATH, "Sheet3", i);
			
			for(int j=1;j<cellCount;j++)
			{
				String username=ExcelDataGoogle.getData(FILE_PATH, "Sheet3", i, j);
				String password=ExcelDataGoogle.getData(FILE_PATH, "Sheet3", i, j);
				//enter the valid user name
				loginpage.enterUseerName(username);
				
				//enter the valid password
				loginpage.enterPassword(password);
				
				//clik on the login button
				loginpage.clickOnLoginBTN();
				Thread.sleep(3000);
				
				//veify the title
				loginpage.verifyTheTitle(expecteTitle);
				
				//verify error message
				loginpage.verifyerrorMessage(errorMessage);
				System.out.println("=============");
				
				
				//google search text
				//googl.enterTextInTextBox(errorMessage);
			}

		}

	}
}
