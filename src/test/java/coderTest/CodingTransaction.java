package coderTest;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basic_Config.BrowserInitiated;
import codingPageObjRepo.codingInbox;

public class CodingTransaction extends BrowserInitiated {
	
  @Test
  public void codingTransaction() throws Exception
  {
	  try {
		  int execuatbleRowId = excel.isExecutable("codingTransaction");
			XSSFSheet sheet =excel.setSheet("TestData");
		  
			String Location =excel.readValue(sheet, execuatbleRowId, "Location");
			String TotalCodedCharts =excel.readValue(sheet, execuatbleRowId, "TotalCodedCharts");
			String TotalPendedCharts =excel.readValue(sheet, execuatbleRowId, "TotalPendedCharts");
			String DiscardedChart =excel.readValue(sheet, execuatbleRowId, "DiscardedChart");
			String CoderInitials =excel.readValue(sheet, execuatbleRowId, "CoderInitials");
			String DuplciateCharts =excel.readValue(sheet, execuatbleRowId, "DuplciateCharts");
			String ViewCharge =excel.readValue(sheet, execuatbleRowId, "ViewCharges");
			String CoderComment =excel.readValue(sheet, execuatbleRowId, "CoderComment");
			String chartNo =excel.readValue(sheet, execuatbleRowId, "NoOfCharts");
			String dos =excel.readValue(sheet, execuatbleRowId, "DOS");
			String patientName =excel.readValue(sheet, execuatbleRowId, "CoderInitials");
			String sSN =excel.readValue(sheet, execuatbleRowId, "SSN");
			String logType =excel.readValue(sheet, execuatbleRowId, "logtype");
			String logPendingComment =excel.readValue(sheet, execuatbleRowId, "Remarks");
			String responsibility =excel.readValue(sheet, execuatbleRowId, "Responsibility");
			String phy =excel.readValue(sheet, execuatbleRowId, "Phy");
			String nonBillRemark =excel.readValue(sheet, execuatbleRowId, "NonBillRemark");
			String nonBillingType =excel.readValue(sheet, execuatbleRowId, "NonBillingType");
						
						
							
			
			
			logger.log(LogStatus.INFO, "Verifying Coder Transaction with adding pending log and Non Billing Log");
			

			codingInbox objCoderTrans = PageFactory.initElements(driver,  codingInbox.class);
				objCoderTrans.click_CodingMenu()
							 .click_InboxTab()
							 .click_codingInbox();
							 //.select_Location(Location);
							objCoderTrans .click_BatchName(Location,TotalCodedCharts,  TotalPendedCharts,  DiscardedChart, CoderInitials, DuplciateCharts , ViewCharge, CoderComment
									,chartNo,dos,patientName,sSN,logType,logPendingComment,responsibility,phy,nonBillRemark,nonBillingType);
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	 
						 
			
	  
	      
	  
  }
}
