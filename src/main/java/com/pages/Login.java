package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
	Logger Logger;
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		Logger = LogManager.getLogger(this);
	}
	
	@FindBy(xpath="//input[@id='txtUsername']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='Submit']")
	WebElement submit;
	
	
	public void loginToHrm(){
		userName.sendKeys("Admin");
		Logger.info("Entering UserName");
		password.sendKeys("admin123");
		Logger.info("Entering Password");
		submit.click();
		Logger.info("Clicked on Submit button");
	}
	

}
