package com.sdet.testcases;

import org.testng.annotations.Test;

import com.sdet.PageObjects.LoginPage;
import com.sdet.utilities.ConFigUtilites;

public class TC_Login_001 extends BaseClass {
	
	public LoginPage login;
	public ConFigUtilites conf;
	
	public TC_Login_001() {
		//super();
		//login= new LoginPage(driver);
	}
	@Test
	public void loginTest() throws InterruptedException {
		
		logger=report.createTest("Login Test1");
		login= new LoginPage(driver);
		conf= new ConFigUtilites();
		login.loginAction(conf.getUsername(),conf.getPasrd());
		logger.info("logged in ");
	}
	
	
	
	
	

}
