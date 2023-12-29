package com.orange.Tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orange.generics.ExcelDataGoogle;
import com.orange.page.LoginPage;

public class DataValidLoginTest extends BaseTest
{
	
	
	@Test(dataProvider="test1data")
	public void testValidLoginLoginLogout(String username,String password)
	{
		LoginPage loginpage=new LoginPage(driver);
//		String username=ExcelDataGoogle.getData(FILE_PATH, "Sheet1", 1, 0);
//		String password=ExcelDataGoogle.getData(FILE_PATH, "Sheet1", 1, 1);
//		
		//enter the valid user name
		loginpage.enterUseerName(username);
		
		//enter the valid password
		loginpage.enterPassword(password);
		
		//clik on the login button
		loginpage.clickOnLoginBTN();
	}
	
	@DataProvider(name="test1data")
	public Object[][] getData()
	{
		Object [][]data=multipleDataProvider();
		return data;
	}

	public Object[][] multipleDataProvider()
	{
		ExcelDataGoogle excel=new ExcelDataGoogle();
		int rowCount=ExcelDataGoogle.getRowCount(FILE_PATH, "Sheet1");
		System.out.println("row count is"+rowCount);
		int cellCount=ExcelDataGoogle.getCellCount(FILE_PATH, "Sheet1", 0);
		System.out.println("cell count is:"+cellCount);
		
		Object data[][]=new Object[rowCount-1][cellCount];
		
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				String cellStringdata=excel.getData(FILE_PATH, "Sheet1", i, j);
				//System.out.println("cell string data is"+cellStringdata);
				data[i-1][j]=cellStringdata;
			}
		}
		return data;
	}

}
