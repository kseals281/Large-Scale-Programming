package main.java;

import java.io.*;
import java.util.Properties;

public class PhoneDirectory {
	
	private Properties prop = new Properties();
	
	public PhoneDirectory()
	{
		InputStream prop_input = null;
		
		try
		{
			prop_input = new FileInputStream("src/main/resources/phone.properties");
			prop.load(prop_input);
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
	}
	
	public void addEntry(String name, String number)
	{
		
	}
	
	public void deleteEntry(String name)
	{
		
	}
	
	public String getNumber(String name) {
		String number = "";
		String line;
		
		try ( BufferedReader directory = new BufferedReader(new FileReader(prop.getProperty("path"))))
		{			
			while ((line = directory.readLine()) != null) {
				String[] lineArr = new String[3]; 
		        lineArr = line.split(" ");
		        String catname = (lineArr[0] + " " + lineArr[1]);
		        if (name.contains(catname))
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
	
	public void changeEntry(String name, String number)
	{
		
	}

}
