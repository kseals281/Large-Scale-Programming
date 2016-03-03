package main.java;

import java.io.*;
import java.util.Properties;

public class PhoneDirectory {

	public static void main(String[] args) {
		Properties prop = new Properties();
		Properties dir_prop = new Properties();
		InputStream prop_input = null;
		InputStream directory = null;
		
		try {
			prop_input = new FileInputStream("src/main/resources/phone.properties");
			prop.load(prop_input);
			System.out.println(prop.getProperty("path"));
			
			directory =  new FileInputStream(prop.getProperty("path"));
			dir_prop.load(directory);
			System.out.println(dir_prop.getProperty("name"));
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			if (prop_input != null) {
				try {
					prop_input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
