package com.ai.automation.employeConnect.page;

import org.openqa.selenium.support.PageFactory;

import com.ai.automation.employeConnect.utils.DriverUtils;
import com.sun.corba.se.internal.Interceptors.PIORB;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingsPage {

	AndroidDriver<AndroidElement> driver = null;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='1']")
	AndroidElement selectUser;
	
	@AndroidFindBy(id = "com.IS247.Notifier:id/lblUnReg")
	AndroidElement unRegisterButton;
	
	@AndroidFindBy(id = "com.IS247.Notifier:id/layoutEditor")
	AndroidElement reasonTextBox;
	
	@AndroidFindBy(id = "com.IS247.Notifier:id/btnUnregisterSubmit")
	AndroidElement submitButton;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='YES']")
	AndroidElement acceptALert;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='NO']")
	AndroidElement dismissALert;
	
	public void selectUser()
	{
		DriverUtils.click(driver, selectUser);
	}
	
	public void clickOnUnRegisterButton()
	{
		DriverUtils.click(driver, unRegisterButton);
	}
	
	public void enterReason(String reason)
	{
		DriverUtils.sendKeys(driver, reasonTextBox, reason);
	}
	
	
	public void clickOnSubmitButton()
	{
		DriverUtils.click(driver, submitButton);
	}
	
	public void acceptPopUp()
	{
		DriverUtils.click(driver, acceptALert);
	}
	
	public void dismissPopUp()
	{
		DriverUtils.click(driver, dismissALert);
	}
	
	public void unRegister(String reason)
	{
		selectUser();
		clickOnUnRegisterButton();
		enterReason(reason);
		clickOnSubmitButton();
		acceptPopUp();
	}
	
	public SettingsPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
}
