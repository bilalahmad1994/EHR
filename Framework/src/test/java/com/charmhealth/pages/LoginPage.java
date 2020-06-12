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
	
	@FindBy(className = "signin-button") WebElement LoginButton;
	@FindBy(name = "lid") WebElement uname;
	@FindBy(name = "pwd") WebElement pass;
	@FindBy(id = "signin_submit") WebElement SigninButton;
	
	public void logintoCharmHealth(String username, String password)
	{
		LoginButton.click();
		
		try 
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e) {
			
		}
		
		uname.sendKeys(username);
		pass.sendKeys(password);
		SigninButton.click();
		
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			
		}
	}

}
