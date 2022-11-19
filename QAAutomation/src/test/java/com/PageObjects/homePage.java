package com.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestComponents.Abstract;

public class homePage extends Abstract {

	public WebDriver driver;

	public homePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Create new project']")
	WebElement createNewProject;

	@FindBy(css = "form[class*='mat-dialog-component']")
	WebElement newProjectForm;

	@FindBy(id = "mat-input-1")
	WebElement projectName;

	@FindBy(id = "mat-input-2")
	WebElement streetAddress;

	@FindBy(id = "mat-input-3")
	WebElement city;

	@FindBy(id = "mat-input-4")
	WebElement stateElement;

	@FindBy(id = "mat-input-5")
	WebElement postalCode;

	@FindBy(id = "mat-input-6")
	WebElement projectTypeElement;

	@FindBy(xpath = "//mat-option[@role='option']/span/div")
	List<WebElement> states;

	@FindBy(xpath = "//mat-option[@role='option']/span/div")
	List<WebElement> projectType;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement save;

	public Construction createNewProject(String name, String address, String cityname, String statename, String postalCodeInput,
			String projectTypeName) {
		waitForElement(createNewProject);
		createNewProject.click();
		waitForElement(newProjectForm);
		projectName.sendKeys(name);
		streetAddress.sendKeys(address);
		city.sendKeys(cityname);
		stateElement.click();
		for (WebElement l : states) {
			if (l.getText().equalsIgnoreCase(statename)) {
				scrollToElement(l);
				l.click();
			}
		}
		postalCode.sendKeys(postalCodeInput);
		projectName.click();
		for (WebElement t : projectType) {
			if (t.getText().equalsIgnoreCase(projectTypeName)) {
				scrollToElement(t);
				t.click();
			}
		}
		save.click();
		Construction construction=new Construction(driver);
		return construction;
	}
}
