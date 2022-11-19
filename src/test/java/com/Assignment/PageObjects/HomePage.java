package com.Assignment.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Assignment.TestComponents.AbstractClass;

public class HomePage extends AbstractClass {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "inputEmail")
	public WebElement emailElement;

	@FindBy(id = "inputPassword")
	public WebElement passwordElement;

	@FindBy(xpath = "//button[contains(@class,'btn-block')]")
	public WebElement signInElement;

	@FindBy(css = "div[id='test-2-div'] ul li")
	List<WebElement> listItems;

	@FindBy(css = "button[id='dropdownMenuButton']")
	public WebElement dropDownOption;

	@FindBy(css = "div[class='dropdown-menu show'] a:nth-child(3)")
	WebElement option3;

	@FindBy(xpath = "//div[@id='test-4-div']/button[1]")
	public WebElement enabledButtonElement;

	@FindBy(xpath = "//div[@id='test-4-div']/button[2]")
	public WebElement disabledButtonElement;

	@FindBy(css = "button[id='test5-button']")
	public WebElement test5Button;

	@FindBy(id = "test5-alert")
	WebElement successMessagElement;

	@FindBy(xpath = "//table[@class='table table-bordered table-dark']/tbody/tr")
	List<WebElement> cellsElements;

	@FindBy(id = "test-5-div")
	public WebElement test5Div;

	@FindBy(id = "test-6-div")
	public WebElement test6Div;
	
	public void goTo() {
		driver.get(System.getProperty("user.dir") + "\\src\\main\\resource\\QE-index.html");
	}
	
	public void checkValuesInListGroup() {

		Assert.assertEquals(listItems.size(), 3);
	}

	public void checkSecondListItem() {

		if (listItems.get(1).getText().contains("List Item 2")) {
			Assert.assertTrue(true);
		}
	}

	public void checkSecondListItemBadgeValue() {
		Assert.assertEquals("6",
				driver.findElement(By.cssSelector("div[id='test-2-div'] ul li:nth-child(2) span")).getText());
	}

	public void checkDefaultSelectedValue() {
		Assert.assertEquals("Option 1", dropDownOption.getText());
	}

	public void selectOption3() throws InterruptedException {
		dropDownOption.click();
		Thread.sleep(1000);
		option3.click();
	}

	public void checkIfFirstButtonisEnabled() {
		Assert.assertTrue(enabledButtonElement.isEnabled());
	}

	public void checkIfButtonisDisabled(WebElement button) {
		Assert.assertFalse(button.isEnabled());
	}

	public void clickOnButton() {
		test5Button.click();
		Assert.assertEquals(successMessagElement.getText(), "You clicked a button!");
	}

	public String findValueOfCell(WebDriver driver, int row, int col) {
		String[] c;
		String cellValue = null;
		for (int i = 0; i <= 2; i++) {
			if (i == row) {
				c = cellsElements.get(i).getText().split(" ");
				for (int j = 0; j <= 2; j++) {
					if (j == col) {
						cellValue = c[j];
					}
				}
			}

		}
		return cellValue;

	}
}
