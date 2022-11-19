package com.TestCases;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObjects.Construction;
import com.PageObjects.SchedulesTab;
import com.PageObjects.homePage;
import com.TestComponents.Abstract;
import com.TestComponents.BaseTest;

public class FunctionalTest extends BaseTest {

	@Test(dataProvider = "qadata")
	public void test01(HashMap<String, String> input) throws InterruptedException, IOException {

		LaunchApplication(input.get("URL"));
		homePage homePage = loginPage.loginApplication(input.get("Email"), input.get("Password"));
		Construction construction = homePage.createNewProject("SampleProject", "W 64th Pl", "Chicago", "WA", "60638",
				"Commercial");
		construction.clickOnSkip();
		construction.uploadFile();
		construction.clickOnSkipAutoNaming();
		SchedulesTab schedulesTab = construction.clickOnSchedules();
		schedulesTab.clickOnRooms();
		schedulesTab.createNewRoom();
		schedulesTab.selectRoom("Kitchen");
		schedulesTab.selectSubRoom("Kitchen");
		schedulesTab.selectRoomSpace("Vestibule");
		schedulesTab.clickOnSave();
		schedulesTab.addFinishArea("Floor");
		schedulesTab.clickOnFinishItem();
		schedulesTab.CreateProjectFinish();
		schedulesTab.selectFinishItem();
		schedulesTab.selectType();
		schedulesTab.addSKUtoProject("13229");
		schedulesTab.Assign();
	}

	@DataProvider
	public Object[][] qadata() throws IOException {
		Abstract abstract1 = new Abstract(driver);
		HashMap<String, String> dataHashMap = abstract1.getTestData("Credentials", "QA");
		return new Object[][] { { dataHashMap } };
	}
}
