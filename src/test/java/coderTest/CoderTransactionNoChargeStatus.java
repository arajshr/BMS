package coderTest;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import basic_Config.BrowserInitiated;
import codingPageObjRepo.codingInbox;

public class CoderTransactionNoChargeStatus extends BrowserInitiated {
  @Test
  
	  public void NoChargeCoderTrans() throws Exception
	  		{
		  	
		  	int execuatbleRowId = excel.isExecutable("NoChargeCoderTrans");
		  	XSSFSheet sheet =excel.setSheet(BrowserInitiated.sheetName);
		  
			String Location =excel.readValue(sheet, execuatbleRowId, "Location");
			String TotalCodedCharts =excel.readValue(sheet, execuatbleRowId, "TotalCodedCharts");
			String TotalPendedCharts =excel.readValue(sheet, execuatbleRowId, "TotalPendedCharts");
			String DiscardedChart =excel.readValue(sheet, execuatbleRowId, "DiscardedChart");
			String CoderInitials =excel.readValue(sheet, execuatbleRowId, "CoderInitials");
			String DuplciateCharts =excel.readValue(sheet, execuatbleRowId, "DuplciateCharts");
			String ViewCharge =excel.readValue(sheet, execuatbleRowId, "ViewCharges");
			String CoderComment =excel.readValue(sheet, execuatbleRowId, "CoderComment");
			
			codingInbox objCoderTransStatus = PageFactory.initElements(driver,  codingInbox.class);
			
			objCoderTransStatus.click_CodingMenu()
								.click_InboxTab()
								.click_codingInbox();
			objCoderTransStatus.NochargeCoderTrans(Location,TotalCodedCharts,  TotalPendedCharts,  DiscardedChart, CoderInitials, DuplciateCharts , ViewCharge, CoderComment);
				
	  		}
  }

