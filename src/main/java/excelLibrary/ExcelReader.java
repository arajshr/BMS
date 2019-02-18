package excelLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import basic_Config.BrowserInitiated;

public class ExcelReader  {

	FileInputStream fis;
	XSSFWorkbook xssfWorkbook;
	XSSFSheet sheet;
	FileOutputStream fos;
	

	public ExcelReader(String xlpath) throws IOException {
		try {
			fis = new FileInputStream(xlpath);
			xssfWorkbook = new XSSFWorkbook(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ExcelReader() {
		try {
			xssfWorkbook = new XSSFWorkbook();
			sheet = setSheet("TestData");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	
	public int isExecutable(String TestCaseID)

	{
		sheet = setSheet(BrowserInitiated.sheetName);
		int rowIndex = 1;
		int lastRowNo = sheet.getLastRowNum();
		for (rowIndex = 1; rowIndex <= lastRowNo; rowIndex++) {
			int colIndex = 0;
			for (int i = 0; i < sheet.getRow(rowIndex).getLastCellNum(); i++) {
				if (sheet.getRow(0).getCell(i).getStringCellValue().trim().equals("TC_ID")) {
					colIndex = i;
					break;
				}
			}

			if (readValue(sheet, rowIndex, colIndex).equals(TestCaseID)) {

				String sRunMode = readValue(sheet, rowIndex, "RUN_MODE");
				if (sRunMode == null) {
					return -1;
				}

				else if (sRunMode.equalsIgnoreCase("Y")) {

					return rowIndex;
				}

				else if (sRunMode.equalsIgnoreCase("N")) {
					return -1;
				}
			}
		}
		return 0;
	}

	


	public void closeExcel(String xlpath) {
		try {

			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int isExecutable(XSSFSheet sheet, String TestCaseID)

	{

		int rowIndex = 1;
		int lastRowNo = sheet.getLastRowNum();
		for (rowIndex = 1; rowIndex <= lastRowNo; rowIndex++) {
			int colIndex = 0;
			for (int i = 0; i < sheet.getRow(rowIndex).getLastCellNum(); i++) {
				if (sheet.getRow(0).getCell(i).getStringCellValue().trim().equals("TC_ID")) {
					colIndex = i;
					break;
				}
			}

			if (readValue(sheet, rowIndex, colIndex).equals(TestCaseID)) {

				String sRunMode = readValue(sheet, rowIndex, "RUN_MODE");
				if (sRunMode == null) {
					return -1;
				}

				else if (sRunMode.equalsIgnoreCase("Y")) {

					return rowIndex;
				}

				else if (sRunMode.equalsIgnoreCase("N")) {
					return -1;
				}
			}
		}
		return 0;
	}

	public XSSFSheet setSheet(String sheetName) {

		return xssfWorkbook.getSheet(sheetName);
	}

	public int getRowCount(XSSFSheet sheet)

	{

		return sheet.getLastRowNum();

	}

	public int getColoumnCount(XSSFSheet sheet, int rowIndex)

	{
		return sheet.getRow(rowIndex).getLastCellNum();

	}

	public String readValue(XSSFSheet sheet, int rowIndex, int cellNum) {
		try {
			XSSFRow row = sheet.getRow(rowIndex);
			XSSFCell cell = row.getCell(cellNum);
			return new DataFormatter().formatCellValue(cell);
			
		} catch (Exception e) {

		}
		return null;
	}

	public String readValue(XSSFSheet sheet, int rowIndex, String colName) {
		int colIndex = 0;
		for (int i = 0; i < sheet.getRow(rowIndex).getLastCellNum(); i++) {
			if (sheet.getRow(0).getCell(i).getStringCellValue().trim().equals(colName)) {
				colIndex = i;
				break;
			}
		}
		return readValue(sheet, rowIndex, colIndex);
	}

	public void writeValue(XSSFSheet sheet, int rowIndex, String colName, String value) {

		XSSFRow row = sheet.getRow(rowIndex);
		int colIndex = 0;
		if (row == null)
			row = sheet.createRow(rowIndex);
		for (int i = 0; i < sheet.getRow(rowIndex).getLastCellNum(); i++) {
			if (sheet.getRow(0).getCell(i).getStringCellValue().trim().equals(colName)) {
				colIndex = i;
				break;
			}
		}
		XSSFCell cell = row.getCell(colIndex);
		if (cell == null)
			cell = row.createCell(colIndex);

		cell.setCellValue(value);
	}

	public void saveAs(String xlpath) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(xlpath);
		xssfWorkbook.write(fileOut);
		fileOut.close();

		// Closing the workbook
		
	}

	public void writeExcelData(String xlPath, String sheet, int rowNum, int colNum, String data) throws IOException {

		try {
			FileInputStream fis = new FileInputStream(xlPath);
			xssfWorkbook = new XSSFWorkbook(fis);
			Sheet s = xssfWorkbook.getSheet(sheet);
			int lastRowNum = s.getLastRowNum();
			Row row;
			if (rowNum <= lastRowNum)
				row = s.createRow(rowNum);
			else {
				throw new Exception("Please give a valid data........");
			}

			fos = new FileOutputStream(xlPath);

			row.createCell(colNum).setCellValue(data);
			xssfWorkbook.write(fos);
		} catch (

		EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			fis.close();
			fos.close();
		}

	}

	public String readExcelData(String xlPath, String sheet, int rowNum, int colNum) {
		String data = null;
		try {
			FileInputStream fis = new FileInputStream(xlPath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			Sheet s = workbook.getSheet(sheet);
			int lastRowNum = s.getLastRowNum();
			System.out.println(lastRowNum);
			Row row;
			if (rowNum <= lastRowNum) {
				row = s.getRow(rowNum);
			} else {
				throw new Exception("Please give a valid data........");
			}
			try {
				data = row.getCell(colNum).getStringCellValue();
			} catch (IllegalStateException e) {
				data = Double.toString(row.getCell(colNum).getNumericCellValue());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				fis.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return data;

	}

}
