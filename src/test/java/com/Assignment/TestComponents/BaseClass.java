package com.Assignment.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.bouncycastle.asn1.mozilla.PublicKeyAndChallenge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.Assignment.PageObjects.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Properties properties;
	protected static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public HomePage homePage;
	

	public WebDriver browsersetup() throws IOException {

		properties = new Properties();
		String filePath = System.getProperty("user.dir") + "/src/main/resource/GlobalData.Properties";
		FileInputStream fis = new FileInputStream(filePath);
		properties.load(fis);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: properties.getProperty("browser");

		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());

		}

		else if (browserName.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());

		} else if (browserName.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());

		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	@BeforeClass(alwaysRun = true)
	public HomePage LaunchApplication() throws IOException {
		System.out.println("Before Method Thread ID: " + Thread.currentThread().getId());
		homePage = new HomePage(browsersetup());
		homePage.goTo();
		return homePage;
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws IOException {

		// driver.close();
		getDriver().quit();
		System.out.println("After Method Thread ID: " + Thread.currentThread().getId());
		tlDriver.remove();
	}

}
