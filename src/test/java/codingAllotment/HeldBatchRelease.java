package codingAllotment;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import allotmentCoding.Allotment;
import basic_Config.BrowserInitiated;

public class HeldBatchRelease extends BrowserInitiated {
  @Test
  public void ReleaseHeldBatch() {
	  
	  try {
		  int execuatbleRowId = excel.isExecutable("ReleaseHeldBatch");
			XSSFSheet sheet =excel.setSheet("TestData");
		  
			String recievedDate =excel.readValue(sheet, execuatbleRowId, "Received Date");
			String speciality =excel.readValue(sheet, execuatbleRowId, "Speciality");
			String location =excel.readValue(sheet, execuatbleRowId, "Location");
			String facilityCode =excel.readValue(sheet, execuatbleRowId, "Facility Code");
			String coderComment =excel.readValue(sheet, execuatbleRowId, "CoderComment");
			String releaseType =excel.readValue(sheet, execuatbleRowId, "ReleaseType");
			
			Allotment objAllotment =PageFactory.initElements(driver, Allotment.class);
			
			objAllotment.click_AllotMenu()
						.click_CodingAllotTab()
						.click_HeldBatchLink();
			objAllotment.HeldCoderBatchRelease(recievedDate, speciality, location, facilityCode,coderComment,releaseType);
			
						
						
	} catch (Exception e) {
		// TODO: handle exception
	}
	  
  }
}
