package excelLibrary;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import basic_Config.BrowserInitiated;
import basic_Config.Constants;

public class WebDriverUtils {

	public void replceNtlg(String role) {

		try {
			File file = new File(Constants.config);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "", oldtext = "";
			String newText = null;
			while ((line = reader.readLine()) != null) {
				oldtext += line + "\r\n";
			}
			String oldNtlg = null;
			String newNtlg;
			if (role.equals("QC")) {
				try {
					ExcelReader excelReader = new ExcelReader(Constants.xlFilePath);
					newNtlg = excelReader.readExcelData(Constants.xlFilePath, "NTLG", 3, 1);
					
					if(find(excelReader.readExcelData(Constants.xlFilePath, "NTLG", 2, 1)))
					{
						oldNtlg = excelReader.readExcelData(Constants.xlFilePath, "NTLG", 2, 1);
						System.out.println("OldNtlg :"+oldNtlg);
					}
					else if(find(excelReader.readExcelData(Constants.xlFilePath, "NTLG", 1, 1)))
					{
						oldNtlg = excelReader.readExcelData(Constants.xlFilePath, "NTLG", 1, 1);
						System.out.println("OldNtlg :"+oldNtlg);
					}
					else
					{
						oldNtlg = newNtlg;
					}
					
					newText = oldtext.replace(oldNtlg, newNtlg);

				} catch (IOException e) {

					e.printStackTrace();
				}
			} else if (role.equals("TL")) {
				try {
					ExcelReader excelReader = new ExcelReader(Constants.xlFilePath);
					newNtlg = excelReader.readExcelData(Constants.xlFilePath, "NTLG", 2, 1);
					
					if(find(excelReader.readExcelData(Constants.xlFilePath, "NTLG", 3, 1)))
					{
						oldNtlg = excelReader.readExcelData(Constants.xlFilePath, "NTLG", 3, 1);
						System.out.println("OldNtlg :"+oldNtlg);
					}
					else if(find(excelReader.readExcelData(Constants.xlFilePath, "NTLG", 1, 1)))
					{
						oldNtlg = excelReader.readExcelData(Constants.xlFilePath, "NTLG", 1, 1);
						System.out.println("OldNtlg :"+oldNtlg);
					}
					else
					{
						oldNtlg = newNtlg;
					}
					newText = oldtext.replace(oldNtlg, newNtlg);

				} catch (IOException e) {

					e.printStackTrace();
				}
			} else if (role.equals("CODER")) {
				try {
					ExcelReader excelReader = new ExcelReader(Constants.xlFilePath);
					newNtlg = excelReader.readExcelData(Constants.xlFilePath, "NTLG", 1, 1);

					if(find(excelReader.readExcelData(Constants.xlFilePath, "NTLG", 3, 1)))
					{
						oldNtlg = excelReader.readExcelData(Constants.xlFilePath, "NTLG", 3, 1);
						System.out.println("OldNtlg :"+oldNtlg);
					}
					else if(find(excelReader.readExcelData(Constants.xlFilePath, "NTLG", 2, 1)))
					{
						oldNtlg = excelReader.readExcelData(Constants.xlFilePath, "NTLG", 2, 1);
						System.out.println("OldNtlg :"+oldNtlg);
					}
					else
					{
						oldNtlg = newNtlg;
					}
					newText = oldtext.replace(oldNtlg, newNtlg);

				} catch (IOException e) {

					e.printStackTrace();
				}
			}

			FileWriter writer = new FileWriter(file);
			writer.write(newText);
			writer.close();
		} catch (Exception e) {
			BrowserInitiated.logger.log(LogStatus.INFO, "Class: Utils, Mehtod: replceNtlg <br>" + e.getMessage());
		}
	}
	  public static boolean find(String searchString) {
	        boolean result = false;
	        Scanner in = null;
	        try {
	        	File file = new File(Constants.config);
	            in = new Scanner(new FileReader(file));
	            while(in.hasNextLine() && !result) {
	                result = in.nextLine().indexOf(searchString) >= 0;
	            }
	        }
	        catch(IOException e) {
	            e.printStackTrace();      
	        }
	        finally {
	            try { in.close() ; } catch(Exception e) { /* ignore */ }  
	        }
	        return result;
	    }

