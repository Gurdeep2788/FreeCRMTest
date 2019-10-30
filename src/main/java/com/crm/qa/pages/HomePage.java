package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

    
	@FindBy(xpath = "//span[@class='user-display']")
	WebElement userNameLabel;
	@CacheLookup

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasksNameLabel;
	
	

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitile() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {

		contactsLink.click();
		return new ContactsPage();
	}	 
	
	public DealsPage clickOnDealsLink() {

		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {

		dealsLink.click();
		return new TasksPage();
	}

	
}
