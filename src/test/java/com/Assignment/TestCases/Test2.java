package com.Assignment.TestCases;

import org.testng.annotations.Test;

import com.Assignment.TestComponents.BaseClass;

public class Test2 extends BaseClass{

	
	@Test
	public void SecondTest() {
		System.out.println("Test2 Method Thread ID: " + Thread.currentThread().getId());
		homePage.checkValuesInListGroup();
		homePage.checkSecondListItem();
		homePage.checkSecondListItemBadgeValue();
	}
}
