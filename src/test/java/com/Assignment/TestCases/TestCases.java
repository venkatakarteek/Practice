package com.Assignment.TestCases;

import org.testng.annotations.Test;

import com.Assignment.PageObjects.HomePage;
import com.Assignment.TestComponents.BaseClass;
import com.aventstack.extentreports.Status;

public class TestCases extends BaseClass {
	@Test
	public void Test1() {

		
		HomePage homePage = new HomePage(driver);
		homePage.checkIfElementIsDisplayed(homePage.emailElement);
		test.log(Status.PASS, homePage.emailElement.getAttribute("type") + " element is present");
		homePage.checkIfElementIsDisplayed(homePage.passwordElement);
		test.log(Status.PASS, homePage.passwordElement.getAttribute("type") + " element is present");
		homePage.checkIfElementIsDisplayed(homePage.signInElement);
		test.log(Status.PASS, homePage.signInElement.getText() + " element is present");
		homePage.emailElement.sendKeys("karteek@gmail.com");
		homePage.passwordElement.sendKeys("******");

	}

	@Test
	public void Test2() {

		HomePage homePage = new HomePage(driver);
		homePage.checkValuesInListGroup();
		test.log(Status.PASS, "There are three values in the group");
		homePage.checkSecondListItem();
		test.log(Status.PASS, "Second list item's value is set to \"List Item 2\"");
		homePage.checkSecondListItemBadgeValue();
		test.log(Status.PASS, "Second list item's badge value is 6");

	}

	@Test
	public void Test3() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.ScrolltotheElement(homePage.dropDownOption);
		homePage.checkDefaultSelectedValue();
		test.log(Status.PASS, "\"Option 1\" is the default selected value");
		homePage.selectOption3();
	}

	@Test
	public void Test4() {

		HomePage homePage = new HomePage(driver);
		homePage.ScrolltotheElement(homePage.enabledButtonElement);
		homePage.checkIfFirstButtonisEnabled();
		test.log(Status.PASS, "First button is Enabled");
		homePage.checkIfButtonisDisabled(homePage.disabledButtonElement);
		test.log(Status.PASS, "Second button is Disabled");
	}

	@Test
	public void Test5() {

		HomePage homePage = new HomePage(driver);
		homePage.ScrolltotheElement(homePage.test5Div);
		homePage.ExplicitWait(homePage.test5Button);
		homePage.clickOnButton();
		test.log(Status.PASS, "Success message is displayed");
		homePage.checkIfButtonisDisabled(homePage.test5Button);
		test.log(Status.PASS, "Button is now disabled");
	}

	@Test
	public void Test6() {

		HomePage homePage = new HomePage(driver);
		homePage.ScrolltotheElement(homePage.test6Div);
		String cellValue = homePage.findValueOfCell(driver, 2, 2);
		test.log(Status.PASS, "Value of the cell is " + cellValue);
	}
}
