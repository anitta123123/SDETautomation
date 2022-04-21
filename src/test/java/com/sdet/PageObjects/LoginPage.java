package com.sdet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import com.sdet.testcases.BaseClass;
import com.sdet.utilities.Utilities;

public class LoginPage extends BaseClass {
	
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		System.out.println("login page method");
		}
	
	@FindBy(xpath="//li[@class='dropdown']//a[contains(text(),'Selenium') and @class='dropdown-toggle' ]")
	WebElement Seleniumlink;
		
	@FindBy(xpath="//a[text()='Login']")
	WebElement login;
	
	
	@FindBy(xpath="//a[text()='Bank Project']")
	WebElement bankDemoLink;
	
	String seleniumName="//li[@class='dropdown']//a[contains(text(),'Selenium') and @class='dropdown-toggle' ]";
	
	@FindBy(id="email")
	WebElement userText;
	
	@FindBy(id="passwd")
	WebElement userPaswrd;
	
	@FindBy(id="SubmitLogin")
	WebElement loginButton;
	
	@FindBy(xpath="//h3[text()='Successfully Logged in...']")
	WebElement homeText;
	
	public void loginAction(String name, String pswrd) throws InterruptedException  {
		
		Utilities.ElementIsAvailable(driver,seleniumName);
		Utilities.loginFromSeleniumAction(driver, Seleniumlink, login);
		userText.sendKeys(name);
		userPaswrd.sendKeys(pswrd);
		loginButton.click();
		logger.info("login button clicked");
		Assert.assertEquals(homeText.getText(), "Successfully Logged in...", "the login failed");	
		logger.info("login passed");
		
	}
	
	

}
