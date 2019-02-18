package codingAllotment;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import basic_Config.BrowserInitiated;
import codingPageObjRepo.codingInbox;

public class IvrBatchName extends BrowserInitiated{
  @Test
  public void batchIvr() throws Exception{
  
	  int execuatbleRowId = excel.isExecutable("batchIvr");
		XSSFSheet sheet =excel.setSheet("TestData");
		
		String clientName=excel.readValue(sheet, execuatbleRowId, "Client Name");
		String speciality =excel.readValue(sheet, execuatbleRowId, "Speciality");
		String location =excel.readValue(sheet, execuatbleRowId, "Location");
		String facilityCode =excel.readValue(sheet, execuatbleRowId, "Facility Code");
		
		codingInbox objcoderInbox = PageFactory.initElements(driver, codingInbox.class);
		
		
  }
}
