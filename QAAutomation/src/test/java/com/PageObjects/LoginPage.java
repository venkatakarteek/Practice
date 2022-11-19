package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestComponents.Abstract;

public class LoginPage extends Abstract {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[formcontrolname='email']")
	WebElement email;

	@FindBy(css = "input[formcontrolname='password']")
	WebElement password;

	@FindBy(xpath = "//input[@formcontrolname='password']//parent::div/following::div[1]/button")
	WebElement signIn;

	public void goTo(String url) {
		driver.get(url);
	}

	public homePage loginApplication(String emailId, String passWordString) {
		email.sendKeys(emailId);
		password.sendKeys(passWordString);
		signIn.click();
		homePage homePage=new homePage(driver);
		return homePage;
	}

}
