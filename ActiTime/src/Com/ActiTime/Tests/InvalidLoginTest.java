package Com.ActiTime.Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Com.ActiTime.Generic.BaseTest;
import Com.ActiTime.Generic.ExcelData;
import Com.ActiTime.Pages.actiTIMELoginPage;

public class InvalidLoginTest extends BaseTest
{
	@Test(priority=2)
	public void InvalidLogin() throws InterruptedException
	{
		String title = ExcelData.getData(file_path, "TC01", 1, 2);
		String EerrorMsg = ExcelData.getData(file_path, "TC02", 1, 2);
		actiTIMELoginPage lp= new actiTIMELoginPage(driver);
		lp.verifyTitle(title);
		 int rc = ExcelData.getRowCount(file_path, "TC02");
		 for(int i=1; i<=rc; i++)
		 {
			 String un = ExcelData.getData(file_path, "TC02", i, 0);
			 String pw = ExcelData.getData(file_path, "TC02", i, 1);
			 Reporter.log("User name "+un,true);
			 lp.enterUserName(un);
			 Reporter.log("Password "+pw,true);
			 lp.enterPassword(pw);
			 lp.clickOnLoginButton();
			 String Aerrormsg = lp.verifyErrorMsg();
			 Assert.assertEquals(Aerrormsg, EerrorMsg);
			 Reporter.log("===================================",true);
			 Thread.sleep(2000);
		 }
	}

}
