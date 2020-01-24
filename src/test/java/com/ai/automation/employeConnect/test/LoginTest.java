package com.ai.automation.employeConnect.test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ai.automation.employeConnect.page.HomePage;
import com.ai.automation.employeConnect.page.LoginPage;
import com.ai.automation.employeConnect.page.SettingsPage;
import com.ai.automation.employeConnect.utils.DriverUtils;
import com.ai.automation.employeConnect.utils.PropertiesReader;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginTest
{
	LoginPage loginpage = null;
	HomePage homepage = null;
	SettingsPage settingsPage = null;
	AndroidDriver<AndroidElement> driver = null;
	
	@BeforeClass
	public void setup() throws MalformedURLException, IOException
	{
		driver = DriverUtils.getMyDriver(PropertiesReader.getProperty("packagename"),
				PropertiesReader.getProperty("activityname"), PropertiesReader.getProperty("udid"));
		
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		settingsPage = new SettingsPage(driver);
	}

	
	@Test(priority = 1)
	public void loginTestWithValidCredentials()
	{
		loginpage.loginEmployeeConnect("is.user", "welcome@247");
		homepage.clickOnSettingsTab();
		settingsPage.unRegister("i'm done for this session ");
	}
	
	@Test(priority = 2)
	public void loginTestWithInValidCredentials()
	{
		loginpage.loginEmployeeConnect("xxxX", "******");
		loginpage.validateLoginFailed();
	}
	
	
//	@AfterClass
//	public void cleanup()
//	{
//		driver.close();
//		driver = null;
//		loginpage = null;
//		homepage = null;
//		settingsPage = null;
//	}
	
	
	
	
	
	
	
	
	
}
