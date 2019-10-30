package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage; 
	DealsPage dealsPage;
	TasksPage tasksPage;
	public HomePageTest() {
		super();
		loginPage = new LoginPage();
		homePage = new HomePage();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String title=homePage.validateHomePageTitile();
		Assert.assertEquals(title,"Cogmento CRM","HomePage title not matched");
	}
	
	@Test(priority=2)
	public void homePageUserNameTest(){
		boolean flag = homePage.verifyCorrectUsername();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		contactsPage =homePage.clickOnContactsLink();
		
	}
	
	@Test(priority=4)
	public void verifyDealsLinkTest()
	{
		dealsPage =homePage.clickOnDealsLink();
	}
	
	@Test(priority=5)
	public void verifyTaskssLinkTest()
	{
		tasksPage =homePage.clickOnTasksLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
