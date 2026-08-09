package com.automation.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileReader {
	public static Properties Prop;
	public ConfigFileReader()
	{
		try {
		  Prop =new Properties(); 
		  FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src//test/resources//config.properties");
		  Prop.load(file);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 
	}
    public static String getProperty(String key) {
    	return Prop.getProperty(key);
	
    }
}
	
