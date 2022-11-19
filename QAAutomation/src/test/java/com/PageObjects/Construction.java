package com.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.TestComponents.Abstract;

public class Construction extends Abstract {

	public WebDriver driver;

	public Construction(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//div[normalize-space()='Welcome to your new project!']")
	WebElement newProjectPopUp;
	
	@FindBy(xpath = "//span[normalize-space()='Skip this step']")
	WebElement skip;
	
	@FindBy(id = "#mat-tab-link-1")
	WebElement plans;
	
	@FindBy(css = "span[class*='ds-file-uploader']")
	WebElement fileUpload;
	
	@FindBy(xpath = "//span[normalize-space()='Skip auto naming']")
	WebElement skipAutoNaming;
	
	@FindBy(id = "mat-tab-link-2")
	WebElement schedules;
	
	 
	
	public void clickOnSkip() throws InterruptedException {
		waitForElement(newProjectPopUp);
		skip.click();
		Thread.sleep(3000);
	}
	
	public void clickOnPlans() {
		plans.click();
	}
	
	public void uploadFile() throws IOException, InterruptedException {
		Thread.sleep(2000);
		fileUpload.click();
		Thread.sleep(3000);
		uploadtheFile();
	}
	
	public void clickOnSkipAutoNaming() {
		waitForElement(skipAutoNaming);
		skipAutoNaming.click();
	}
	
	public SchedulesTab clickOnSchedules() {
		waitForElement(schedules);
		schedules.click();
		SchedulesTab schedulesTab=new SchedulesTab(driver);
		return schedulesTab;
	}
}
