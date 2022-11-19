package com.Assignment.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Assignment.PageObjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;

	public ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<WebDriver>();
	public HomePage homePage;

	public ThreadLocal<WebDriver> setup() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resource\\GlobalData.Properties");
		prop.load(fis);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
			threadSafeDriver.set(new ChromeDriver());

		}

		else if (browserName.contains("edge")) {
			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
			threadSafeDriver.set(new EdgeDriver());
		} else if (browserName.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
			threadSafeDriver.set(new FirefoxDriver());
		}

		return threadSafeDriver;

	}

	public WebDriver initializeBrowser() throws IOException {

		driver = setup().get();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeMethod
	public HomePage LaunchApplication() throws IOException {
		driver = initializeBrowser();

		homePage = new HomePage(driver);
		homePage.goTo();
		return homePage;
	}

	@AfterMethod
	public void tearDown() throws IOException {

		driver.close();

	}

}
