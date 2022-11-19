package com.Assignment.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	//going to refactor
	//rebasing
	public String baseURL = System.getProperty("user.dir") + "\\src\\main\\resource\\QE-index.html";
	public WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeMethod
	public void setup() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resource\\GlobalData.Properties");
		prop.load(fis);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browserName.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(baseURL);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public void ExplicitWait(WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(60));

		w.until(ExpectedConditions.visibilityOf(ele));
	}

	public void ScrolltotheElement(WebElement toelement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", toelement);
	}

	public void checkIfElementIsDisplayed(WebElement elementtoCheck) {
		Assert.assertTrue(elementtoCheck.isDisplayed());
	}

	public static ExtentReports setupExtentReport() {

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		String reportPath = System.getProperty("user.dir") + "/Reports/ExecutionReport_" + actualDate + ".html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();

		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Tester Name", "Karteek");

		sparkReporter.config().setDocumentTitle("Test Execution Report");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("QE Test Report");

		return extent;
	}

}
