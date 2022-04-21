package com.sdet.PageObjects;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet.testcases.BaseClass;
import com.sdet.utilities.Utilities;

public class LoginBankPage extends BaseClass {
	
	@FindBy (xpath="//input[@name='uid']")
	WebElement userText;
	
	String userTextString="//input[@name='uid']";
		
	//div[@id='dismiss-button']
	@FindBy (xpath="//div[@class='ns-4ut3k-e-15']//span[text()='Close']")
	WebElement closeBtn;
	
	@FindBy (xpath="//span[text()='Close']")
	WebElement newCloseBtn;
	
	
	@FindBy (xpath="//a[text()='Bank Project']")
	WebElement bankProjectLink;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passText;

	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement loginButton;
	
	public LoginBankPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickBankLink() {
		bankProjectLink.click();
	}
	public void clickCloseBtn() throws InterruptedException {
		Thread.sleep(5000);
		
		Actions action = new Actions(driver);
		action.doubleClick(bankProjectLink).perform();
		
		System.out.println("after alert");
	}
	public void bankLogin(String user, String pass) {
		System.out.println("entered in the bank login method");
		Utilities.ElementIsAvailable(driver,userTextString);
		userText.sendKeys(user);
		passText.sendKeys(pass);
		loginButton.click();
		
	}

}
