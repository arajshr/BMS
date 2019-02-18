package coderTest;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import basic_Config.BrowserInitiated;
import codingPageObjRepo.codingInbox;
import excelLibrary.WebDriverUtils;

public class CoderTransactionHoldStatus extends BrowserInitiated {
	WebDriverUtils utils = new WebDriverUtils();
  @Test
  
	  public void HoldCoderTrans() throws Exception {
		  
		  int execuatbleRowId = excel.isExecutable("HoldCoderTrans");
			XSSFSheet sheet =excel.setSheet(BrowserInitiated.sheetName);
		  
			String Location =excel.readValue(sheet, execuatbleRowId, "Location");
			String TotalCodedCharts =excel.readValue(sheet, execuatbleRowId, "TotalCodedCharts");
			String TotalPendedCharts =excel.readValue(sheet, execuatbleRowId, "TotalPendedCharts");
			String DiscardedChart =excel.readValue(sheet, execuatbleRowId, "DiscardedChart");
			String CoderInitials =excel.readValue(sheet, execuatbleRowId, "CoderInitials");
			String DuplciateCharts =excel.readValue(sheet, execuatbleRowId, "DuplciateCharts");
			String ViewCharge =excel.readValue(sheet, execuatbleRowId, "ViewCharges");
			String CoderComment =excel.readValue(sheet, execuatbleRowId, "CoderComment");
			
			String CodedDate =excel.readValue(sheet, execuatbleRowId, "Coded From");
			codingInbox objCoderTransStatus = PageFactory.initElements(driver,  codingInbox.class);
			
			
			
			
			objCoderTransStatus.click_CodingMenu()
								.click_InboxTab()
								.click_codingInbox();
			objCoderTransStatus.CoderTransHold(Location,TotalCodedCharts,  TotalPendedCharts,  DiscardedChart, CoderInitials, DuplciateCharts , ViewCharge, CoderComment,CodedDate);
				
	  }
	  
  }

