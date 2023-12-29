package com.orange.generics;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelDataGoogle 
{


	public static String file;
	public static String getData(String filepath,String sheetName,int rowN,int colN)
	{
		//to get the dada from excell
		try
		{
			FileInputStream fis=new FileInputStream(filepath);
			Workbook wb=WorkbookFactory.create(fis);
			Row row=wb.getSheet(sheetName).getRow(rowN);
			String data=row.getCell(colN).getStringCellValue();
			return data;
				
		}
		catch(Exception e)
		{
			return "";
			
		}
	}
		//get the number of row count in excellsheet
		public static int getRowCount(String filepath, String sheetName)
		{
			try
			{
				FileInputStream fis=new FileInputStream(filepath);
				Workbook wb=WorkbookFactory.create(fis);
				Sheet sh=wb.getSheet(sheetName);
				return sh.getLastRowNum();
				
				
			}
			catch(Exception e)
			{
				return -1;
			}
		}
		
		//get the number of row count in excellsheet
		public static int getCellCount(String filepath,String sheetName,int rowN)
		{
			try
			{
				FileInputStream fis=new FileInputStream(filepath);
				Workbook wb=WorkbookFactory.create(fis);
				Row row=wb.getSheet(sheetName).getRow(rowN);
				return row.getLastCellNum();	
				
			}
			catch(Exception e)
			{
				return -1;
			}
		}
		public static void load(String dataFile) {
			// TODO Auto-generated method stub
			
		}

	
}