	/**
	 * Waits untils loading image disappears [max time limit - 5 min]
	 */
	public void waitForPageToLoad() {
		try {
			new WebDriverWait(BrowserInitiated.driver, 300000)
					.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("")));
		} catch (Exception e) {
			BrowserInitiated.logger.log(LogStatus.INFO,
					"Class: Utils, Mehtod: waitForPageToLoad <br>" + e.getMessage());
		}
	}

	public boolean AlertFound() {
		boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(BrowserInitiated.driver, 20);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
		} catch (TimeoutException eTO) {
			foundAlert = false;
		}
		return foundAlert;
	}

	public boolean waitForPresenceOfElement(By findBy) {
		try {
			new WebDriverWait(BrowserInitiated.driver, 20).until(ExpectedConditions.presenceOfElementLocated(findBy));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public boolean waitForVisiblityOfElement(By findBy) {
		try {
			new WebDriverWait(BrowserInitiated.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(findBy));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public boolean waitForVisiblityOfElement(WebElement element) {
		try {
			new WebDriverWait(BrowserInitiated.driver, 20).until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public Boolean waitForInvisiblityOfElement(By findBy) {
		try {
			new WebDriverWait(BrowserInitiated.driver, 20)
					.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	/**
	 * waits for specified time[time in milliseconds]
	 * 
	 * @param timeInMilliSeconds
	 */

	public void waitFor(int timeInMilliSeconds) {
		try {
			Thread.sleep(timeInMilliSeconds);
		} catch (InterruptedException e) {
			BrowserInitiated.logger.log(LogStatus.INFO, "Class: Utils, Mehtod: waitFor <br>" + e.getMessage());
		}
	}

	/***
	 * Moves mouse pointer to specified web element
	 * 
	 * @param element
	 */
	public void moveMousePointerTo(WebElement element) {
		try {
			Actions act = new Actions(BrowserInitiated.driver);
			act.moveToElement(element).build().perform();
		} catch (Exception e) {
			BrowserInitiated.logger.log(LogStatus.INFO,
					"Class: Utils, Method: moveMousePointerTo <br>" + e.getMessage());
		}

	}

	/**
	 * Returns first selected option's visible text, from dropdown
	 * 
	 * @param element
	 * @return string value
	 */
	public String getSelectedOption(WebElement element) {
		return new Select(element).getFirstSelectedOption().getAttribute("textContent");
	}

	/**
	 * Returns list options from dropdown
	 * 
	 * @param element
	 * @return
	 */
	public List<String> getOptions(WebElement element) {
		try {
			ArrayList<String> value = new ArrayList<>();

			List<WebElement> options = new Select(element).getOptions();

			int i = 0;
			if (options.get(0).getText().toLowerCase().contains("select")) {
				i = 1; // neglect first option [-- Select --]
			}

			for (; i < options.size(); i++) {
				value.add(options.get(i).getText().trim().replace("\n", ""));
			}
			return value;
		} catch (Exception e) {
			BrowserInitiated.logger.log(LogStatus.INFO, "Class: Utils, Mehtod: get_Options  <br>" + e.getMessage());
		}
		return null;

	}

	/**
	 * Selects dropdown option by visible text, matches whole text
	 * 
	 * @param element
	 * @param visibleText
	 */
	public void select(WebElement element, String visibleText) {
		select(element, visibleText, true);
		waitForPageToLoad();
	}

	/**
	 * Selects dropdown option by visible text
	 * 
	 * @param element
	 * @param visibleText
	 * @param matchWholeText
	 */
	public void select(WebElement element, String visibleText, boolean matchWholeText) {
		try {
			if (matchWholeText) {
				new Select(element).selectByVisibleText(visibleText);
			} else {
				Select dropDown = new Select(element);

				List<WebElement> options = dropDown.getOptions();
				for (int i = 0; i < options.size(); i++) {
					if (options.get(i).getText().contains(visibleText)) {
						dropDown.selectByIndex(i);
					}
				}
			}
		} catch (Exception e) {
			BrowserInitiated.logger.log(LogStatus.INFO, "Class: Utils, Method: select <br>" + e.getMessage());
		}
	}

	/**
	 * Select dropdown option by index
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		try {
			new Select(element).selectByIndex(index);
		} catch (Exception e) {
			BrowserInitiated.logger.log(LogStatus.INFO, "Class: Utils, Method: select <br>" + e.getMessage());
		}

	}

	/**
	 * Adds screenshot to the extent report
	 * 
	 * @param fileName
	 */
	public void captureScreenshot(String fileName) {
		try {
			SimpleDateFormat reportDateFormat = new SimpleDateFormat("HH_mm");
			fileName = fileName + "_" + reportDateFormat.format(new Date());

			File srcFile = ((TakesScreenshot) BrowserInitiated.driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File(Constants.screenShotFolderPath + fileName + ".png");
			FileUtils.copyFile(srcFile, destFile);

			String screenPath = new File((Constants.screenShotFolderPath).substring(2) + fileName + ".png")
					.getAbsolutePath();
			BrowserInitiated.logger.log(LogStatus.INFO, BrowserInitiated.logger.addScreenCapture(screenPath));

		} catch (IOException e) {
			BrowserInitiated.logger.log(LogStatus.INFO, "Class: Utils, Mehtod: save_Screenshot <br>" + e.getMessage());
		}
	}

	private void turnOffImplicitWaits() {
		BrowserInitiated.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	private void turnOnImplicitWaits() {
		BrowserInitiated.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * Returns true when element is found
	 * 
	 * @param findBy
	 * @return
	 */
	public boolean isElementPresent(By findBy) {
		try {
			turnOffImplicitWaits();
			BrowserInitiated.driver.findElement(findBy);
			turnOnImplicitWaits();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		} finally {
			turnOnImplicitWaits();
		}
	}

	/**
	 * Returns true when element is found
	 * 
	 * @param element
	 * @return
	 */
	public boolean isElementPresent(WebElement element) {
		try {
			turnOffImplicitWaits();
			element.getTagName();
			turnOnImplicitWaits();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		} finally {
			turnOnImplicitWaits();
		}

	}

	/**
	 * Finds element within parent element and returns true when found
	 * 
	 * @param element
	 * @param findBy
	 * @return
	 */
	public boolean isElementPresent(WebElement element, By findBy) {
		try {
			turnOffImplicitWaits();
			element.findElement(findBy);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		} finally {
			turnOnImplicitWaits();
		}
	}

	/**
	 * Checks whether alert is present or not
	 * 
	 * @return true when alert is present
	 */
	public boolean isAlertPresent() {
		WebDriverWait wait = new WebDriverWait(BrowserInitiated.driver, 10);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (TimeoutException eTO) {
			return false;
		}
	}

	/**
	 * Switches to alert
	 * 
	 * @return reference of alert class
	 */
	public Alert switchToAlert() {
		try {
			return BrowserInitiated.driver.switchTo().alert();

		} catch (NoAlertPresentException Ex) {
			return null;
		}
	}

	/**
	 * Accept alert
	 * 
	 * @param alert
	 */
	public void acceptAlert(Alert alert) {
		alert.accept();
	}

	/**
	 * Dismiss alert
	 * 
	 * @param alert
	 */
	public void dismissAlert(Alert alert) {
		alert.dismiss();
	}

	/**
	 * Returns alert text
	 * 
	 * @param alert
	 * @return
	 */
	public String get_AlertText(Alert alert) {
		return alert.getText();
	}

	public Boolean waitForElementClickable(WebElement wb) {
		WebDriverWait wait = new WebDriverWait(BrowserInitiated.driver, 20);
		if (wait.until(ExpectedConditions.elementToBeClickable(wb)) != null)
			return true;
		else
			return false;
	}

	public void highLighterMethod(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BrowserInitiated.driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: #d2efba;  ;font-weight: bold  ');", element);
	}

	public void unHighLighterMethod(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BrowserInitiated.driver;
		js.executeScript("arguments[0].setAttribute('style', ' ');", element);
	}

	public String currentDate() {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss a");
			Date dateobj = new Date();
			System.out.println(df.format(dateobj));
			return df.format(dateobj);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}
		return null;
	}
}
