package allotmentCoding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import basic_Config.BrowserInitiated;
import codingPageObjRepo.Login;
import excelLibrary.WebDriverUtils;

public class Allotment {

	WebDriverUtils utils=new WebDriverUtils();
	
	@FindBy (id="id3")
	private WebElement allotmentMenu;
	
	@FindBy (id="id1")
	private WebElement codingAllotmnetTab;
	
	
	@FindBy (id="Image2")
	private WebElement menuCoding;
	
	@FindBy (id="id1")
	private WebElement codingTabInbox;
	
	@FindBy (xpath=".//*[@id='navigationDiv']/tbody/tr/td/a[1]")
	private WebElement lnkCodingInbox;
	
	
	//Allot for coding Locator
	
	@FindBy (id="id1")
	private WebElement lnkcodingAllot;
	
	@FindBy (name="txt_received_date")
	private WebElement dpReceivedDate;

	@FindBy (name="txt_download_date")
	private WebElement dpDownloadedDate;
	
	@FindBy (id="ddl_Speciality")
	private WebElement ddSpeciality;
	
	@FindBy (id="DDL_location")
	private WebElement ddLocation;
	
	@FindBy (id="DDL_Facility_code")
	private WebElement ddFacilityCode;
	
	@FindBy (id="DDL_Software")
	private WebElement ddSoftware;
	
	@FindBy (id="Ddluserlist")
	private WebElement ddUser;
	
	@FindBy (id="ddlBatchStatus")
	private WebElement ddBatchStatus;
	
	@FindBy (id="btn_get_report")
	private WebElement btnGetReport;
	
	@FindBy (id="btn_save")
	private WebElement btnSaveAllotment;
	
	@FindBy (id="GridView1_Chkselect_0")
	private WebElement chkBoxClick;
	
	@FindBy (id="GridView1_status_0")
	private WebElement ddselectAllotType;
	
	@FindBy (id="GridView1_userlist_0")
	private WebElement ddUserName;
	
	@FindBy (id="GridView1_txt_comments_0")
	private WebElement txtComments;
	
	//Held Batch for Release
	
	@FindBy (id="id3")
	private WebElement lnkHeldBatch;
	
	@FindBy (id="Txt_Received_Date")
	private WebElement txtReceiveDate;
	
	@FindBy (name="Txt_Download_Date")
	private WebElement txtDownloadedDate;
	
	@FindBy (id="Btn_Submit")
	private WebElement btnSubmit;
	
	@FindBy (id="GridView1_status_0")
	private WebElement ddReleasetype;
	
	@FindBy (id="GridView1_txt_DISREGARD_COMMENT_0")
	private WebElement txtReleaseComment;
	
	@FindBy (id="Btn_ReleaseCoding")
	private WebElement btnReleaseHeldCoding;
	
	
	//Re-allot release batch
	
	@FindBy (id="id4")
	private WebElement lnkAllotedBatchInCoding;
	
	@FindBy (id="GridView2_RB_Reallot_0")
	private WebElement radioBtnReallot;
	
	@FindBy (id="GridView2_lbl_User_0")
	private WebElement ddUserList;
	
	@FindBy (id="Btn_Reallot")
	private WebElement btnReleaseBatch;
	
	//CIQ locators
	
	@FindBy (id="id5")
	private WebElement lnkCiq;
	
	
	@FindBy (xpath=".//*[@id='GridView1']/tbody/tr[2]/td[1]/a")
	private WebElement BatchName;
	
	
	public Allotment  click_AllotMenu( )  throws Exception
	{

		BrowserInitiated.driver.switchTo().frame("I1");
		Thread.sleep(2000);
		//utils.waitForVisiblityOfElement(menuCoding);
		allotmentMenu.click();
		return this;
	}
	
	public Allotment  click_CodingAllotTab( ) throws Exception
	{
		//utils.turnOnImplicitWaits();
		BrowserInitiated.driver.switchTo().frame("I3");
		Thread.sleep(2000);
		//utils.waitForVisiblityOfElement(tabInbox);
		codingAllotmnetTab.click(); 
		return this;
	
	}
	
	public Allotment  click_AllotforCoding( ) throws Exception
	{ 	
		//utils.turnOnImplicitWaits();
		BrowserInitiated.driver.switchTo().frame("I_qc");
		Thread.sleep(2000);
		//utils.waitForVisiblityOfElement(lnkCodingInbox);
		lnkcodingAllot.click(); 
		return this;
	
	}
	
	
	public Allotment  click_HeldBatchLink( ) throws Exception
	{ 	
		//utils.turnOnImplicitWaits();
		BrowserInitiated.driver.switchTo().frame("I_qc");
		Thread.sleep(2000);
		//utils.waitForVisiblityOfElement(lnkCodingInbox);
		lnkHeldBatch.click(); 
		return this;
	
	}
	
	public Allotment  click_AllotedBatchInCoding( ) throws Exception
	{ 	
		//utils.turnOnImplicitWaits();
		BrowserInitiated.driver.switchTo().frame("I_qc");
		Thread.sleep(2000);
		//utils.waitForVisiblityOfElement(lnkCodingInbox);
		lnkAllotedBatchInCoding.click(); 
		return this;
	
	}
	
	
	public Allotment  click_CodingMenu( )  throws Exception
	{

		BrowserInitiated.driver.switchTo().frame("I1");
		Thread.sleep(2000);
		//utils.waitForVisiblityOfElement(menuCoding);
		menuCoding.click();
		return this;

	}
	
	public Allotment  click_InboxTab( ) throws Exception
	{
		//utils.turnOnImplicitWaits();
		BrowserInitiated.driver.switchTo().frame("I3");
		Thread.sleep(2000);
		//utils.waitForVisiblityOfElement(tabInbox);
		codingTabInbox.click(); 
		return this;
	
	}
	
