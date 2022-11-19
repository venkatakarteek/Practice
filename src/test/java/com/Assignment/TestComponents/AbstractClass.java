package com.Assignment.TestComponents;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AbstractClass {

	public WebDriver driver;

	public AbstractClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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

}
