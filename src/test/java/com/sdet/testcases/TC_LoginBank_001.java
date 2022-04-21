package com.sdet.testcases;

import org.testng.annotations.Test;

import com.sdet.PageObjects.LoginBankPage;
import com.sdet.PageObjects.LoginPage;
import com.sdet.utilities.ConFigUtilites;

public class TC_LoginBank_001 extends BaseClass {
	
	LoginPage login;
	ConFigUtilites conf;
	LoginBankPage logBank;
	
	@Test
	public void loginBankScreen() throws InterruptedException {
		logger=report.createTest("Login BankScreen");
		//login= new LoginPage(driver);
		conf = new ConFigUtilites();
		//login.loginAction(conf.getUsername(), conf.getPasrd());
		logBank= new LoginBankPage(driver);
		logBank.clickBankLink();
		Thread.sleep(2000);
		logBank.clickCloseBtn();
		System.out.println("reached before the login method in inside the bank test");
		logBank.bankLogin(conf.getUsername(), conf.getPasrd());
		
		
	}
	

}
