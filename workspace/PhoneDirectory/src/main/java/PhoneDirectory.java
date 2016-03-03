package main.java;

import java.io.*;
import java.util.Properties;

public class PhoneDirectory {
	
	public static String getNumber(String name) {
		Properties prop = new Properties();
		InputStream prop_input = null;
		String number = "";
		String line;
		
		try
		{
			prop_input = new FileInputStream("src/main/resources/phone.properties");
			prop.load(prop_input);
			System.out.println(prop.getProperty("path"));
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			if (prop_input != null) {
				try
				{
					prop_input.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		try ( BufferedReader directory = new BufferedReader(new FileReader(prop.getProperty("path"))))
		{			
			while ((line = directory.readLine()) != null) {
				String[] lineArr = new String[3]; 
		        lineArr = line.split(" ");
		        if ((lineArr[0] + " " + lineArr[1]) == name)
		        {
		        	return lineArr[2];
		        }
		    }
			System.out.println("Unable to find number");
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return number;
		
	}

}