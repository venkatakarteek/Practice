package com.TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;

import com.PageObjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LoginPage loginPage;

	
	public WebDriver initializeDriver() {
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public void tearDown() {
		driver.close();
	}

	public LoginPage LaunchApplication(String url) {
		driver=initializeDriver();
		loginPage = new LoginPage(driver);
		loginPage.goTo(url);
		return loginPage;
	}
}
