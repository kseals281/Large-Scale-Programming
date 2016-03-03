package main.java;

import java.io.*;
import java.util.Properties;

public class PhoneDirectory {

	public static void main(String[] args) {
		Properties prop = new Properties();
		InputStream prop_input = null;
		FileReader directory = null;
		
		try {
			prop_input = new FileInputStream("src/main/resources/phone.properties");
			prop.load(prop_input);
			System.out.println(prop.getProperty("path"));
			
			directory = new FileReader(prop.getProperty("path"));
			System.out.println(directory.read());
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
	
	public static String getNumber(String name) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] lineArr = new String[3]; 
		        lineArr = line.split(" ");
		        if ((lineArr[0] + " " + lineArr[1]) == name) {
		        	break;
		       }
		    }
		}
		int number = 0;
		return number;
		
	}

}
