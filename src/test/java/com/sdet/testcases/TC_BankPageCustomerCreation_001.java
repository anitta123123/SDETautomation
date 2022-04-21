package com.sdet.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdet.PageObjects.BankPage;
import com.sdet.PageObjects.LoginBankPage;
import com.sdet.PageObjects.LoginPage;
import com.sdet.utilities.ConFigUtilites;
import com.sdet.utilities.ExcelReader;

public class TC_BankPageCustomerCreation_001 extends BaseClass {
	
	LoginBankPage loginBank;
	ConFigUtilites conf;
	BankPage bankPage;
	public LoginPage login;
	
/**
	@Test
	public void newCustomer() throws InterruptedException {
		//logger=report.createTest("customer creation screen");
		loginBank=new LoginBankPage(driver);
		conf= new ConFigUtilites();
		loginBank.clickBankLink();
		loginBank.bankLogin(conf.getUsername(),conf.getPasrd());
		 
		bankPage= new BankPage(driver);
		bankPage.clickNewCustomer();
		Thread.sleep(2000);
		bankPage.inputCustName("aromal");
		bankPage.inputGender("female");
		bankPage.inputdob(24,12,1990);
		bankPage.address("12, house number,street12");
		bankPage.inputCity("mP");
		bankPage.inputState("state");
		bankPage.inputPIN(123456);
		bankPage.inputPhone(1235646678);
		bankPage.inputEmail("aa.BB@gmail.com");
		
	}
	**/
	@DataProvider(name="loginwithDifferentDataWithDifferentDataTypes")
	public Object[][] getData(){
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\sdet\\testData\\differentvalues_Sdetproject.xls";
		System.out.println(path);
		ExcelReader reader= new ExcelReader(path);
		Object [][] c=reader.toReadValuedFromExcelAllValues(path);
		System.out.println("inside customer creation ");
		for (int i=0;i<1;i++) {
			for(int j=0;j<6;j++) {
				System.out.println(c[i][j]);
			}
		}
		return c;			
	}

	@Test(dataProvider="loginwithDifferentDataWithDifferentDataTypes")
	public void readValuesFromExcelAllValues(String cusname, String gender, String address, String city, String state,String email) throws InterruptedException{
		//logger=report.createTest("Login Test2");
		System.out.println("inside 8 argument method");
		login= new LoginPage(driver);			
			loginBank=new LoginBankPage(driver);
			conf= new ConFigUtilites();
			loginBank.clickBankLink();
			loginBank.bankLogin(conf.getUsername(),conf.getPasrd());
			bankPage= new BankPage(driver);
			bankPage.clickNewCustomer();
			Thread.sleep(2000);
			bankPage.inputCustName(cusname);
			bankPage.inputGender(gender);
			//bankPage.inputdob(24,12,1990);
			bankPage.address(address);
			bankPage.inputCity(city);
			bankPage.inputState(state);
			//bankPage.inputPIN(PIN);
			//bankPage.inputPhone(phone);
			bankPage.inputEmail(email);
	}	
}
