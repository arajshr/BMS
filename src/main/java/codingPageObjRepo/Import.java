package codingPageObjRepo;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.GetText;

import basic_Config.BrowserInitiated;
import basic_Config.Constants;
import excelLibrary.WebDriverUtils;

public class Import {

	WebDriverUtils utils = new WebDriverUtils();

	// offline online Page Locator

	@FindBy(id = "Image1")
	private WebElement menuImport;

	@FindBy(id = "id1")
	private WebElement tabOff_Online;

	@FindBy(id = "HyperLink")
	private WebElement lnkHelp;

	@FindBy(id = "DDL_UPLOAD_TYPE")
	private WebElement ddUploadType;

	@FindBy(id = "DDl_SPECIALTY")
	private WebElement ddSpeciality;

	@FindBy(id = "DDL_TYPE")
	private WebElement ddType;

	@FindBy(id = "ddl_Software")
	private WebElement ddSoftware;

	@FindBy(id = "FileUpload1")
	private WebElement btnUploadFile;

	@FindBy(id = "Button1")
	private WebElement btnShowBatches;
	
	@FindBy(id = "Button2")
	private WebElement btnUploadConfirm;
	
	

	// Create Batch page locator

	@FindBy(id = "id2")
	private WebElement tabCreateBatch;

	@FindBy(id = "DDL_TYPE")
	private WebElement ddBatchType;

	@FindBy(id = "DDL_OFF_ON")
	private WebElement ddOn_Off;

	@FindBy(id = "DDl_SPECIALTY")
	private WebElement ddBatchSpeciality;

	@FindBy(id = "DDLSoftware")
	private WebElement ddBatchSoftware;

	@FindBy(id = "ddl_location")
	private WebElement ddLocation;

	@FindBy(id = "ddl_group")
	private WebElement ddGroup;

	@FindBy(id = "DDL_FACILITY")
	private WebElement ddFacility;

	@FindBy(id = "TXT_RECEIVED_DATE")
	private WebElement txtReceivedDate;

	@FindBy(id = "TXT_NO_OF_BATCHES")
	private WebElement txtNoOfBatches;

	@FindBy(id = "Txt_Comments")
	private WebElement txtComments;

	@FindBy(id = "Button1")
	private WebElement btnCreateBatch;

	@FindBy(id = "GridView1")
	private WebElement tblCeateBatch;

	@FindBy(id = "GridView1_txtdos_0")
	private WebElement txttblDOS;

	@FindBy(id = "GridView1_txtcatagory_0")
	private WebElement txttblCategory;

	@FindBy(id = "GridView1_txtnoofpages_0")
	private WebElement txttblNoofPages;

	@FindBy(xpath = ".//*[@id='GridView1_txtnoofcharts_0']")
	private WebElement txttblNoofCharts;

	@FindBy(id = "But_Upload")
	private WebElement btntblUpload;

	public Import click_ImportMenu() throws Exception {

		BrowserInitiated.driver.switchTo().frame("I1");
		BrowserInitiated.logger.log(LogStatus.INFO, " Clicking Import Menu Option :");

		utils.waitFor(2000);
		menuImport.click();
		return this;
	}

	public Import click_CreateBatchTab() throws Exception {
		// utils.turnOnImplicitWaits();
		BrowserInitiated.driver.switchTo().frame("I3");

		utils.waitFor(2000);
		tabCreateBatch.click();
		
		//BrowserInitiated.driver.switchTo().defaultContent();
		
		return this;

	}
	
	
	public Import click_ImportTab() throws Exception {
		// utils.turnOnImplicitWaits();
		BrowserInitiated.driver.switchTo().frame("I3");
		BrowserInitiated.logger.log(LogStatus.INFO, " Clicking Import meuu Tab :");
		utils.waitFor(2000);
		tabOff_Online.click();
		
		//BrowserInitiated.driver.switchTo().defaultContent();
		
		return this;

	}
	
