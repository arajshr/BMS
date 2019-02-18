package codingPageObjRepo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;

import basic_Config.BrowserInitiated;
import excelLibrary.WebDriverUtils;

public class Feedback {
	WebDriverUtils utils = new WebDriverUtils();

	@FindBy(id = "Image2")
	private WebElement menuCoding;

	@FindBy(id = "id2")
	private WebElement tabFeedBack;

	@FindBy(xpath = ".//*[@id='navigationDiv']/tbody/tr/td[1]/a")
	private WebElement tabQcFeedBack;

	@FindBy(id = "btn_Ack")
	private WebElement btnAcknowledge;

	@FindBy(id = "GridView1_chkAll_0")
	private WebElement Click_CheckBox;

	@FindBy(xpath = ".//*[@id='GridView1']/tbody/tr[2]/td[4]/a")
	private WebElement Click_BatchName;

	@FindBy(id = "txt_Escalate_comments")
	private WebElement txtComment;

	@FindBy(id = "btn_Escalate")
	private WebElement btnEclate;

	public Feedback click_CodingMenu() throws Exception

	{
		BrowserInitiated.driver.switchTo().frame("I1");
		Thread.sleep(2000);
		// utils.waitForVisiblityOfElement(menuCoding);
		menuCoding.click();
		return this;

	}

	public Feedback click_tabFeedBack() throws Exception {
		// utils.turnOnImplicitWaits();
		BrowserInitiated.driver.switchTo().frame("I3");
		Thread.sleep(2000);
		// utils.waitForVisiblityOfElement(tabInbox);
		tabFeedBack.click();
		return this;

	}

	public Feedback click_link_QcFeedBack() throws Exception {
		// utils.turnOnImplicitWaits();
		BrowserInitiated.driver.switchTo().frame("I_coding");
		Thread.sleep(2000);
		// utils.waitForVisiblityOfElement(lnkCodingInbox);
		tabQcFeedBack.click();
		return this;

	}

	public void acknowledgeQcFeedBack() throws Exception {

		try {
			BrowserInitiated.driver.switchTo().frame("I_feedback_sub_menu");
			
			BrowserInitiated.logger.log(LogStatus.INFO, "Selecting the Batch name and submiting to Acknowledgment : "+Click_BatchName.getText()+"");
			Thread.sleep(2000);
		String batchName =	Click_BatchName.getText();
			Click_CheckBox.click();
			btnAcknowledge.click();

			if (utils.AlertFound()) {
				System.out.println("Alert Found");
			String acknowledgeFeedbackAlert =	BrowserInitiated.driver.switchTo().alert().getText();
			
			 utils.captureScreenshot("acknowledgeFeedbackAlert");
				BrowserInitiated.driver.switchTo().alert().accept();
			
				BrowserInitiated.logger.log(LogStatus.PASS, "Batch Name "+batchName+" feedback submitted successfully to Acknowlegment ");
				
			}else {
				BrowserInitiated.logger.log(LogStatus.FAIL, "Batch Name "+batchName+"  not submitted  to Acknowlegment");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
	}

	public void EscalateQcFeedBack (String coderComment) 
	{
		try {
			
			
			BrowserInitiated.driver.switchTo().frame("I_feedback_sub_menu");
			if (Click_BatchName.isSelected()) {
				Click_BatchName.click();
				BrowserInitiated.logger.log(LogStatus.INFO, "Selecting the Batch name and submiting : "+Click_BatchName.getText()+"");
				txtComment.sendKeys(coderComment);
				btnEclate.click();
				BrowserInitiated.logger.log(LogStatus.PASS, "Batch Name "+Click_BatchName.getText()+" submitted successfully to Escalation ");
			}else {
				BrowserInitiated.logger.log(LogStatus.FAIL, "Batch Name "+Click_BatchName.getText()+" Not submitted to Escalation ");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
		
	}
	
	
	
}
