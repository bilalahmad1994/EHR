package com.charmhealth.testcases;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.charmhealth.pages.BaseClass;
import com.charmhealth.pages.LoginPage;
import com.charmhealth.utility.JsonDataProvider;

public class LoginTestCharmHealth extends BaseClass {
		
	@Test
	public void loginApp() throws IOException, ParseException, InterruptedException 
	{		
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		//For parent window
		String parent = driver.getWindowHandle();
		System.out.println("Parent window id = "+parent);
		loginpage.logintoCharmHealth("JADE", "Kayla7vigil!", "144005");
		
		Thread.sleep(50000);
		
        //For child window
        Set <String> allWindows = driver.getWindowHandles();
        for (String child:allWindows)
        {
        	if (!parent.equalsIgnoreCase(child))
        	{
        		driver.switchTo().window(child);
        		driver.manage().window().maximize();
        		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        		System.out.println("Child window id = "+child);
        		System.out.println("Child window title = "+driver.getTitle());
        		//Open date picker
        		//driver.findElement(By.xpath("//span[@class='amds-displayed-date']//span[2]")).click();
        		//Select month drop down
        		//driver.findElement(By.xpath("//body//select[1]")).click();
        		
        	//selecting values of month and year from drop down  
        	/*	List<WebElement> months= driver.findElements(By.className("ng-tns-c40-0 ng-star-inserted"));
        		
        		for (int i=0; i<months.size();i++)
        		{
        			System.out.println("Total Months "+months.size());
        			WebElement options=months.get(i);
        			
        			//Getting the innerHTML of each option of select class drop down
        			String innerhtml = options.getAttribute("innerHTML");
        			System.out.println("Months= "+innerhtml);
        			if (innerhtml.contentEquals("January"))
        			{
        				options.click();		      				
        			}
        		*/
        		
        		//Finding actual date, month and year.
        		String month=driver.findElement(By.xpath("//span[@class='amds-date'][1]")).getText();
        		String day=driver.findElement(By.xpath("//span[@class='amds-date'][2]")).getText();
        		String year=driver.findElement(By.xpath("//span[@class='amds-date'][3]")).getText();
        		
        		//Concatenating the actual date
        		String actual_date= month+"/"+day+"/"+year;
        		System.out.println(actual_date);
        	
        	    JsonDataProvider j = new JsonDataProvider();
        	    String expected_date =  j.get_data("date");
        	    
        	    String[] parts = expected_date.split("/");
        	    String Month = parts[0]; 
        	    String Day = parts[1];
        	    String Year = parts[2];
        	    System.out.println(Day);
        	    System.out.println(Year);
            
        	    
        	    if (actual_date != expected_date)
        	    {
        				      	   
        	    	//opening date picker
        	    	driver.findElement(By.xpath("//span[@class='amds-displayed-date']//span[2]")).click();
        	    	//Select the day from date picker equal to the day in expected_date
        	    	driver.findElement(By.xpath("//a[.='" + Day + "']")).click();
        	    } 	
        	    	List<WebElement> buttonToClick = driver.findElements(By.className("amds-ehr-scheduler-appointment-name"));
        	    	
        	    	for (int i=0;i<buttonToClick.size();i++)
        	    	{
        	    	WebElement a=buttonToClick.get(i);
        	    	a.click();
        	    	}

        	    	
        	    
        	}
        	
        }

				
	}

}
