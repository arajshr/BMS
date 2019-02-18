package coderTest;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basic_Config.BrowserInitiated;
import codingPageObjRepo.codingInbox;

public class verifyClientName extends BrowserInitiated{
  @Test
  public void clientVerification() {
	  
	  int execuatbleRowId = excel.isExecutable("clientVerification");
		XSSFSheet sheet =excel.setSheet("TestData");
	  
		//String Location =excel.readValue(sheet, execuatbleRowId, "Location");
	  
	
	  codingInbox verifyClient = PageFactory.initElements(BrowserInitiated.driver, codingInbox.class);
	  BrowserInitiated.logger.log(LogStatus.INFO, "Verifying Client Name in user Login ");
	 verifyClient.client_Verify();
	
	  
  }
}
