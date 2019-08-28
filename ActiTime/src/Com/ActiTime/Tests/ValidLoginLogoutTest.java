package Com.ActiTime.Tests;

import org.testng.annotations.Test;

import Com.ActiTime.Generic.BaseTest;
import Com.ActiTime.Generic.ExcelData;
import Com.ActiTime.Pages.actiTIMEEnterTimeTrackPage;
import Com.ActiTime.Pages.actiTIMELoginPage;

public class ValidLoginLogoutTest extends BaseTest
{
	@Test(priority=1)
	public void ValidLoginLogout() 
	{
		String un = ExcelData.getData(file_path, "TC01", 1, 0);
		String pw = ExcelData.getData(file_path, "TC01", 1, 1);
		String title = ExcelData.getData(file_path, "TC01", 1, 2);
		String hptitle = ExcelData.getData(file_path, "TC01", 1, 3);
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		actiTIMEEnterTimeTrackPage hp = new actiTIMEEnterTimeTrackPage(driver);
		lp.verifyTitle(title);
		lp.enterUserName(un);
		lp.enterPassword(pw);
		lp.clickOnLoginButton();
		lp.verifyTitle(hptitle);
		hp.clickOnLogoutButton();
		hp.verifyTitle(title);
		
	}

}
