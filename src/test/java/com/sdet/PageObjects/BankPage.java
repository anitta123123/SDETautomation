package com.sdet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet.testcases.BaseClass;

public class BankPage extends BaseClass {
	
	public BankPage(WebDriver driver){
		
		PageFactory.initElements(driver,this);
	} 
	
	@FindBy (xpath="//a[text()='New Customer']")
	WebElement newCusLink;
	
	@FindBy (xpath="//input[@name='name']")
	WebElement nameText;
	
	@FindBy (xpath="//td[text()='Gender']//following-sibling::td//input[1]")
	WebElement genderMaleButton;
	
	@FindBy (xpath="//td[text()='Gender']//following-sibling::td//input[2]")
	WebElement genderFemaleButton; 
	
	@FindBy (xpath="//input[@id='dob']")
	WebElement dobtext; 
	
	@FindBy (xpath="//textarea[@name='addr']")
	WebElement addrtext; 
	
	@FindBy (xpath="//input[@name='city']")
	WebElement citytext; 
	
	@FindBy (xpath="//input[@name='state']")
	WebElement statetext; 
	
	@FindBy (xpath="//input[@name='pinno']")
	WebElement pintext; 
	
	@FindBy (xpath="//input[@name='telephoneno']")
	WebElement teltext;  
		
	@FindBy (xpath="//input[@name='emailid']")
	WebElement emailtext;  
	
	@FindBy (xpath="//input[@name='sub']")
	WebElement submitButn; 
	
	public void clickNewCustomer() {
		newCusLink.click();
	}
	
	public void inputCustName(String name) {
		 nameText.sendKeys(name);
	}
	
	public void inputGender(String gend) {
		if (gend.equals("male")) {
			genderMaleButton.click();
			
		}
		else {
			genderFemaleButton.click();
			
		}	
	}
	
	public void address(String addres) {
		addrtext.sendKeys(addres);
		
	}
	
	public void inputCity(String city) {
		citytext.sendKeys(city);
		
	}
	
	public void inputState(String state) {
		statetext.sendKeys(state);
		
	}
	public void inputPIN(int pin) {
		pintext.sendKeys(String.valueOf(pin));
		
	}
	
	public void inputPhone(int phone) {
		teltext.sendKeys(String.valueOf(phone));
		
	}
	public void inputEmail(String email) {
		emailtext.sendKeys(email);
		
	}
	
	public void inputdob(int dd, int mm, int yyyy) {
		
		dobtext.sendKeys(String.valueOf(dd));
		dobtext.sendKeys(String.valueOf(mm));
		dobtext.sendKeys(String.valueOf(yyyy));
		
	}
	
	
	
	
	
	
	
	
	
	

}
