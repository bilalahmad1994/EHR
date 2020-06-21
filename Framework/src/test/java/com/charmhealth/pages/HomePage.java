package com.charmhealth.pages;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HomePage {
	
	WebDriver driver;
    By Patient_Menu = By.className("amds-ehr-scheduler-appointment-name");
	By Badge = By.xpath("//amds-ps-patient-card");
	By time_locator = By.cssSelector(".amds-appointment-item:nth-child(5)");

	public HomePage(WebDriver ndriver)
	{
		this.driver=ndriver;
	}
	
	public void Collecting_Patient_Data() throws InterruptedException
	{
		List<WebElement> buttonToClick = driver.findElements(Patient_Menu);
    	
    	for (int i=0;i<buttonToClick.size();i++)
    	{
    	WebElement a=buttonToClick.get(i);
    	String w=a.getText();
    	//System.out.println(w);
    	
    	//Collecting details of patients.
    	Actions builder = new Actions(driver);
    	builder.moveToElement(a).click().perform(); 
    	Thread.sleep(5000);
    	String c=driver.findElement(Badge).getText();
    	//System.out.println(c);
    	String time_with_duration = driver.findElement(time_locator).getText();
    	//System.out.println("time is:"+ time);
    	Thread.sleep(3000);

         String time = time_with_duration;
         String[] split_time = time.split("\\s+");
         
    	 String text = c;
         String[] splitStr = text.split("\\r?\\n");
         System.out.println(splitStr[0]);
         System.out.println(splitStr[1]);
         System.out.println(splitStr[2]);
         System.out.println(splitStr[3]);

         String [] AgewithDateandgender = splitStr[2].split(("\\s"));
         //System.out.println(AgewithDateandgender);
         String Gender = AgewithDateandgender[3];
         String AgewithDate = AgewithDateandgender[2];
         String Age = AgewithDate.substring(AgewithDate.length() - 3);
         
        // System.out.println(Arrays.toString(splitStr));
         
         String list = split_time[0] + " " + split_time[1] + "," + " " + splitStr[1] + "," + " " + Age + "," + " " + Gender;
         System.out.println("List :"+list);

    
    	}
	}

}
