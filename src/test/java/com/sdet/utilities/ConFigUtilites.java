package com.sdet.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConFigUtilites {
	

	FileInputStream ip;
	Properties prop;
	
	public ConFigUtilites() {
		
		try{
			ip = new FileInputStream(System.getProperty("user.dir")+"//Configuration//config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prop= new Properties();
		
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public String getUrl() {
		
		return prop.getProperty("url");
	}
	
	public String getUsername() {
		
		return prop.getProperty("username");
	}

	public String getPasrd() {
	
	return prop.getProperty("password");
    }
	
	public String getChromePath() {
		return prop.getProperty("chromepath");
	}
	
	public String getFireFoxPath() {
		return prop.getProperty("firefoxpath");
	}

}
