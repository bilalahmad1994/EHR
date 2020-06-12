package com.charmhealth.testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.charmhealth.pages.BaseClass;
import com.charmhealth.pages.LoginPage;
import com.charmhealth.utility.JsonDataProvider;

public class LoginTestCharmHealth extends BaseClass {
		
	@Test
	public void loginApp() throws IOException, ParseException 
	{		
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		loginpage.logintoCharmHealth("bilal", "123");
		
		JsonDataProvider j = new JsonDataProvider();

				
	}

}
