package coderTest;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basic_Config.BrowserInitiated;
import codingPageObjRepo.Feedback;

public class QCfeedBackAck extends BrowserInitiated{
  @Test
  public void QcFeedBackAck() {
	  
	  try {
		  logger.log(LogStatus.INFO, "Verifying  Qc feedback Acknowled :");
		  int execuatbleRowId = excel.isExecutable("QcFeedBack");
			XSSFSheet sheet =excel.setSheet("TestData");
		  Feedback objFeedBackAck = PageFactory.initElements(driver, Feedback.class);
		  
		  objFeedBackAck.click_CodingMenu()
		  			 .click_tabFeedBack()
		  			 .click_link_QcFeedBack();
		  objFeedBackAck.acknowledgeQcFeedBack();
		  
		  	  
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  
  }
}
