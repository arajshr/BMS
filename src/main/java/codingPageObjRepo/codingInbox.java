package codingPageObjRepo;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import basic_Config.BrowserInitiated;
import basic_Config.Constants;
import excelLibrary.ExcelReader;
import excelLibrary.WebDriverUtils;


public class codingInbox extends BrowserInitiated

{
	
	Login objLogin = PageFactory.initElements(driver, Login.class);

	WebDriverUtils utils=new WebDriverUtils();

	@FindBy (id="id1")
	private WebElement codingTabInbox;
	
	@FindBy (id="id3")
	private WebElement codingAllotMentMenu;
	
	@FindBy (id="id1")
	private WebElement codingAlllotmentTab;
	
	@FindBy (id="id3")
	private WebElement codingholdTab;
	
	
	@FindBy (id="A2")
	private WebElement codingDisregardTab;
	
	
	@FindBy (id="txtFromDate")
	private WebElement txtFromDate;
	
	@FindBy (id="txtToDate")
	private WebElement txtToDate;
	
	@FindBy (id="Image2")
	private WebElement menuCoding;

	@FindBy (xpath=".//*[@id='navigationDiv']/tbody/tr/td/a[1]")
	private WebElement lnkCodingInbox;
	
	@FindBy (id="DDL_location")
	private WebElement ddSelectLocation;
	
	@FindBy (id="btnsubmit")
	private WebElement btnSearchProdEntry;
	
	@FindBy (id="DDL_location")
	private WebElement selectLocation;
	
	@FindBy (xpath=".//*[@id='GridView1_lnkbtn_Batch_0']")
	private WebElement selectTransactionId;
	
	@FindBy (xpath=".//*[@id='I_inbox_sub_menu']")
	private WebElement movetoTransTable;
	
	@FindBy (id="txt_total_coded_charts")
	private WebElement txtTotalCodedChart;
	
	@FindBy (id="txt_total_pended_charts")
	private WebElement txtTotalPendedChart;
	
	@FindBy (id="txt_non_billable_no_charts_discarded_charts")
	private WebElement txtDiscardedCharts;
	
	@FindBy (id="txt_coder_initial")
	private WebElement txtCoderInitial;
	
	@FindBy (id="txt_duplicate_charts")
	private WebElement txtDuplicateChart;
	
	@FindBy (id="txtviewcharge")
	private WebElement txtViewCharge;
	
	@FindBy (id="Txt_Received_Date")
	private WebElement txtRecieved_Date;
	
	@FindBy (id="RadioButtonList1_0")
	private WebElement radiobtnComplete;
	
	@FindBy (id="RadioButtonList1_1")
	private WebElement radiobtnHold;
	
	@FindBy (id="RadioButtonList1_2")
	private WebElement radiobtnIncomplete;
	
	@FindBy (id="RadioButtonList1_3")
	private WebElement radiobtnIVR;
	
	@FindBy (id="RadioButtonList1_4")
	private WebElement radiobtnDisregard;
	
	@FindBy (id="RadioButtonList1_5")
	private WebElement radiobtnNoCharge;
	
	@FindBy (id="txt_coder_comments")
	private WebElement txtCoderComment;
	
	@FindBy (id="btn_pause")
	private WebElement btnPause;
	
	@FindBy (id="ddl_break_reason")
	private WebElement ddPauseReason;
	
	@FindBy (id="txt_remarks")
	private WebElement txtPauseRemark;
	
	@FindBy (id="Btn_Coding_Resume")
	private WebElement btnResume;
	
	@FindBy (id="btn_submit")
	private WebElement btnSubmittrans;
	
	@FindBy (id="btn_Submit")
	private WebElement btnSubmitheldBatchSearch;
	
	@FindBy (id="btnSubmit")
	private WebElement btnSubmitheldDisregardSearch;
	
	@FindBy (id="acceptStatus")
	private WebElement btnAceptPopUp;
	
	// Add pending log lOCATORS	
	
	@FindBy (id="Label59")
	private WebElement lnkPendingLog;
	
	@FindBy (id="txt_pendinglog_acno")
	private WebElement txtPendingAcNo;
	
	@FindBy (id="txt_pendinglog_mr_ssn_no")
	private WebElement txtSsnNo;
	
