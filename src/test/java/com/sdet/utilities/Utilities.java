package com.sdet.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdet.testcases.BaseClass;

public class Utilities extends BaseClass{
	
	WebDriverWait wait;
	
	public static void ElementIsAvailable(WebDriver driver,String seleniumlink){
		
		System.out.println("got inside wait"+driver+"hii"+seleniumlink);
		new WebDriverWait(driver, Duration.ofSeconds(5000)).until(ExpectedConditions.
				visibilityOfElementLocated(By.xpath(seleniumlink)));
		System.out.println("reached");
	}
	
	public static void loginFromSeleniumAction(WebDriver driver, WebElement element, WebElement loginElement) throws InterruptedException {
		
		Actions action= new Actions(driver);
		System.out.println("acitons"+driver);
		action.moveToElement(element).click().build().perform();
		
		System.out.println("acitons123"+element);
		//ElementIsAvailable(driver, loginElement);
		Thread.sleep(3000);
		loginElement.click();
		
		
	}

	

}
