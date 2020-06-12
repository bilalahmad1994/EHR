package com.charmhealth.utility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataProvider {
	
	public JsonDataProvider() throws IOException, ParseException 
	{
	
	JSONParser jsonparser = new JSONParser();
		
    FileReader reader = new FileReader("./TestData/sample.json");
    
	Object obj = jsonparser.parse(reader);
	
	JSONObject samplejsonobj = (JSONObject)obj; 
	
	//String fname=(String)samplejsonobj.get("name");
	
    String fname=(String)samplejsonobj.get("name");
    
    String History= (String)samplejsonobj.get("History_of_Present_Illness");
	
	
	}
}