	@FindBy (id="txt_pendinglog_dos")
	private WebElement txtDOS;
	
	@FindBy (id="txt_pendinglog_patient_name")
	private WebElement txtPatientName;
	
	@FindBy (id="ddl_pendinglog_log_type")
	private WebElement ddLogType;
	
	@FindBy (id="txt_pendinglog_coding_comments")
	private WebElement txtCodingComment;
	
	@FindBy (id="ddl_pendinglog_responsibility")
	private WebElement ddResponsibility;
	
	@FindBy (id="btn_save_pending_log")
	private WebElement btnSavePendingLog;
	
	@FindBy (id="btn_delete_pending_log")
	private WebElement btnDeleteLog;
	
	
	//Billing Log Details -lOCATORS
	
	@FindBy (id="Label60")
	private WebElement lnKBillableLog;
	
	@FindBy (id="txt_non_billable_log_acno")
	private WebElement txtNonBillableAcno;
		
	@FindBy (id="txt_non_billable_log_page_mr_ssn_no")
	private WebElement txtNonBillableSsnNo;
	
	@FindBy (id="txt_non_billable_log_dos")
	private WebElement txtNonBillableDOS;
	
	@FindBy (id="txt_non_billable_patient_name")
	private WebElement  txtNonBillablePatientName;
	
	@FindBy (id="txt_non_billable_phy_no")
	private WebElement txtNonBillablePhyNo;
	
	@FindBy (id="ddl_non_billable_log_type")
	private WebElement ddNonBillabletype;
	
	@FindBy (id="txt_non_billable_coding_remarks")
	private WebElement txtNonBillableCoderRemark;
	
	@FindBy (id="btn_save_non_billable_log")
	private WebElement btnNonBillableSaveLog;
	
	@FindBy (id="btn_delete_non_billable_log")
	private WebElement btnNonBillableDeleteLog;
	
	Actions act = new Actions(BrowserInitiated.driver);
	
	public codingInbox  click_CodingMenu( )  throws Exception
	{
	
		
/*List<WebElement> all=		BrowserInitiated.driver.findElements(By.tagName("a"));
System.out.println(all.size());		
JavascriptExecutor executor = (JavascriptExecutor)BrowserInitiated.driver;	


for(int i=0;i<=all.size()-1;i++) {
	System.out.println(all.get(i).getText());
executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", all.get(i));*/
		//utils.turnOnImplicitWaits();
		
		BrowserInitiated.driver.switchTo().frame("I1");
		Thread.sleep(2000);
		BrowserInitiated.logger.log(LogStatus.INFO, "Selecting Coding Menu :");
		//utils.waitForVisiblityOfElement(menuCoding);
		menuCoding.click();
		return this;

}
	
	public codingInbox  click_AllotmentMenu( )  throws Exception
	{
		BrowserInitiated.driver.switchTo().frame("I1");
		BrowserInitiated.logger.log(LogStatus.INFO, "Selecting Coding Allotment Menu :");
		Thread.sleep(2000);
		codingAllotMentMenu.click();
		
		
		return this;
	}
	

	public codingInbox  click_codingAllotmentTab( ) throws Exception
	{
		BrowserInitiated.driver.switchTo().frame("I3");
		Thread.sleep(2000);
		BrowserInitiated.logger.log(LogStatus.INFO, "Selecting Coding Allotment Tab :");
		codingAlllotmentTab.click();
		return this;
	}
	
	
	public codingInbox  click_HoldCodingbatch( ) throws Exception
	{
		BrowserInitiated.driver.switchTo().frame("I_qc");
		Thread.sleep(2000);
		BrowserInitiated.logger.log(LogStatus.INFO, "Selecting Hold Bactch TAB :");
		codingholdTab.click();
		return this;
	}
	
	public codingInbox  click_DisregardCodingbatch( ) throws Exception
	{
		BrowserInitiated.driver.switchTo().frame("I_qc");
		Thread.sleep(2000);
		BrowserInitiated.logger.log(LogStatus.INFO, "Selecting Disregard Bactch TAB :");
		codingDisregardTab.click();
		return this;
	}
	
