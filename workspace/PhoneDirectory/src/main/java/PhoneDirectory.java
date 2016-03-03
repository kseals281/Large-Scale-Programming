package main.java;

import java.io.*;
import java.util.Properties;

public class PhoneDirectory {
	
	private Properties prop = new Properties();
	private String path = null;
	
	public PhoneDirectory()
	{
		InputStream prop_input = null;
		
		try
		{
			prop_input = new FileInputStream("src/main/resources/phone.properties");
			prop.load(prop_input);
			path = prop.getProperty("path");
		} catch (IOException err) {
			// TODO Auto-generated catch block
			err.printStackTrace();
		} finally {
			if (prop_input != null) {
				try
				{
					prop_input.close();
				} catch (IOException err)
				{
					err.printStackTrace();
				}
			}
		}
	}
	
	public void addEntry(String name, String number)
	{
		System.out.println(name + " " + number);
		try
		{
			Writer writer = new FileWriter(path, true);
			writer.write((name + " " + number) + System.lineSeparator());
			writer.close();
		} catch (IOException err) {
			err.printStackTrace();
		}
		
	}
	
	public void deleteEntry(String name) throws IOException
	{
		File temp = new File("src/main/resources/temp.txt");
		File file = new File(path);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
		
		String line;
		
		while( (line = reader.readLine()) != null )
		{
			String[] lineArr = new String[3];
			lineArr = line.split(" ");
			String catname = (lineArr[0] + " " + lineArr[1]);
			if (!name.contains(catname))
			{
				writer.write(line + System.getProperty("line.separator"));
			}
		}

		reader.close();
		writer.close();
		file.delete();
		temp.renameTo(file);

	}
	
	public String getNumber(String name) {
		String number = "";
		String line;
		
		try ( BufferedReader directory = new BufferedReader(new FileReader(path)))
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
		try {
			deleteEntry(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addEntry(name, number);
		
	}
	
}
