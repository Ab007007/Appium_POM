package com.ai.automation.employeConnect.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	
	public static String getProperty(String name) throws IOException {
		String value = null;
		File file = new File("data\\config.properties");
		FileInputStream fis = new FileInputStream(file);
	
		Properties props = new Properties();
		props.load(fis);
		value=  props.getProperty(name);
		System.out.println("Property file with key " + name + " and value is " + value);
		fis.close();
		return value;
	}
}