	public codingInbox  click_InboxTab( ) throws Exception
	{
		//utils.turnOnImplicitWaits();
		BrowserInitiated.driver.switchTo().frame("I3");
		//BrowserInitiated.logger.log(LogStatus.INFO, "Selecting Coding inbox Tab :");
		Thread.sleep(2000);
		//utils.waitForVisiblityOfElement(tabInbox);
		codingTabInbox.click(); 
		return this;
	
	}
	
	public codingInbox  click_codingInbox( ) throws Exception
	{ 	
		//utils.turnOnImplicitWaits();
		BrowserInitiated.driver.switchTo().frame("I_coding");
		BrowserInitiated.logger.log(LogStatus.INFO, "Clicking coding Inbox Tab to fetch Batches :");
		Thread.sleep(2000);
		//utils.waitForVisiblityOfElement(lnkCodingInbox);
		lnkCodingInbox.click(); 
		return this;
	
	}
	
	public codingInbox  select_Location( String value) 
	{
		utils.select(selectLocation, value);
		return this;
	
	}

	public codingInbox  click_AcceptPopUp( ) throws Exception
	{
		//utils.turnOnImplicitWaits();
		BrowserInitiated.driver.switchTo().frame("I1");
		//BrowserInitiated.logger.log(LogStatus.INFO, "Selecting Coding inbox Tab :");
		Thread.sleep(2000);
		//utils.waitForVisiblityOfElement(tabInbox);
		btnAceptPopUp.click(); 
		return this;
	
	}
	
	
	public String click_OpenBatchName () throws Exception 
	{
		click_CodingMenu();
		click_InboxTab();
		click_codingInbox();
		
		
		BrowserInitiated.driver.switchTo().frame("I_inbox_sub_menu");
		
		utils.waitForVisiblityOfElement(selectTransactionId);
		String TransID = selectTransactionId.getText();
		BrowserInitiated.logger.log(LogStatus.INFO, "verifiying coder transaction for Batch Name. :  "+TransID+"");
		selectTransactionId.click(); 
		
		if(utils.AlertFound()) {
		System.out.println("Alert Found");
		BrowserInitiated.driver.switchTo().alert().accept();
		} return TransID;
	}
	
	
	public void click_BatchName (String Location, String TotalCodedCharts, String TotalPendedCharts, String DiscardedChart,String CoderInitials,String DuplciateCharts ,String ViewCharge,String CoderComment,
		String chartNo,String dos,String patientName,String sSN,String logType,String logPendingComment,String responsibility,String phy,String nonBillRemark,String nonBillingType) 
	{ 
		BrowserInitiated.driver.switchTo().frame("I_inbox_sub_menu");
		ddSelectLocation.sendKeys(Location);
		utils.waitForVisiblityOfElement(selectTransactionId);
		String TransID = selectTransactionId.getText();
		BrowserInitiated.logger.log(LogStatus.INFO, "verifiying coder transaction for Batch Name. :  "+TransID+"");
		selectTransactionId.click(); 
		
		if(utils.AlertFound()) {
		System.out.println("Alert Found");
		BrowserInitiated.driver.switchTo().alert().accept();
		}
		
		//BrowserInitiated.driver.switchTo().frame("I_inbox_sub_menu");
		txtTotalCodedChart.clear();
		txtTotalCodedChart.sendKeys(TotalCodedCharts);
		txtTotalPendedChart.clear();
		txtTotalPendedChart.sendKeys(TotalPendedCharts);
		txtDiscardedCharts.clear();
		txtDiscardedCharts.sendKeys(DiscardedChart);
		txtCoderInitial.sendKeys(CoderInitials);
		txtDuplicateChart.clear();
		txtDuplicateChart.sendKeys(DuplciateCharts);
		txtViewCharge.clear();
		txtViewCharge.sendKeys(ViewCharge);
		
		txtCoderComment.sendKeys(CoderComment);
		/* Pending log details*/
		BrowserInitiated.logger.log(LogStatus.INFO, "Adding painding log for Batch Name :  "+TransID+"");
		utils.captureScreenshot("Pending log");
		lnkPendingLog.click();
		txtPendingAcNo.sendKeys(chartNo);
		txtSsnNo.sendKeys(sSN);
		
		
		for (int i = 0; i < 10; i++)
		{
			act.sendKeys(Keys.ARROW_LEFT).build().perform();	
		}
		txtDOS.sendKeys(dos);
		txtPatientName.sendKeys(patientName);
		utils.select(ddLogType, logType);
		txtCodingComment.sendKeys(logPendingComment);
		utils.select(ddResponsibility, responsibility);
		btnSavePendingLog.click();
		
		/*Adding Non BillAble details*/
		BrowserInitiated.logger.log(LogStatus.INFO, "Adding Non Billable log for Batch Name :  "+TransID+"");
		lnKBillableLog.click();
		txtNonBillableAcno.sendKeys(chartNo);
		txtNonBillableSsnNo.sendKeys(sSN);
		
		
		for (int i = 0; i < 10; i++)
		{
			act.sendKeys(Keys.ARROW_LEFT).build().perform();	
		}
		txtNonBillableDOS.sendKeys(dos);
		txtNonBillablePatientName.sendKeys(patientName);
		txtNonBillablePhyNo.sendKeys(phy);
		utils.select(ddNonBillabletype, nonBillingType);
		txtNonBillableCoderRemark.sendKeys(nonBillRemark);
		btnNonBillableSaveLog.click();

		btnSubmittrans.click();
		
		
	
		/*
		String actsuccessMessage = BrowserInitiated.driver.findElement(By.xpath("//div[@class='bootstrap-growl alert alert-success']")).getText();
			String expSuccessMessage = "Account Completed";
		//new WebDriverWait(BrowserInitiated.driver,5).until(ExpectedConditions.visibilityOf(errorCloseCompletedMsg));
		if (actsuccessMessage.equals(expSuccessMessage)) {
			assertEquals(actsuccessMessage, expSuccessMessage, "Coder Transaction failed ");
			BrowserInitiated.logger.log(LogStatus.INFO, " coder transaction verified Batch No. :   "+selectTransactionId.getText()+"  Submitted Successfully" );
		}else {
			BrowserInitiated.logger.log(LogStatus.INFO, "Transaction Submission Failed");
 
		}	*/ 
		
		
		
	}
	
