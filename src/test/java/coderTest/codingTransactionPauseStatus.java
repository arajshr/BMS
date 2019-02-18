package coderTest;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basic_Config.BrowserInitiated;
import codingPageObjRepo.codingInbox;

public class codingTransactionPauseStatus extends BrowserInitiated{
  @Test
  public void VerifyPause() {
  
  try {
	  	
	  int execuatbleRowId = excel.isExecutable("VerifyPause");
		XSSFSheet sheet =excel.setSheet("TestData");
	  
		String locationName =excel.readValue(sheet, execuatbleRowId, "Location");
		String pauseRemark =excel.readValue(sheet, execuatbleRowId, "Remarks");
		String pauseReason =excel.readValue(sheet, execuatbleRowId, "Reason");
		BrowserInitiated.logger.log(LogStatus.INFO, "Verifying  Coding Pause Functionality:");
		codingInbox objPauseTrans = PageFactory.initElements(driver,codingInbox.class);
		objPauseTrans.click_CodingMenu()
					.click_InboxTab()
					.click_codingInbox();
		objPauseTrans.CoderTransactionPause(locationName, pauseRemark, pauseReason);
		
} catch (Exception e) {
	// TODO: handle exception
}
  
  }
}
