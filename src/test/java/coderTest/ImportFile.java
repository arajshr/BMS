package coderTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import com.relevantcodes.extentreports.LogStatus;

import basic_Config.BrowserInitiated;
import codingPageObjRepo.Import;

public class ImportFile extends BrowserInitiated{
  @Test
  public void Importfile() {
	  
	  
	  try {
		  int execuatbleRowId = excel.isExecutable("Importfile");
			XSSFSheet sheet =excel.setSheet("TestData");
	
			String uploadType =excel.readValue(sheet, execuatbleRowId, "Uploadtype");
			
			String speciality =excel.readValue(sheet, execuatbleRowId, "Speciality");
			String software=excel.readValue(sheet, execuatbleRowId, "Software");
			String batchUploadFilePath=excel.readValue(sheet, execuatbleRowId, "BatchUploadFilePath");
			/*String location =excel.readValue(sheet, execuatbleRowId, "Location");
			String group =excel.readValue(sheet, execuatbleRowId, "Group Name");
			String facility =excel.readValue(sheet, execuatbleRowId, "Facility Name");
			String receivedDate =excel.readValue(sheet, execuatbleRowId, "Received Date");
			String noOfBatch =excel.readValue(sheet, execuatbleRowId, "NoofBatch");
			String comments =excel.readValue(sheet, execuatbleRowId, "CoderComment");
			String dos =excel.readValue(sheet, execuatbleRowId, "DOS");
			String categoryName =excel.readValue(sheet, execuatbleRowId, "CategoryName");
			String noOfPages =excel.readValue(sheet, execuatbleRowId, "NoOfPages");
			String noOfCharts =excel.readValue(sheet, execuatbleRowId, "NoOfCharts");*/
			
			
			Import objImport =PageFactory.initElements(driver, Import.class);
			BrowserInitiated.logger.log(LogStatus.INFO, "Uploading Batches to BMS coding :");
			
			objImport.click_ImportMenu()
					 .click_ImportTab()
					 .Importfile(uploadType,speciality,speciality,software,batchUploadFilePath);
			
	  } catch (Exception e) {
		e.printStackTrace();
	}
  }
}
