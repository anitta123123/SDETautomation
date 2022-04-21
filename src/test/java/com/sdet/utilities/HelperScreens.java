package com.sdet.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class HelperScreens {
	
	public static String getCurrentDateTime() {
		
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate= new Date();
		
		return customFormat.format(currentDate);	
		
		
	}
	
	public static String captureScreenShot(WebDriver driver) {
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath= System.getProperty("user.dir")+"/Screenshots/DemoGuru_"+getCurrentDateTime()+".png";
		
		try {
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("screenshot captured");
		} 
		catch (IOException e) {
			
			System.out.println("unable to capture screenshot"+e.getMessage());

		}
		
		return screenshotPath;
		
	}
	
	
	
	

}
