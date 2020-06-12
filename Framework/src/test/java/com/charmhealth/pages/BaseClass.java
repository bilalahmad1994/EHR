package com.charmhealth.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.charmhealth.utility.BrowserFactory;
import com.charmhealth.utility.ConfigDataProvider;

public class BaseClass {

	public WebDriver driver;
	public ConfigDataProvider config;

	@BeforeSuite
	public void setUpSuite()
	{
		config = new ConfigDataProvider();
	}
	
	@BeforeClass
	public void setup() 
	{
		driver = BrowserFactory.startApplication(driver,config.getBrowser(),config.getqaURL());
	}
	
	@AfterClass
	public void teardown()
	{
		
	BrowserFactory.quitBrowser(driver);
	
	}
	
}
