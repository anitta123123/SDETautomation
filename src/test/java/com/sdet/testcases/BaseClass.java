package com.sdet.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sdet.utilities.ConFigUtilites;
import com.sdet.utilities.HelperScreens;

public class BaseClass {
	
	public static  WebDriver driver;
	public ConFigUtilites conf;
	public ExtentReports report;
	public static ExtentTest logger;
	

	@BeforeSuite
	public void setUpSuite() {
		conf= new ConFigUtilites();
		/**
		ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/DemoGuru_"+HelperScreens.getCurrentDateTime()+".html"));
		extent.config().setDocumentTitle("Automation Reporting");//Title of the report
		extent.config().setReportName("Funtional Report");//name of the report
		extent.config().setTheme(Theme.DARK);// theme of the report
		report=new ExtentReports();
		report.attachReporter(extent);
		report.setSystemInfo("Test name","Anitta Tom");
		report.setSystemInfo("Application under test"," Demo Guru99");	
		**/	
	}
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		if(br.equals("chrome")) {
		
			System.setProperty("webdriver.chrome.driver",conf.getChromePath());
			driver= new ChromeDriver();
		}
		else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",conf.getFireFoxPath());
			driver= new FirefoxDriver();	
		}
		else{
			System.out.println("browser not present");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get(conf.getUrl());
		System.out.println(conf.getUrl());
	}
		
	@AfterClass
	public void tearDown() {
		System.out.println("after class");
		//driver.quit();
	}
	/**
	@AfterMethod
	public void endMethod(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			logger.log(Status.FAIL,"Test failed is" +result.getName());
			logger.log(Status.FAIL,"Test failed is" +result.getThrowable());
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(HelperScreens.captureScreenShot(driver)).build());
	
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
						
			logger.log(Status.PASS,"Test passed is" +result.getName());
			logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(HelperScreens.captureScreenShot(driver)).build());
			
		}
		
		else if(result.getStatus() == ITestResult.SKIP){
			
			logger.log(Status.SKIP,"Test passed is" +result.getName());
			logger.log(Status.SKIP,"Test passed is" +result.getThrowable());
			logger.addScreenCaptureFromPath(HelperScreens.captureScreenShot(driver));
			}
		report.flush();
	}
**/
}
