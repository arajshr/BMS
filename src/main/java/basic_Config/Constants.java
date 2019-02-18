package basic_Config;

import java.text.SimpleDateFormat;

import java.util.Date;

public interface Constants {
	
    String browser ="chrome";
	
	String username = "AnkitS";
	String password = "jan@1234";
	
	String URL = "http://"+username+":"+password+"@10.1.2.85/bms-coding/";
	
/* variable for the connection string    */
    String connectionUrl = "jdbc:sqlserver://10.1.2.85;databaseName=BMS_CODING_Dev;"; 
    String dbUserName = "BMSCODING";
    String dbPassword = "bmsc";

	
/* Report folder */
	
	SimpleDateFormat folderDateFormat = new SimpleDateFormat("dd_MM_yyyy");
	SimpleDateFormat reportDateFormat = new SimpleDateFormat("HH_mm");
	
	Date currentDate = new Date(); 
	String year = new SimpleDateFormat("yyyy").format(currentDate);
	String month = new SimpleDateFormat("MM").format(currentDate);
	String day = new SimpleDateFormat("dd").format(currentDate);
		
	
	String reportFolderPath = ".\\Reports\\" + year + "\\" + month + "\\" + day + "\\ExtentReport_"+ reportDateFormat.format(new Date())+".html";	
	String screenShotFolderPath = ".\\Reports\\"+ year + "\\" + month + "\\" + day + "\\screenshots\\";
	
	// Extent report config file
		String configFilePath = ".\\src\\test\\resource\\extent-config.xml";	
		String config = "\\\\10.1.2.85\\Omega\\BMS-CODING\\BMSC_QA_Digitization\\web.config";	
		
		
	final String xlFilePath =".\\src\\test\\resource\\TestBms.xlsx";
	

	
}