	public void createNewBatch(String batchType, String onlineoff, String speciality, String software, String location,
			String group, String facility, String receivedDate, String noOfBatch, String comments, String dos,
			String categoryName, String noOfPages, String noOfCharts) {

		try {

			// utils.waitForVisiblityOfElement(ddBatchType);

			BrowserInitiated.driver.switchTo().frame("I_import");
			utils.waitFor(2000);
			utils.select(ddBatchType, batchType);
			utils.waitFor(2000);
			utils.select(ddOn_Off, onlineoff);
			utils.waitFor(2000);
			utils.select(ddBatchSpeciality, speciality);
			utils.waitFor(2000);
			utils.select(ddBatchSoftware, software);
			utils.waitFor(2000);
			utils.select(ddLocation, location);
			utils.waitFor(2000);
			utils.select(ddGroup, group);
			utils.waitFor(2000);
			utils.select(ddFacility, facility);
			
			utils.waitFor(2000);
			txtReceivedDate.click();
			
			Actions act = new Actions(BrowserInitiated.driver);
			for (int i = 0; i < 10; i++)
			{
				act.sendKeys(Keys.ARROW_LEFT).build().perform();	
			}
			txtReceivedDate.sendKeys(receivedDate);

			txtNoOfBatches.sendKeys(noOfBatch);
			txtComments.sendKeys(comments);
			btnCreateBatch.click();

			// Uploaded Batches Successfully
			List<WebElement> tr_collection = BrowserInitiated.driver.findElements(By.xpath(".//*[@id='GridView1']//tr"));

			for (int i = 1; i < tr_collection.size()-1; i++) 
			{
				txttblDOS.click();
				for (int j = 0; j < 10; j++)
				{
					
					act.sendKeys(Keys.ARROW_LEFT).build().perform();	
				}
				txttblDOS.sendKeys(dos);
				txttblCategory.sendKeys(categoryName);
				txttblNoofPages.sendKeys(noOfPages);
				txttblNoofCharts.clear();
				txttblNoofCharts.sendKeys(noOfCharts);
				utils.waitForPresenceOfElement(By.id("But_Upload"));
				btntblUpload.click();
				BrowserInitiated.logger.log(LogStatus.INFO, "Creating a batch Manually :");
				
				String actMessage = BrowserInitiated.driver.findElement(By.id("msg1")).getText();
				String expMessage = "Uploaded Batches Successfully";
				BrowserInitiated.logger.log(LogStatus.INFO, "Verifying Batch Create : ");
				assertEquals(actMessage, expMessage, "Batch Not Crreated");
					utils.captureScreenshot("Batch Create");
					
				
		

			}
			
			
			/*for (int i = 1; i < tr_collection.size()-1; i++) 
			{
				
				
				List<WebElement> lstCell = tr_collection.get(i).findElements(By.xpath("./td/input"));
				
				lstCell.get(0).sendKeys(dos);
				lstCell.get(1).sendKeys(categoryName);
				lstCell.get(2).sendKeys(noOfPages);
				lstCell.get(3).sendKeys(noOfCharts);				
			}*/

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

	public void Importfile (String uploadType, String speciality, String selectType, String software, String batchUploadFilePath) {

		try {
			BrowserInitiated.driver.switchTo().frame("I_import");
			utils.select(ddUploadType, uploadType);
			utils.select(ddSpeciality, speciality);
			utils.select(ddType, selectType);
			utils.select(ddSoftware, software);
			
		 
			BrowserInitiated.logger.log(LogStatus.INFO, "Selecting the file to upload : ");
	        // enter the file path onto the file-selection input field
			btnUploadFile.sendKeys(batchUploadFilePath);
			
			//utils.selectvalue(btnShowBatches, "E:\\NewWorkspace\\BMS_test\\src\\test\\resource\\BMSCodingBatchUploadAutmationfile.txt");
	        
			btnShowBatches.click();
			
			BrowserInitiated.logger.log(LogStatus.INFO, "Verifying the data from file  :");
			utils.captureScreenshot("Uplaoded Data");
			btnUploadConfirm.click();
			
			List<WebElement> tr_collection1 = BrowserInitiated.driver.findElements(By.xpath(".//*[@id='Panel1']//tr"));
			
			String name = null;
			int row = tr_collection1.size();
			
			BrowserInitiated.logger.log(LogStatus.INFO, "Verifying the file  data with respect to uploaded data : ");
			System.out.println("size is " + (row - 2));			
				int i=0;
				for (i = 2; i < row; i++) {
					utils.waitFor(1000);
					WebElement trdata = BrowserInitiated.driver.findElement(By.xpath(".//*[@id='Panel1']//tr["+(i)+"]//td[5]"));
					System.out.println("data is...." + trdata.getText());
					for(int j=1;j<=3;j++) 
					{
						name=BrowserInitiated.excel.readExcelData(Constants.xlFilePath, "CodingBatchUpload", j, 7);
						System.out.println(name);
						if (trdata.getText().equals(name)) {
							
							String actMessage = BrowserInitiated.driver.findElement(By.id("Label2")).getText();
							String expMessage = "Successfully uploaded Batches : "+(tr_collection1.size()-2);
							BrowserInitiated.logger.log(LogStatus.INFO, "Verifying Batch Upload uploaded Batch Name : "+name+"  and found Batch Name : "+trdata.getText()+" ");
							utils.captureScreenshot(trdata.getText());
							assertEquals(actMessage, expMessage, "Uploaded record are not present, records in grid is not matching with the uploaded data");
							
							
							System.out.println("in " + (i - 1) + "th row Value matched");
							break;
						} else {
							continue;
						}
					}
					
				}

			
		} catch (Exception e) {
			// TODO: handle exception 
			e.printStackTrace();
		}
		
	}
	
	
	
}
