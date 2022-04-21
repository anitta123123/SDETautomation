package com.sdet.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdet.PageObjects.LoginPage;
import com.sdet.utilities.ConFigUtilites;
import com.sdet.utilities.ExcelReader;

public class TC_Login_002 extends BaseClass {
	
	public LoginPage login;
	public ConFigUtilites conf;
	
	@DataProvider(name="loginwithDifferentData")
	public Object[][] getData(){
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\sdet\\testData\\usernamepass_sdetproject.xls";
		System.out.println(path);
		ExcelReader reader= new ExcelReader(path);
		Object [][] b=reader.toReadValuedFromExcel(path);
		return b;
		
				
	}
	
	@Test(dataProvider="loginwithDifferentData",alwaysRun = true)
	public void loginWithDifferentValues(String username, String password){
		logger=report.createTest("Login Test2");
		login= new LoginPage(driver);
		try {
			login.loginAction(username,password);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("logged in ");
		
	}
	
	
	
	
	

}
