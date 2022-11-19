package com.Assignment.TestComponents;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenersImplementation extends BaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName() + " is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, result.getMethod().getMethodName() + " is failed");
		test.log(Status.FAIL, result.getThrowable());

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

		extent = setupExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush();

	}

}
