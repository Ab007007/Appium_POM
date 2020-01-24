package com.ai.automation.employeConnect.page;

import org.openqa.selenium.support.PageFactory;

import com.ai.automation.employeConnect.utils.DriverUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	AndroidDriver<AndroidElement> driver = null;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SETTINGS']")
	AndroidElement settingsTab;
	
	
	public void clickOnSettingsTab()
	{
		DriverUtils.click(driver, settingsTab);
	}
	
	
	
	public HomePage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
		
	}
}
