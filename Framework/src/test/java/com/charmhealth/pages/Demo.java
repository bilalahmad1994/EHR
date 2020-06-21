package com.charmhealth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.charmhealth.utility.JsonDataProvider;

public class Demo {


	WebDriver driver;
    By Class_Tab = By.xpath("/html/body/div[1]/section/aside/div/ul/li[3]/span");
	By Select_Class = By.xpath("/html/body/div[1]/section/section/main/div/div/div/div/form/div[1]/div/div/span/div/div/div");
	
	
	public Demo(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void Match_Data(String expected_name, String expected_age,String expected_gender)
	{
		String actual_name = driver.findElement(By.xpath("//div[contains(text(),'TEST,PATIENT')]")).getText();
		String actual_age = driver.findElement(By.xpath("//span[contains(text(),'3y,')]")).getText();
		String actual_gender = driver.findElement(By.xpath("//span[contains(text(),'U')]")).getText();
		
	}
	
}
