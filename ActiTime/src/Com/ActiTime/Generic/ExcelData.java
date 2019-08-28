package Com.ActiTime.Generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData
{
	public static String getData(String file_path,String Sheet_name, int rn, int cn)
	{
		try
		{
			FileInputStream file = new FileInputStream(new File(file_path));
			String data = WorkbookFactory.create(file).getSheet(Sheet_name).getRow(rn).getCell(cn).toString();
			return data;
		} 
		catch (Exception e) 
		{
			return "";
		}
	}
	public static int getRowCount(String file_path,String sheetName)
	{
		try {
			FileInputStream file = new FileInputStream(new File(file_path));
			int rc = WorkbookFactory.create(file).getSheet(sheetName).getLastRowNum();
			return rc ;
		} catch (Exception e)
		{
			return 0;
		}
		
	}
	public int getCellCount(String file_path,String sheetName,int rn)
	{
		
		try {
			FileInputStream file = new FileInputStream(new File(file_path));
			int cc = WorkbookFactory.create(file).getSheet(sheetName).getRow(rn).getLastCellNum();
			return cc;
		} catch (Exception e)
		{
			return 0;
		}
	}

}
