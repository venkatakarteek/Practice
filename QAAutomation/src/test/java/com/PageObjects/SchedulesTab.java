package com.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestComponents.Abstract;

public class SchedulesTab extends Abstract {

	public WebDriver driver;

	public SchedulesTab(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "mat-tab-link-7")
	WebElement rooms;

	@FindBy(xpath = "//ds-project-search-by[@id='ds-project-search-by-1']//following-sibling::button")
	WebElement createnewroom;

	@FindBy(xpath = "//button[@role='menuitem']")
	List<WebElement> roomTypes;

	@FindBy(xpath = "//button[contains(@class,'mat-dialog-close-action')]//parent::mat-dialog-header//following-sibling::mat-dialog-content/div/div/div/div")
	List<WebElement> subRoomTypes;

	@FindBy(xpath = "(//div[normalize-space()='SELECT THE SPACES IN THIS ROOM.'])[2]//following-sibling::div")
	List<WebElement> roomSpace;

	@FindBy(xpath = "(//span[normalize-space()='Save'])[2]")
	WebElement save;

	@FindBy(xpath = "(//button[@type='button'])[28]")
	WebElement addFinishArea;

	@FindBy(xpath = "//button[@class='mat-focus-indicator ds-schedule-rooms-finish-area-row__finish-id-item-action mat-button mat-button-base']")
	WebElement finishItem;

	@FindBy(xpath = "//span[normalize-space()='Create new project finish']")
	WebElement createNewProjectFinish;

//	@FindBy(xpath = "(//div[@class='mat-form-field-infix ng-tns-c84-126'])[1]")
//	WebElement finishList;

	@FindBy(xpath = "//button[contains(text(),'Wood Flooring')]")
	WebElement woodFlooring;

	@FindBy(xpath = "(//button[@class='mat-focus-indicator ds-finish-details__select-item-button mat-button mat-button-base ds-finish-details__select-item-button-access ng-star-inserted'])[1]")
	WebElement selectItemFromCatalogue;

	@FindBy(xpath = "(//mat-icon[@role='img'][normalize-space()='arrow_drop_down'])[5]")
	WebElement type;

	@FindBy(xpath = "//div[normalize-space()='Wood']")
	WebElement wood;

	@FindBy(xpath = "//div[normalize-space()='SKU']//following-sibling::div")
	List<WebElement> SKU;

	@FindBy(xpath = "(//div[normalize-space()='Assign to finish area'])[1]")
	WebElement assignToFinishArea;

	public void clickOnRooms() {
		waitForElement(rooms);
		rooms.click();
	}

	public void createNewRoom() {
		waitForElement(createnewroom);
		createnewroom.click();
	}

	public void selectRoom(String roomName) throws InterruptedException {
		Thread.sleep(1000);
		WebElement correctroom = roomTypes.stream()
				.filter(room -> room.getText().toLowerCase().contains(roomName.toLowerCase())).findFirst().orElse(null);
		correctroom.click();
		Thread.sleep(1000);
	}

	public void selectSubRoom(String subroomName) throws InterruptedException {
		WebElement correctsubRoom = subRoomTypes.stream()
				.filter(room -> room.getText().toLowerCase().contains(subroomName.toLowerCase())).findFirst()
				.orElse(null);
		correctsubRoom.click();
		Thread.sleep(1000);
	}

	public void selectRoomSpace(String roomSpaceString) throws InterruptedException {
		WebElement spaceToAdd = roomSpace.stream()
				.filter(space -> space.getText().toLowerCase().contains(roomSpaceString.toLowerCase())).findFirst()
				.orElse(null);
		spaceToAdd.click();
		Thread.sleep(1000);
	}

	public void clickOnSave() {
		save.click();
	}

	public void addFinishArea(String finishTypeString) throws InterruptedException {
		waitForElement(addFinishArea);
		addFinishArea.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[normalize-space()='" + finishTypeString + "'])")).click();
	}

	public void clickOnFinishItem() {
		waitForElement(finishItem);
		finishItem.click();
	}

	public void CreateProjectFinish() {
		waitForElement(createNewProjectFinish);
		createNewProjectFinish.click();
		waitForElement(woodFlooring);
		woodFlooring.click();
	}

	public void selectFinishItem() {
		waitForElement(selectItemFromCatalogue);
		selectItemFromCatalogue.click();
	}

	public void selectType() throws InterruptedException {
		Thread.sleep(2000);
		type.click();
		waitForElement(wood);
		wood.click();
	}

	public void addSKUtoProject(String skuname) throws InterruptedException {

		waitForElements(SKU);
		
		driver.findElement(By.xpath("(//span[contains(text(),'Add to project')])[1]")).click();
//		Thread.sleep(2000);
//		for (WebElement i : SKU) {
//
//			if (i.getText().equalsIgnoreCase(skuname)) {
//				Thread.sleep(2000);
//				i.findElement(By.xpath("//preceding::button[1]")).click();
//				break;
//			}
//		}

	}

	public void Assign() {
		waitForElement(assignToFinishArea);
		assignToFinishArea.click();
	}

}