	public Allotment  click_codingInbox( ) throws Exception
	{ 	
		//utils.turnOnImplicitWaits();
		BrowserInitiated.driver.switchTo().frame("I_coding");
		Thread.sleep(2000);
		//utils.waitForVisiblityOfElement(lnkCodingInbox);
		lnkCodingInbox.click(); 
		return this;
	
	}
	
	public Allotment  click_Cic( ) throws Exception
	{ 	
		//utils.turnOnImplicitWaits();
		BrowserInitiated.driver.switchTo().frame("I_qc");
		Thread.sleep(2000);
		//utils.waitForVisiblityOfElement(lnkCodingInbox);
		lnkCiq.click(); 
		return this;
	
	}
	
	
	
		public void AllotCoderBatch (String recievedDate,String speciality,String location,String facilityCode,String software,String userList, String batchStatus, String allotType,String allotComment) 
		{
			try {
				BrowserInitiated.driver.switchTo().frame("I_qc_CODING_ALLOTMENT");
				dpReceivedDate.clear();
				dpReceivedDate.sendKeys(recievedDate);
				utils.select(ddSpeciality, speciality);
				utils.select(ddLocation, location);
				utils.select(ddFacilityCode, facilityCode);
				utils.select(ddSoftware, software);
				utils.select(ddUser, userList);
				utils.select(ddBatchStatus, batchStatus);
				btnGetReport.click();
				chkBoxClick.click();
				utils.select(ddselectAllotType, allotType);
				utils.select(ddUserName, userList);
				txtComments.sendKeys(allotComment);
				btnSaveAllotment.click();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		
		
		}
	
	
		public void HeldCoderBatchRelease (String recievedDate,String speciality,String location,String facilityCode,String coderComment, String releaseType)
		{
			try {
				BrowserInitiated.driver.switchTo().frame("I_qc_CODING_ALLOTMENT");
				
				txtReceiveDate.click();
				Actions act = new Actions(BrowserInitiated.driver);
				for (int i = 0; i < 10; i++)
				{
					act.sendKeys(Keys.ARROW_LEFT).build().perform();	
				}
				txtReceiveDate.sendKeys(recievedDate);
				utils.select(ddSpeciality, speciality);
				utils.select(ddLocation, location);
				utils.select(ddFacilityCode, facilityCode);
				btnSubmit.click();
				utils.select(ddReleasetype, releaseType);
				utils.select(txtReleaseComment, coderComment);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	
	
		public void ReallotCoderBatchRelease (String speciality,String location,String facilityCode,String coderNtlg,String ClientName)
		{
			try {
				BrowserInitiated.driver.switchTo().frame("I_qc_CODING_ALLOTMENT");
			
				utils.select(ddSpeciality, speciality);
				utils.select(ddLocation, location);
				utils.select(ddFacilityCode, facilityCode);
			
				btnSubmit.click();
				radioBtnReallot.click();
				utils.select(ddUserList, coderNtlg);
				String actReallotdBatchName =	BrowserInitiated.driver.findElement(By.xpath(".//*[@id='GridView2']/tbody/tr[2]/td[9]")).getText();
				btnReleaseBatch.click();
				
				/*Need to change web Conf User name */
				
				Login log = PageFactory.initElements(BrowserInitiated.driver, Login.class);
				log.click_Login(ClientName);
				click_CodingMenu();
				click_CodingAllotTab();
				click_codingInbox();
				
				BrowserInitiated.driver.switchTo().frame("I_inbox_sub_menu");
				String ReallotedBatchName =		BrowserInitiated.driver.findElement(By.id("GridView1_lnkbtn_Batch_0")).getText();
				
				if (actReallotdBatchName.equals(ReallotedBatchName)) {
					
					BrowserInitiated.logger.log(LogStatus.PASS, "Realloted Batch Name form Mamnager Login  Inside Allot Batch in Coding is : "+actReallotdBatchName+""
							+ "  and the batch name is properly alloted to Caoder and Verified in coder login Batch found is  "+ReallotedBatchName+"");
				}else {
					BrowserInitiated.logger.log(LogStatus.FAIL, "Batch Alloted form Tl Login : "+actReallotdBatchName+" id not Matching with the batch name found "
							+ "in coder login : "+ReallotedBatchName+"");
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		
		public void verifyBatchNameInCiq (String speciality,String location,String facilityCode, String s) 
		{
			BrowserInitiated.driver.switchTo().frame("I_qc_CODING_ALLOTMENT");
			
			utils.select(ddSpeciality, speciality);
			utils.select(ddLocation, location);
			utils.select(ddFacilityCode, facilityCode);
			btnGetReport.click();
			
			List<WebElement> table_batch_Name = BrowserInitiated.driver.findElements(By.xpath(".//*[@id='GridView1']"));
			
			
			for (int i = 0; i < table_batch_Name.size()-2; i++) 
			{
			String Batch_Name_act =	 BrowserInitiated.driver.findElement(By.xpath(".//*[@id='GridView1']/tbody/tr["+i+"]/td[10]")).getText();
			if (Batch_Name_act.equals(s)) 
			{
				BrowserInitiated.logger.log(LogStatus.PASS, "Batch Name : "+s+" is opened in coder login and Ciq Batch name is  : "+Batch_Name_act+" ");
			} else {
				BrowserInitiated.logger.log(LogStatus.FAIL, "Batch Name : "+s+" is opened in coder login and  Batch name is  : "+Batch_Name_act+"  batch names not matching");
			}
			
		}
			
			
	}
		
		
		
		
		
}
