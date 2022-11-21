package com.Assignment.TestCases;

import org.testng.annotations.Test;

import com.Assignment.TestComponents.BaseClass;

public class Test3 extends BaseClass {

	@Test
	public void ThridTest() throws InterruptedException {
		System.out.println("Test3 Method Thread ID: " + Thread.currentThread().getId());
		homePage.ScrolltotheElement(homePage.dropDownOption);
		homePage.checkDefaultSelectedValue();
		homePage.selectOption3();
	}
}
