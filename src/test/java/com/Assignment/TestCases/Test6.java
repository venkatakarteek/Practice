package com.Assignment.TestCases;

import org.testng.annotations.Test;

import com.Assignment.TestComponents.BaseClass;

public class Test6 extends BaseClass{

	@Test
	public void SixthTest() {
		System.out.println("Test6 Method Thread ID: " + Thread.currentThread().getId());
		homePage.ScrolltotheElement(homePage.test6Div);
		String cellValue = homePage.findValueOfCell(driver, 2, 2);
		System.out.println(cellValue);
	}
}
