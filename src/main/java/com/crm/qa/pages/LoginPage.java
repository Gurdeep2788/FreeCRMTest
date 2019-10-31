/*
 * 
 * Author - Gurdeep Singh
 * 
 */

package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//private static final HomePage HomePage = null;

	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement LoginBtn;
	
	@FindBy(name="email")
	WebElement UN;
	
	@FindBy(name="password")
	WebElement PWD;
	
	@FindBy(xpath="//div[contains(@class,'blue submit button')]")
	WebElement Submit;
	
	@FindBy(xpath="//a[@href='https://freecrm.com']/following::span[contains(text(),'free')]")
	WebElement CRMImage;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitile()
	{
		return driver.getTitle();
	}
	
	public boolean validateLoginPageImage()
	{
		return CRMImage.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		LoginBtn.click();
		UN.sendKeys(un);
		PWD.sendKeys(pwd);
		Submit.click();
		return new HomePage();
	}

}
