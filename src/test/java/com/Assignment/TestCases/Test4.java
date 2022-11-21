package com.Assignment.TestCases;

import org.testng.annotations.Test;

import com.Assignment.TestComponents.BaseClass;

public class Test4 extends BaseClass {

	@Test
	public void FourthTest() {
		System.out.println("Test4 Method Thread ID: " + Thread.currentThread().getId());
		homePage.ScrolltotheElement(homePage.enabledButtonElement);
		homePage.checkIfFirstButtonisEnabled();
		homePage.checkIfButtonisDisabled(homePage.disabledButtonElement);
	}
}
