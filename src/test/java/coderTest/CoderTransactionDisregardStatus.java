package coderTest;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import basic_Config.BrowserInitiated;
import codingPageObjRepo.codingInbox;

public class CoderTransactionDisregardStatus extends BrowserInitiated{
  @Test
  
	  public void DiregardCoderTrans() throws Exception
	  		{
		  	
		  	int execuatbleRowId = excel.isExecutable("DiregardCoderTrans");
		  	XSSFSheet sheet =excel.setSheet(BrowserInitiated.sheetName);
		  
			String Location =excel.readValue(sheet, execuatbleRowId, "Location");
			String TotalCodedCharts =excel.readValue(sheet, execuatbleRowId, "TotalCodedCharts");
			String TotalPendedCharts =excel.readValue(sheet, execuatbleRowId, "TotalPendedCharts");
			String DiscardedChart =excel.readValue(sheet, execuatbleRowId, "DiscardedChart");
			String CoderInitials =excel.readValue(sheet, execuatbleRowId, "CoderInitials");
			String DuplciateCharts =excel.readValue(sheet, execuatbleRowId, "DuplciateCharts");
			String ViewCharge =excel.readValue(sheet, execuatbleRowId, "ViewCharges");
			String CoderComment =excel.readValue(sheet, execuatbleRowId, "CoderComment");
			String todate =excel.readValue(sheet, execuatbleRowId, "CoderComment");
			String fromdate =excel.readValue(sheet, execuatbleRowId, "CoderComment");
			
			codingInbox objCoderTransStatus = PageFactory.initElements(driver,  codingInbox.class);
			
			objCoderTransStatus.click_CodingMenu()
								.click_InboxTab()
								.click_codingInbox();
			objCoderTransStatus.DiregardCoderTrans(Location,TotalCodedCharts,  TotalPendedCharts,  DiscardedChart, CoderInitials, DuplciateCharts , ViewCharge, CoderComment,todate, fromdate);
				
	  		}
	  
  }

