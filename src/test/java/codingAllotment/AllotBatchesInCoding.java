package codingAllotment;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import allotmentCoding.Allotment;
import basic_Config.BrowserInitiated;

public class AllotBatchesInCoding extends  BrowserInitiated{
  @Test
  public void ReallotBatch() throws Exception {
	  int execuatbleRowId = excel.isExecutable("ReallotBatch");
		XSSFSheet sheet =excel.setSheet("TestData");
	  
		String speciality =excel.readValue(sheet, execuatbleRowId, "Speciality");
		String location =excel.readValue(sheet, execuatbleRowId, "Location");
		String facilityCode =excel.readValue(sheet, execuatbleRowId, "Facility Code");
		String coderNtlg=excel.readValue(sheet, execuatbleRowId, "Coder Ntlg");
		String clientName=excel.readValue(sheet, execuatbleRowId, "Client Name");
		
		
		
		Allotment objReallotment =PageFactory.initElements(driver, Allotment.class);
		
		objReallotment.click_AllotMenu()
					.click_CodingAllotTab()
					.click_AllotedBatchInCoding();
		
		objReallotment.ReallotCoderBatchRelease(speciality, location, facilityCode, coderNtlg,clientName);
		
		
	  
  }
}
