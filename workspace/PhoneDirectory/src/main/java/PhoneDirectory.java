package main.java;

import java.io.*;
import java.util.Properties;

public class PhoneDirectory {
	
	private Properties prop = new Properties();
	private String path = null;
	
	/**
	 * Initializes the object with the proper location of the properties file. The properties file holds the location of the correct directory file.
	 */
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
	
	/**
	 * Adds an entry to the directory
	 * @param name
	 * @param number
	 */
	public void addEntry(String name, String number)
	{
		try
		{
			Writer writer = new FileWriter(path, true);
			writer.write((name + " " + number) + System.lineSeparator());
			writer.close();
		} catch (IOException err) {
			err.printStackTrace();
		}
		
	}
	
	/**
	 * Deletes an entry from the directory by creating a temporary file and copying all entries into the new file.
	 * Then replaces the old file with the temporary file.
	 * @param name
	 * @throws IOException
	 */
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
	
	/**
	 * Gets the number from the directory that corresponds to the given name
	 * @param name
	 * @return The number associated with the name
	 */
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
	
	/**
	 * Changes an entry in the directory be calling delete entry and then add entry
	 * @param name 
	 * @param number
	 * 
	 * @return void 
	 */
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
