package basic_Config;



import org.apache.poi.xssf.usermodel.XSSFSheet;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import codingPageObjRepo.Login;




public class Login_Logout extends BrowserInitiated

{

	public void LoginDetails() {
		
		int execuatbleRowId = excel.isExecutable("LoginDetails");
			XSSFSheet sheet =excel.setSheet("TestData");
		
		String Client = excel.readValue(sheet, execuatbleRowId, "Client Name");
		//String Location = excel.readValue(sheet, execuatbleRowId, "Location");
		
		Login objLogin = PageFactory.initElements(driver, Login.class);
		
		objLogin.click_Login(Client)
				.click_Logout();
		
		
		logger.log(LogStatus.INFO, "Logged In ");
		
		//objLogin.LoginSuccess();
				
	
  
}	
	
	
	
	@Test
	public void Verify_Logout ()
	
	{
		Login objLogout  =PageFactory.initElements(driver, Login.class);
		objLogout.click_Logout();
		logger.log(LogStatus.INFO, "Logged out ");
		
		
		
	}

}
