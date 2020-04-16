package com.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.Login;

public class TC_LoginTest_001 extends BaseTest {

	@Test
	public void login() throws IOException{
		Login login = new Login(driver);		
		login.loginToHrm();
		String homePageCurrentUrl = driver.getCurrentUrl();
		String homePageUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard1234";
		
		boolean res =homePageCurrentUrl.equalsIgnoreCase(homePageUrl);
		
		if(res==true)
		{
			Assert.assertTrue(true);
			Logger.info("test case passed....");
			
		}
		else
		{
			Logger.info("test case failed....");
			captureScreen(driver,"login");
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void login1() throws IOException{
		
		boolean res =true;
		
		if(res==true)
		{
			Assert.assertTrue(true);
			Logger.info("test case passed....");
			
		}
		else
		{
			Logger.info("test case failed....");
			captureScreen(driver,"login1");
			Assert.assertTrue(false);
		}
	}
}
