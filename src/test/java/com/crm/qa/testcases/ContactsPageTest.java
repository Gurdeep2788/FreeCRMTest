package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String sheetName="contacts";
	
	public ContactsPageTest() {
		
		super();
	}

	@BeforeMethod
	public void Setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
		testUtil = new TestUtil();
	}

	@Test(priority = 1)
	public void contactsLabelTest() {
		
		contactsPage.verifyContactsPageLabel(); 
		Assert.assertTrue(contactsPage.verifyContactsPageLabel(),"Contacts label is missing on the page");
	}
	
	//@Test(priority=2)
	public void selectContactsTest(){
		
		contactsPage.selectContacts("Gurdeep Singh");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] =TestUtil.getTestData(sheetName);
		return data;
	}
	
	//@Test(priority=3,dataProvider="getCRMTestData")
	public void createContactTest(String firstname, String lastname, String middlename, String phn){
		contactsPage.clickOnNewContactButton();
		testUtil.handleNagBtn();
		contactsPage.createNewContact(firstname, lastname, middlename, phn);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
