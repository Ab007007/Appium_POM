package com.ai.automation.employeConnect.page;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ai.automation.employeConnect.utils.DriverUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage
{
	AndroidDriver<AndroidElement> driver = null;
	/**
	 * Every PAGE class
	 * 1. Variables -> AndroidElements
	 * 2. Methods -> actions (click or sendkeys or gettext ) on AndroidElements )
	 * 3. Constructor -> (Initialize AndroidElements of a PAGE )
	 * 
	 */

	@AndroidFindBy(uiAutomator = "text(\"Your NT ID\")")
	AndroidElement userNameTextBox;
	
	@AndroidFindBy(uiAutomator = "text(\"Password\")")
	AndroidElement passwordTextBox;
	
	@AndroidFindBy(uiAutomator = "text(\"Select NT Domain\")")
	AndroidElement domainDropDown;
	
	
	@AndroidFindBy(uiAutomator = "text(\"247-INC\")")
	AndroidElement ntDomain;
	
	
	@AndroidFindBy(uiAutomator = "text(\"Register\")")
	AndroidElement registerButton;
	
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	AndroidElement loginFailedPopUp;
	
	
	public void enterUserName(String username)
	{
		System.out.println("Entering username on text box");
		userNameTextBox.sendKeys(username);
	}
	
	public void enterPassword(String pass)
	{
		System.out.println("Entering username on text box");
		passwordTextBox.sendKeys(pass);
	}
	
	public void selectntDomain()
	{
		System.out.println("Selecting NT-Drop Down from the list");
		DriverUtils.click(driver, domainDropDown);
		DriverUtils.click(driver, ntDomain);
	}
	
	
	public void clickOnRegisterAndWaitForLogin()
	{
		System.out.println("Clicking on register button");
		DriverUtils.click(driver, registerButton);
		DriverUtils.waitForLoaderToDisapper(driver);
		
	}
	
	
	public void loginEmployeeConnect(String un, String pwd)
	{
		enterUserName(un);
		enterPassword(pwd);
		selectntDomain();
		clickOnRegisterAndWaitForLogin();
		
	}
	
	
	public LoginPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
	
	public void validateLoginFailed()
	{
		Assert.assertTrue(loginFailedPopUp.isDisplayed());
		loginFailedPopUp.click();
	}
	
	
	
}
