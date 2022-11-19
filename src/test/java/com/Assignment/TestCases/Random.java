package com.Assignment.TestCases;

import org.testng.annotations.Test;

import com.Assignment.TestComponents.BaseClass;

public class Random extends BaseClass {
	
	@Test
	public void randomTest() {
		homePage.checkDefaultSelectedValue();
		System.out.println("random");
	}
}
