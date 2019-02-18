package coderTest;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basic_Config.BrowserInitiated;
import codingPageObjRepo.Feedback;

public class QcFeedBackEsclt extends BrowserInitiated{
  @Test
  public void QcfeedBackEsclt() {
	  try {
		  logger.log(LogStatus.INFO, "Verifying  Qc feedback Escalation :");
		  int execuatbleRowId = excel.isExecutable("QcfeedBackEsclt");
			XSSFSheet sheet =excel.setSheet("TestData");
			String coderComment =excel.readValue(sheet, execuatbleRowId, "CoderComment");
			
		  Feedback objFeedBackescl = PageFactory.initElements(driver, Feedback.class);
		  
		  	objFeedBackescl.click_CodingMenu()
		  					.click_tabFeedBack()
		  					.click_link_QcFeedBack();
		  	objFeedBackescl.EscalateQcFeedBack(coderComment);
		  
		  	  
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  
  
  
  
  
  }
}
