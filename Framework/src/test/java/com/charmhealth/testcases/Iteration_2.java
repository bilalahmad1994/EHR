package com.charmhealth.testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.charmhealth.pages.BaseClass;
import com.charmhealth.pages.LoginPage;
import com.charmhealth.utility.JsonDataProvider;

public class Iteration_2 extends BaseClass{
	
	@Test
	public void loginApp() throws IOException, ParseException 
	{		
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		//loginpage.logintoCharmHealth("user1", "12345");
		
		JsonDataProvider j = new JsonDataProvider();

				
	}
}