	public void client_Verify () 
	{
		String actClientName = "DEMO CLIENT";
		utils.waitForVisiblityOfElement(By.id("LblClient"));
		String expClientName = BrowserInitiated.driver.findElement(By.id("LblClient")).getText();

		if (actClientName.equals(expClientName))
		{
			assertEquals(actClientName, expClientName, "Failed");
			BrowserInitiated.logger.log(LogStatus.PASS, " Client Name in user Login verifed, Entered Value :  "+actClientName+ "   and found :  " +expClientName+ "");
		}else {
			BrowserInitiated.logger.log(LogStatus.FAIL, " Client Name in user Login not verifed  ");
		}

	}

		public void CoderTransactionPause (String Location,String pauseRemark, String pauseReason) 
		{
		try {
			
			
	
			BrowserInitiated.driver.switchTo().frame("I_inbox_sub_menu");
			ddSelectLocation.sendKeys(Location);
			utils.waitForVisiblityOfElement(selectTransactionId);
			String batchName= selectTransactionId.getText();
			 selectTransactionId.click(); 
			 
			if(utils.AlertFound()) {
				System.out.println("Alert Found");
				BrowserInitiated.driver.switchTo().alert().accept();
				}
			if (btnPause.isEnabled()) {
				btnPause.click();
				utils.captureScreenshot(pauseRemark);
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				 Date date =new Date();
				 String date1= dateFormat.format(date);
				
				utils.select(ddPauseReason, pauseReason);
				txtPauseRemark.sendKeys(pauseRemark);
				utils.wait(5000);
				btnResume.click();
				String date2= dateFormat.format(date);
				BrowserInitiated.logger.log(LogStatus.PASS, "Batch Name : "+batchName+" is paused at date "+date1+" for reason "+pauseReason+" and resumed at following date/time :"+date2+"");
			} else {
				
				BrowserInitiated.logger.log(LogStatus.FAIL, "Batch Pause is not working :Unable to pause batch"); 
				
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
			public void CoderTransHold (String Location, String TotalCodedCharts, String TotalPendedCharts, String DiscardedChart,String CoderInitials,String DuplciateCharts ,String ViewCharge,String CoderComment, String CodedDate) 
			{
				try {
					
					
					
					BrowserInitiated.driver.switchTo().frame("I_inbox_sub_menu");
					ddSelectLocation.sendKeys(Location);
					utils.waitForVisiblityOfElement(selectTransactionId);
					String BatchID = selectTransactionId.getText();
					BrowserInitiated.logger.log(LogStatus.INFO, "verifying coder transaction for Batch Name. :  "+BatchID+"");
					selectTransactionId.click(); 
					
					
					if(utils.AlertFound()) {
					System.out.println("Alert Found");
					BrowserInitiated.driver.switchTo().alert().accept();
					}
					
					//BrowserInitiated.driver.switchTo().frame("I_inbox_sub_menu");
					txtTotalCodedChart.clear();
					txtTotalCodedChart.sendKeys(TotalCodedCharts);
					txtTotalPendedChart.clear();
					txtTotalPendedChart.sendKeys(TotalPendedCharts);
					txtDiscardedCharts.clear();
					txtDiscardedCharts.sendKeys(DiscardedChart);
					txtCoderInitial.sendKeys(CoderInitials);
					txtDuplicateChart.clear();
					txtDuplicateChart.sendKeys(DuplciateCharts);
					txtViewCharge.clear();
					txtViewCharge.sendKeys(ViewCharge);
					radiobtnHold.click();
					txtCoderComment.sendKeys(CoderComment);
					//
					utils.captureScreenshot("HoldBatch");
					btnSubmittrans.click();
					BrowserInitiated.logger.log(LogStatus.INFO, "Login as TL and verifying the BatchID present under hold batch :");
					
					// login to TL with the help of Web cong change
					
					try {
						ExcelReader excelReader = new ExcelReader(Constants.xlFilePath);
						WebDriverUtils utils = new WebDriverUtils();
						utils.replceNtlg(excelReader.readExcelData(Constants.xlFilePath, "NTLG", 2,0));
						
					BrowserInitiated.driver.navigate().refresh();
					objLogin.click_Login("DEMO CLIENT");
					
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					click_AllotmentMenu();
					click_codingAllotmentTab();
					click_HoldCodingbatch();
					txtRecieved_Date.click();
					
					for (int j = 0; j < 10; j++)
					{
						act.sendKeys(Keys.ARROW_LEFT).build().perform();	
					}
					txtRecieved_Date.sendKeys(CodedDate);
					btnSubmitheldBatchSearch.click();
					
					
					List<WebElement> tableSize = BrowserInitiated.driver.findElements(By.xpath(".//*[@id='GridView1']"));
					
					String name = null;
					int row = tableSize.size();
					
					BrowserInitiated.logger.log(LogStatus.INFO, "Verifying the table data with respect to transaction data : ");
					System.out.println("size is " + (row - 1));			
						int i=0;
						for (i = 2; i < row; i++) {
							utils.waitFor(1000);
							WebElement tbldata = BrowserInitiated.driver.findElement(By.xpath(".//*[@id='GridView1_Lbl_BATCH_NAME_0']"));
							System.out.println("data is...." + tbldata.getText());
							
								
								if (tbldata.getText().equals(BatchID)) {
									assertEquals(tbldata.getText(), BatchID, "hold batch are not present, records in grid is not matching with the record submitted ");
									
									BrowserInitiated.logger.log(LogStatus.INFO, "Verifying Batch name submitted  : "+BatchID+"  and found Batch Name : "+tbldata.getText()+" ");
									utils.captureScreenshot(tbldata.getText());
								
									System.out.println("in " + (i - 1) + "th row Value matched");
									break;
								} else {
									continue;
								}
							}
							
		} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		
		
			public void CoderTransIncomplete (String Location, String TotalCodedCharts, String TotalPendedCharts, String DiscardedChart,String CoderInitials,String DuplciateCharts ,String ViewCharge,String CoderComment) 
			{
				try {
					/*BrowserInitiated.driver.switchTo().frame("I_inbox_sub_menu");
					ddSelectLocation.sendKeys(Location);
					utils.waitForVisiblityOfElement(selectTransactionId);
					String TransID = selectTransactionId.getText();
					BrowserInitiated.logger.log(LogStatus.INFO, "verifying coder transaction for Batch Name. :  "+TransID+"");
					selectTransactionId.click(); */
					
					
					if(utils.AlertFound()) {
					System.out.println("Alert Found");
					BrowserInitiated.driver.switchTo().alert().accept();
					}
					
					BrowserInitiated.driver.switchTo().frame("I_inbox_sub_menu");
					txtTotalCodedChart.clear();
					txtTotalCodedChart.sendKeys(TotalCodedCharts);
					txtTotalPendedChart.clear();
					txtTotalPendedChart.sendKeys(TotalPendedCharts);
					txtDiscardedCharts.clear();
					txtDiscardedCharts.sendKeys(DiscardedChart);
					txtCoderInitial.sendKeys(CoderInitials);
					txtDuplicateChart.clear();
					txtDuplicateChart.sendKeys(DuplciateCharts);
					txtViewCharge.clear();
					txtViewCharge.sendKeys(ViewCharge);
					radiobtnIncomplete.click();
					txtCoderComment.sendKeys(CoderComment);
					btnSubmittrans.click();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			public String CoderTransIvr (String Location, String TotalCodedCharts, String TotalPendedCharts, String DiscardedChart,String CoderInitials,String DuplciateCharts ,String ViewCharge,String CoderComment) 
			{
				String TransID= null;
				try {
					BrowserInitiated.driver.switchTo().frame("I_inbox_sub_menu");
					ddSelectLocation.sendKeys(Location);
					utils.waitForVisiblityOfElement(selectTransactionId);
					 TransID = selectTransactionId.getText();
					BrowserInitiated.logger.log(LogStatus.INFO, "verifying coder transaction for Batch Name. :  "+TransID+"");
					selectTransactionId.click(); 
					
					
					if(utils.AlertFound()) {
					System.out.println("Alert Found");
					BrowserInitiated.driver.switchTo().alert().accept();
					}
					
					//BrowserInitiated.driver.switchTo().frame("I_inbox_sub_menu");
					txtTotalCodedChart.clear();
					txtTotalCodedChart.sendKeys(TotalCodedCharts);
					txtTotalPendedChart.clear();
					txtTotalPendedChart.sendKeys(TotalPendedCharts);
					txtDiscardedCharts.clear();
					txtDiscardedCharts.sendKeys(DiscardedChart);
					txtCoderInitial.sendKeys(CoderInitials);
					txtDuplicateChart.clear();
					txtDuplicateChart.sendKeys(DuplciateCharts);
					txtViewCharge.clear();
					txtViewCharge.sendKeys(ViewCharge);
					radiobtnIVR.click();
					txtCoderComment.sendKeys(CoderComment);
					btnSubmittrans.click();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}return TransID;
			}
	
			public void DiregardCoderTrans (String Location, String TotalCodedCharts, String TotalPendedCharts, String DiscardedChart,String CoderInitials,String DuplciateCharts,
					String ViewCharge,String CoderComment, String todate, String fromdate) 
			{
				try {
					BrowserInitiated.driver.switchTo().frame("I_inbox_sub_menu");
					ddSelectLocation.sendKeys(Location);
					utils.waitForVisiblityOfElement(selectTransactionId);
					String TransID = selectTransactionId.getText();
					BrowserInitiated.logger.log(LogStatus.INFO, "verifying coder transaction for Batch Name. :  "+TransID+"");
					selectTransactionId.click(); 
					
					
					if(utils.AlertFound()) {
					System.out.println("Alert Found");
					BrowserInitiated.driver.switchTo().alert().accept();
					}
					
					//BrowserInitiated.driver.switchTo().frame("I_inbox_sub_menu");
					txtTotalCodedChart.clear();
					txtTotalCodedChart.sendKeys(TotalCodedCharts);
					txtTotalPendedChart.clear();
					txtTotalPendedChart.sendKeys(TotalPendedCharts);
					txtDiscardedCharts.clear();
					txtDiscardedCharts.sendKeys(DiscardedChart);
					txtCoderInitial.sendKeys(CoderInitials);
					txtDuplicateChart.clear();
					txtDuplicateChart.sendKeys(DuplciateCharts);
					txtViewCharge.clear();
					txtViewCharge.sendKeys(ViewCharge);
					radiobtnDisregard.click();
					txtCoderComment.sendKeys(CoderComment);
					utils.captureScreenshot("DisregardStatus");
					btnSubmittrans.click();
					
					
					
					
					BrowserInitiated.logger.log(LogStatus.INFO, "Login as TL and verifying the BatchID present under hold batch :");
					
					// login to TL with the help of Web cong change
					
					try {
						ExcelReader excelReader = new ExcelReader(Constants.xlFilePath);
						WebDriverUtils utils = new WebDriverUtils();
						utils.replceNtlg(excelReader.readExcelData(Constants.xlFilePath, "NTLG", 2,0));
							
					BrowserInitiated.driver.navigate().refresh();
					
					objLogin.click_Login("DEMO CLIENT");
					
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					click_AllotmentMenu();
					click_codingAllotmentTab();
					click_DisregardCodingbatch();
					
					txtToDate.click();

					for (int j = 0; j < 10; j++)
					{
						act.sendKeys(Keys.ARROW_LEFT).build().perform();	
					}
					
					txtToDate.sendKeys(todate);
					
					txtFromDate.click();
					for (int j = 0; j < 10; j++)
					{
						act.sendKeys(Keys.ARROW_LEFT).build().perform();	
					}
					
					
					txtToDate.sendKeys(fromdate);
					btnSubmitheldDisregardSearch.click();
					
					
				/*	List<WebElement> tableSize = BrowserInitiated.driver.findElements(By.xpath(".//*[@id='GridView1']"));
					
					String name = null;
					int row = tableSize.size();
					
					BrowserInitiated.logger.log(LogStatus.INFO, "Verifying the table data with respect to transaction data : ");
					System.out.println("size is " + (row - 1));			
						int i=0;
						String BatchID =null; 
						for (i = 2; i < row; i++) {
							utils.waitFor(1000);
							WebElement tbldata = BrowserInitiated.driver.findElement(By.xpath(".//*[@id='GridView1_Lbl_BATCH_NAME_0']"));
							System.out.println("data is...." + tbldata.getText());
							
								
								if (tbldata.getText().equals(BatchID)) {
									assertEquals(tbldata.getText(), BatchID, "hold batch are not present, records in grid is not matching with the record submitted ");
									
									BrowserInitiated.logger.log(LogStatus.INFO, "Verifying Batch name submitted  : "+BatchID+"  and found Batch Name : "+tbldata.getText()+" ");
									utils.captureScreenshot(tbldata.getText());
								
									System.out.println("in " + (i - 1) + "th row Value matched");
									break;
								} else {
									continue;
								}
							}*/
					
					
					
					
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			

			public void NochargeCoderTrans (String Location, String TotalCodedCharts, String TotalPendedCharts, String DiscardedChart,String CoderInitials,String DuplciateCharts ,String ViewCharge,String CoderComment) 
			{
				try {
					BrowserInitiated.driver.switchTo().frame("I_inbox_sub_menu");
					ddSelectLocation.sendKeys(Location);
					utils.waitForVisiblityOfElement(selectTransactionId);
					String TransID = selectTransactionId.getText();
					BrowserInitiated.logger.log(LogStatus.INFO, "verifying coder transaction for Batch Name. :  "+TransID+"");
					selectTransactionId.click(); 
					
					
					if(utils.AlertFound()) {
					System.out.println("Alert Found");
					BrowserInitiated.driver.switchTo().alert().accept();
					}
					
					//BrowserInitiated.driver.switchTo().frame("I_inbox_sub_menu");
					txtTotalCodedChart.clear();
					txtTotalCodedChart.sendKeys(TotalCodedCharts);
					txtTotalPendedChart.clear();
					txtTotalPendedChart.sendKeys(TotalPendedCharts);
					txtDiscardedCharts.clear();
					txtDiscardedCharts.sendKeys(DiscardedChart);
					txtCoderInitial.sendKeys(CoderInitials);
					txtDuplicateChart.clear();
					txtDuplicateChart.sendKeys(DuplciateCharts);
					txtViewCharge.clear();
					txtViewCharge.sendKeys(ViewCharge);
					radiobtnNoCharge.click();
					txtCoderComment.sendKeys(CoderComment);
					btnSubmittrans.click();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		
}
