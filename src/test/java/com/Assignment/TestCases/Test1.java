package com.Assignment.TestCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Assignment.TestComponents.BaseClass;

public class Test1 extends BaseClass {

	@Test
	public void FirstTest() {
		System.out.println("Test1 Method Thread ID: " + Thread.currentThread().getId());

		homePage.checkIfElementIsDisplayed(homePage.emailElement);
		
		homePage.checkIfElementIsDisplayed(homePage.passwordElement);
		homePage.checkIfElementIsDisplayed(homePage.signInElement);
		homePage.emailElement.sendKeys("karteek@gmail.com");
		homePage.passwordElement.sendKeys("******");
	}

}
