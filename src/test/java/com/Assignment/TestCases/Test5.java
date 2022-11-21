package com.Assignment.TestCases;

import org.testng.annotations.Test;

import com.Assignment.TestComponents.BaseClass;

public class Test5 extends BaseClass{

	@Test
	public void FifthTest() {
		System.out.println("Test5 Method Thread ID: " + Thread.currentThread().getId());
		homePage.ScrolltotheElement(homePage.test5Div);
		homePage.ExplicitWait(homePage.test5Button);
		homePage.clickOnButton();
		homePage.checkIfButtonisDisabled(homePage.test5Button);
	}
}
