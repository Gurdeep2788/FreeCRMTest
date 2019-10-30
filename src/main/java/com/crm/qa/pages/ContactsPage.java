package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement ContactsLabel;

	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement NewContactButton;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement LastName;

	@FindBy(xpath = "//input[@name='middle_name']")
	WebElement MiddleName;

	@FindBy(xpath = "//input[@placeholder='Number']")
	WebElement Number;

	@FindBy(xpath = "//button[@class='ui linkedin button'][contains(text(),'Save')]")
	WebElement SaveBtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsPageLabel() {
		return ContactsLabel.isDisplayed();
	}

	public void selectContacts(String name) {
		driver.findElement(By.xpath("//td[contains(text(),'" + name + "')]")).click();
	}

	public void clickOnNewContactButton() {
		NewContactButton.click();
	}

	public void createNewContact(String FN, String LN, String MN, String Phn) {
		FirstName.sendKeys(FN);
		LastName.sendKeys(LN);
		MiddleName.sendKeys(MN);
		Number.sendKeys(Phn);
		SaveBtn.click();
	}

}
