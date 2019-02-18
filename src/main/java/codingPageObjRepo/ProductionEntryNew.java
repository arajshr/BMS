package codingPageObjRepo;

import static org.testng.Assert.assertEquals;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;

import basic_Config.BrowserInitiated;
import excelLibrary.WebDriverUtils;

public class ProductionEntryNew {

	WebDriverUtils utils = new WebDriverUtils();
	
	@FindBy (id="Image2")
	private WebElement menuCoding;
	
	@FindBy (id="id1")
	private WebElement tabInbox;
	
	@FindBy (id="A4")
	private WebElement linkProductionEntry;
	
	@FindBy (id="Ddldate")
	private WebElement ddSelectDate;
	
	@FindBy (id="btnsubmit")
	private WebElement btnSearchProdEntry;
	
	@FindBy (id="GVProductionentry_Txtpdneditprdhrs_0")
	private WebElement txtPdnHrs;
	
	@FindBy (id="GVProductionentry_Txtpdneditprdmin_0")
	private WebElement txtPdnMin;
	
	@FindBy (id="GVProductionentry_txtpdneditidlehrs_0")
	private WebElement txtIdleHrs;
	
	@FindBy (id="GVProductionentry_txtpdneditildemin_0")
	private WebElement txtIdlemin;
	
	@FindBy (id="btnpdnsubmit")
	private WebElement btnSubmit;
	
	@FindBy (id="GVProductionentry_ddlidleremarks_0")
	private WebElement txtIdleDescription;
	
	public ProductionEntryNew  click_CodingMenu( )  throws Exception
			
	{
		BrowserInitiated.driver.switchTo().frame("I1");
		Thread.sleep(2000);
		//utils.waitForVisiblityOfElement(menuCoding);
		menuCoding.click();
		return this;

	}
	
	public ProductionEntryNew  click_InboxTab( ) throws Exception
	{
		//utils.turnOnImplicitWaits();
		BrowserInitiated.driver.switchTo().frame("I3");
		Thread.sleep(2000);
		//utils.waitForVisiblityOfElement(tabInbox);
		tabInbox.click(); 
		return this;
	
	}
	
	public ProductionEntryNew  click_link_ProductionEntry( ) throws Exception
	{ 	
		//utils.turnOnImplicitWaits();
		BrowserInitiated.driver.switchTo().frame("I_coding");
		Thread.sleep(2000);
		//utils.waitForVisiblityOfElement(lnkCodingInbox);
		linkProductionEntry.click(); 
		return this;
	
	}
	

	public void click_ProductionEntry(String pdnHour, String pdnMin, String idleHrs, String idleMin,String idleDescription) 
	{
		try {
			// TODO Auto-generated method stub
			BrowserInitiated.driver.switchTo().frame("I_inbox_sub_menu");
			txtPdnHrs.sendKeys(pdnHour);
			txtPdnMin.sendKeys(pdnMin);
			txtIdleHrs.sendKeys(idleHrs);
			txtIdlemin.sendKeys(idleMin);
			utils.wait(2000);
			utils.select(txtIdleDescription, idleDescription);
			btnSubmit.click();
			
			String actMsg = BrowserInitiated.driver.findElement(By.id("1")).getText();
			String expMesg = "Production Entry Submitted Successfully";
			
			if (actMsg.equals(expMesg)) {
				assertEquals(actMsg, expMesg, "Production Entry not working fine");
				BrowserInitiated.logger.log(LogStatus.INFO, "Entring production entry ");
				
				
			} else {
				BrowserInitiated.logger.log(LogStatus.INFO, "Error on production entry Page  :");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
