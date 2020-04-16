package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.drivers.DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	Properties prop;
	public Logger Logger;
	
	@BeforeTest
	public void init() throws IOException{
		Logger = LogManager.getLogger(this);
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath:"+projectPath);
		Logger.info("projectPath:"+projectPath);
		FileInputStream propertyFilePath = new FileInputStream(projectPath+"/src/test/resources/config.properties");
		prop = new Properties();
		prop.load(propertyFilePath);
		Logger.info("Able to access Property file");
		
		String browser = prop.getProperty("browser");
		System.out.println("browser:"+ browser);
		
		driver = DriverFactory.getDriver(browser);
		
		Logger.info("Driver Object Created");
		driver.get(prop.getProperty("url"));
		Logger.info("Accessing url");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Logger.info("Setting implisit wait");
		//driver.manage().deleteAllCookies();// unable to login
		driver.manage().window().maximize();
		Logger.info("Maximizing browser");
		
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
	//@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
