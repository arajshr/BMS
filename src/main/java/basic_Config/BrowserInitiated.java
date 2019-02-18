package basic_Config;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import codingPageObjRepo.Login;
import dB_Reference.ConnectDb;
import excelLibrary.ExcelReader;
import excelLibrary.WebDriverUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserInitiated {
	

	

		WebDriverUtils utils = new WebDriverUtils();
		public static ExcelReader excel;
		
		public static WebDriver driver;

		//public static ConnectDb db = null;
		public static ExtentReports extent;
		public static ExtentTest logger;
		public static String sheetName="TestData";
		

		@BeforeSuite

		public void startReports() 
		{
			extent = new ExtentReports(Constants.reportFolderPath);
			extent.loadConfig(new File(Constants.configFilePath));
		}

		@BeforeTest
		public void LaunchBrowser() throws IOException {
		//	db = new ConnectDb();
			excel = new ExcelReader(Constants.xlFilePath);

			switch (Constants.browser) {
			case "mozilla":
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				System.out.println("Firfox browser Initiated");
				break;

			case "chrome":
				System.setProperty("webdriver.chrome.driver", "./src//test//resource//chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				System.out.println("Chrome Browser Initiated");
				break;

			case "IE":
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				System.out.println("IE browser Initiated");
				break;

			default:
				break;

			}

			driver.get(Constants.URL);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Application URL loaded");
			

		}

		@BeforeMethod
		public void ExcelLoad(Method result)
		{
			int executableRowIndex = excel.isExecutable(result.getName());

			if (executableRowIndex == 0) {
				throw new SkipException("Not Execuatable");

			} else if (executableRowIndex < 0) {
				System.out.println("Run Mode Not Set -Method [" + result.getName() + "]");
				throw new SkipException("RUN Mode Not set");
			}
			
			driver.get(Constants.URL);
			
			logger = extent.startTest(result.getName());	
			System.out.println("report Started");
			logger.log(LogStatus.INFO, "Opening the Browser " );
			
			logger.log(LogStatus.INFO, "Logged in with : Demo Client");
			Login objLogin = PageFactory.initElements(driver, Login.class);
			
			objLogin.click_Login("DEMO CLIENT");

		}

		@AfterMethod
		public void endLogger(ITestResult result) throws Exception 
		{

			if(result.getStatus() == ITestResult.FAILURE)
			{
				logger.log(LogStatus.FAIL, result.getThrowable().getMessage());
			}
			
			Login objLogin = PageFactory.initElements(driver, Login.class);
			objLogin.click_Logout();		
			
			logger.log(LogStatus.INFO, "Logged out , Browser Closed");
			extent.endTest(logger);
			extent.flush();	

			Thread.sleep(3000);

		}

		@AfterTest
		public void CloseBrowser() {
			driver.close();
			System.out.println("browser Closed");
		}

		@AfterSuite
		public void CloseReport() {
			System.out.println("Report Closed");

			//db.close();
			System.out.println("Connection closed");

		}

}
