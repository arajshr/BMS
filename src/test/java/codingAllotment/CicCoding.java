package codingAllotment;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import allotmentCoding.Allotment;
import basic_Config.BrowserInitiated;
import codingPageObjRepo.Login;
import codingPageObjRepo.codingInbox;

public class CicCoding extends BrowserInitiated {
	@Test
	  public void Cic() throws Exception{
		  int execuatbleRowId = excel.isExecutable("Cic");
			XSSFSheet sheet =excel.setSheet("TestData");
			
			String clientName=excel.readValue(sheet, execuatbleRowId, "Client Name");
			String speciality =excel.readValue(sheet, execuatbleRowId, "Speciality");
			String location =excel.readValue(sheet, execuatbleRowId, "Location");
			String facilityCode =excel.readValue(sheet, execuatbleRowId, "Facility Code");
		  
		  /*need to Login with coder, Web configuration changes to be done */
		  
		  codingInbox objcoderInbox = PageFactory.initElements(driver, codingInbox.class);
		  String s = objcoderInbox.click_OpenBatchName();
		  Login objCodingInbox = new Login();
		  objCodingInbox.click_Logout();
		  
		  /*need to Login with TL, Web configuration changes to be done  */
		  
		  objCodingInbox.click_Login(clientName);
		  System.out.println(s);
		  
		  Allotment objAllotment = PageFactory.initElements(driver, Allotment.class);
		  objAllotment.click_AllotMenu()
		  .click_CodingAllotTab()
		  .click_Cic();
		  objAllotment.verifyBatchNameInCiq(speciality, location, facilityCode,s);
		  
		  
	  }
}
