package com.Assignment.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Assignment.TestComponents.BaseClass;

public class TestCases extends BaseClass {

	@Test
	public void Test1() {

		System.out.println("Test1 Method Thread ID: " + Thread.currentThread().getId());
		homePage.checkIfElementIsDisplayed(homePage.emailElement);
		homePage.checkIfElementIsDisplayed(homePage.passwordElement);
		homePage.checkIfElementIsDisplayed(homePage.signInElement);
		homePage.emailElement.sendKeys("karteek@gmail.com");
		homePage.passwordElement.sendKeys("******");

	}

	@Test
	public void Test2() {

		System.out.println("Test2 Method Thread ID: " + Thread.currentThread().getId());
		homePage.checkValuesInListGroup();
		homePage.checkSecondListItem();
		homePage.checkSecondListItemBadgeValue();

	}

	@Test
	public void Test3() throws InterruptedException {

		System.out.println("Test3 Method Thread ID: " + Thread.currentThread().getId());
		homePage.ScrolltotheElement(homePage.dropDownOption);
		homePage.checkDefaultSelectedValue();
		homePage.selectOption3();
	}

	@Test
	public void Test4() {

		System.out.println("Test4 Method Thread ID: " + Thread.currentThread().getId());
		homePage.ScrolltotheElement(homePage.enabledButtonElement);
		homePage.checkIfFirstButtonisEnabled();
		homePage.checkIfButtonisDisabled(homePage.disabledButtonElement);

	}

	@Test
	public void Test5() {

		System.out.println("Test5 Method Thread ID: " + Thread.currentThread().getId());
		homePage.ScrolltotheElement(homePage.test5Div);
		homePage.ExplicitWait(homePage.test5Button);
		homePage.clickOnButton();
		homePage.checkIfButtonisDisabled(homePage.test5Button);

	}

	@Test
	public void Test6() throws IOException {

		System.out.println("Test6 Method Thread ID: " + Thread.currentThread().getId());
		homePage.ScrolltotheElement(homePage.test6Div);
		String cellValue = homePage.findValueOfCell(driver, 2, 2);
		System.out.println(cellValue);

	}
}
