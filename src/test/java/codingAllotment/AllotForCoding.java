package codingAllotment;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import allotmentCoding.Allotment;
import basic_Config.BrowserInitiated;

public class AllotForCoding  extends BrowserInitiated{
  @Test
  public void AllotBatches() {
	  
	  try {
		  
		  int execuatbleRowId = excel.isExecutable("AllotBatches");
			XSSFSheet sheet =excel.setSheet("TestData");
		  
			String recievedDate =excel.readValue(sheet, execuatbleRowId, "Received Date");
			String speciality =excel.readValue(sheet, execuatbleRowId, "Speciality");
			String location =excel.readValue(sheet, execuatbleRowId, "Location");
			String facilityCode =excel.readValue(sheet, execuatbleRowId, "Facility Code");
			String software =excel.readValue(sheet, execuatbleRowId, "Software");
			String userList =excel.readValue(sheet, execuatbleRowId, "Coder Ntlg");
			String batchStatus =excel.readValue(sheet, execuatbleRowId, "Batch Status");
			String allotType =excel.readValue(sheet, execuatbleRowId, "AllotType");
			String allotComment =excel.readValue(sheet, execuatbleRowId, "CoderComment");
			
			Allotment objAllotment =PageFactory.initElements(driver, Allotment.class);
			
			objAllotment.click_AllotMenu()
						.click_CodingAllotTab()
						.click_AllotforCoding();
			objAllotment.AllotCoderBatch(recievedDate, speciality, location, facilityCode, software, userList, batchStatus, allotType, allotComment);
			
			
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
  }
}
