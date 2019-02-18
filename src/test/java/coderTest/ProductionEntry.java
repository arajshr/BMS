package coderTest;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import basic_Config.BrowserInitiated;
import codingPageObjRepo.ProductionEntryNew;


public class ProductionEntry extends BrowserInitiated{
  @Test
  public void EnterProducation() {
	  
	  try {
		  
		  int execuatbleRowId = excel.isExecutable("EnterProducation");
			XSSFSheet sheet =excel.setSheet("TestData");
		  
			String pdnHour =excel.readValue(sheet, execuatbleRowId, "HrSMin");
			String pdnMin =excel.readValue(sheet, execuatbleRowId, "HrSMin");
			String idleHrs =excel.readValue(sheet, execuatbleRowId, "HrSMin");
			String idleMin =excel.readValue(sheet, execuatbleRowId, "HrSMin");
			String idleDescription =excel.readValue(sheet, execuatbleRowId, "IdleDescription");
			ProductionEntryNew objCoderTran = PageFactory.initElements(driver, ProductionEntryNew.class);
			objCoderTran.click_CodingMenu()
						.click_InboxTab()
						.click_link_ProductionEntry();
			objCoderTran.click_ProductionEntry(pdnHour, pdnMin, idleHrs, idleMin,idleDescription);
			
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
  }
}
