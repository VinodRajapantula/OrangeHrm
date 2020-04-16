package com.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyIeDriver extends MyDriver{

	@Override
	public WebDriver getDriver() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		return driver;
	}

}
