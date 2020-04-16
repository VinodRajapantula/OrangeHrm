package com.drivers;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	public static WebDriver  getDriver(String browserName){
		if(browserName.equalsIgnoreCase("chrome")){
			MyChromeDriver chromeDriver = new MyChromeDriver();
			return chromeDriver.getDriver();			
		}else if(browserName.equalsIgnoreCase("ie")){
			MyIeDriver ieDriver = new MyIeDriver();
			return ieDriver.getDriver();			
		}else{
			MyFirefoxDriver ffDriver = new MyFirefoxDriver();
			return ffDriver.getDriver();
		}
		
	}

}
