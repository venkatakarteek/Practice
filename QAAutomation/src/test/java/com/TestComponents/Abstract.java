package com.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.codec.http.multipart.FileUpload;

public class Abstract {

	public WebDriver driver;

	public Abstract(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HashMap<String, String> getTestData(String sheetname, String environmentname) throws IOException {

		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		HashMap<String, String> hashMap = new HashMap<String, String>();

		FileInputStream fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "\\EfficientlyTestData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

		int sheetCount = workbook.getNumberOfSheets();

		for (int i = 0; i < sheetCount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetname)) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rowIterator = sheet.iterator();
				Row firstRow = rowIterator.next();
				Iterator<Cell> ce = firstRow.cellIterator();
				int k = 0;
				int coloumn = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					keys.add(value.getStringCellValue());
					if (value.getStringCellValue().equalsIgnoreCase("Environment")) {
						coloumn = k;
					}
					k++;
				}
				while (rowIterator.hasNext()) {
					Row r = rowIterator.next();
					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(environmentname)) {
						Iterator<Cell> cv = r.cellIterator();

						while (cv.hasNext()) {
							Cell c = cv.next();
							values.add(c.getStringCellValue());
						}
					}
				}
			}
		}
		for (int i = 0; i < keys.size(); i++) {
			hashMap.put(keys.get(i), values.get(i));
		}
		return hashMap;

	}

	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElements(List<WebElement> elements) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	@SuppressWarnings("deprecation")
	public void uploadtheFile() throws IOException {
		
		Runtime.getRuntime().exec("C:\\Users\\kosan\\eclipse-workspace\\QAAutomation\\FileUpload.exe");
	}
	
	
}
