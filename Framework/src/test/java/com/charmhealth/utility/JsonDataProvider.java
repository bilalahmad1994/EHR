package com.charmhealth.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataProvider {
	

	
	public String get_data(String key) 
	{
		String data = "";
		
		try {
			JSONParser jsonparser = new JSONParser();
			
		    FileReader reader;
			
			reader = new FileReader("./TestData/sample.json");
			 
			Object obj;
			
		    obj = jsonparser.parse(reader);
		
			
			JSONObject samplejsonobj =(JSONObject)obj;
			
			data= (String)samplejsonobj.get(key);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		return data;
	}
}
