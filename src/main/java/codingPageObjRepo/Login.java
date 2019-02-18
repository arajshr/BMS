package codingPageObjRepo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basic_Config.BrowserInitiated;
import excelLibrary.WebDriverUtils;

public class Login {
	
	WebDriverUtils utils = new WebDriverUtils();
	@FindBy (id ="DDL_Client_Names")
	private WebElement  ddSelectClient;
	
	@FindBy (id ="I1")
	private WebElement  iframe;
	
	@FindBy (xpath =".//*[@id='UpdatePanel1']")
	private WebElement  ilframe;
	
	@FindBy (id ="Btn_Submit")
	private WebElement btnLogin;
	
	@FindBy (xpath =".//*[@id='LBNSignOut']")
	private WebElement btnLogout;
	
	public Login click_Login(String value)
	{
		
		try 
		{
			BrowserInitiated.driver.switchTo().frame(iframe);
			new WebDriverWait(BrowserInitiated.driver, 5).until(ExpectedConditions.visibilityOf(ddSelectClient));
			utils.select(ddSelectClient, value);
			btnLogin.click();
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		finally 
		{
			BrowserInitiated.driver.switchTo().defaultContent();
		}
		return this;
		
	}
	
	
	public Login click_Logout ()
	{
		try 
		{
			BrowserInitiated.driver.switchTo().frame(ilframe);
			new WebDriverWait(BrowserInitiated.driver, 5).until(ExpectedConditions.visibilityOf(btnLogout));
			btnLogout.click();
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		finally 
		{
			BrowserInitiated.driver.switchTo().defaultContent();
		}
		return this;
	}
	
	
	
			public void LoginSuccess() 
			{
				
					String userName = BrowserInitiated.driver.findElement(By.id("txt_Codername")).getText();
					String expectedUserName = "";
					assertEquals(userName, expectedUserName);
					
					if (userName==expectedUserName)
					{
						System.out.println( "User Login Success" + userName );
					}else {
						
						System.out.println( "failed Login" + userName );
					
					}
				
					
			}
		
	
		public void logOutSuccess()
		{
			String Expectedlogoutmessage = "Thank You!";
			String actualLogoutMessage =BrowserInitiated.driver.findElement(By.xpath("//h1[text() ='Thank You!']")).getText();
			assertEquals(actualLogoutMessage, Expectedlogoutmessage);
			if (Expectedlogoutmessage==actualLogoutMessage)
			{
				System.out.println( "Logout Success");
			}else 
			{
				System.out.println("Test Fail");
				
			}
			
		
		}

}
