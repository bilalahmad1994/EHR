package com.charmhealth.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	//@FindBy(className = "signin-button") WebElement LoginButton;
	@FindBy(xpath = "//input[@name='username']") WebElement uname;
	@FindBy(xpath ="//input[@name='password']") WebElement pass;
	@FindBy(xpath ="//input[@name='officeKey']") WebElement key;
	@FindBy(xpath ="//button[contains(.,'Log in')]") WebElement LoginButton;
	@FindBy(xpath = "//label[contains(.,'EHR')]") WebElement EHR_Checkbox;
	
	public void logintoCharmHealth(String username, String password, String officekey)
	{
		//LoginButton.click();
		
		//try 
		//{
		//	Thread.sleep(3000);
		//}
		//catch (InterruptedException e) {			
		//}
		driver.switchTo().frame("frame-login");
		
		uname.sendKeys(username);
		pass.click();
		pass.sendKeys(password);
		key.click();
		key.sendKeys(officekey);
		EHR_Checkbox.click();
		LoginButton.click();
		
		
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			
		}
	}

}
