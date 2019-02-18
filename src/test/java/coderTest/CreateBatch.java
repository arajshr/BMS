package coderTest;




import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import basic_Config.BrowserInitiated;
import codingPageObjRepo.Import;

public class CreateBatch  extends BrowserInitiated
{
  @Test
  public void newBatch() {
	  
	  try {
		  int execuatbleRowId = excel.isExecutable("newBatch");
			XSSFSheet sheet =excel.setSheet("TestData");
			
			String batchType =excel.readValue(sheet, execuatbleRowId, "batchType");
			String onlineoff =excel.readValue(sheet, execuatbleRowId, "onlineoff");
			String speciality =excel.readValue(sheet, execuatbleRowId, "Speciality");
			String software=excel.readValue(sheet, execuatbleRowId, "Software");
			String location =excel.readValue(sheet, execuatbleRowId, "Location");
			String group =excel.readValue(sheet, execuatbleRowId, "Group Name");
			String facility =excel.readValue(sheet, execuatbleRowId, "Facility Name");
			String receivedDate =excel.readValue(sheet, execuatbleRowId, "Received Date");
			String noOfBatch =excel.readValue(sheet, execuatbleRowId, "NoofBatch");
			String comments =excel.readValue(sheet, execuatbleRowId, "CoderComment");
			String dos =excel.readValue(sheet, execuatbleRowId, "DOS");
			String categoryName =excel.readValue(sheet, execuatbleRowId, "CategoryName");
			String noOfPages =excel.readValue(sheet, execuatbleRowId, "NoOfPages");
			String noOfCharts =excel.readValue(sheet, execuatbleRowId, "NoOfCharts");
			
			
			Import objImport =PageFactory.initElements(driver, Import.class);
			
			objImport.click_ImportMenu()
					 .click_CreateBatchTab()
					 .createNewBatch(batchType,onlineoff,speciality,software,location,group,facility,receivedDate,noOfBatch,comments,dos,categoryName,noOfPages,noOfCharts);
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
	  
					
			 
  }
}
