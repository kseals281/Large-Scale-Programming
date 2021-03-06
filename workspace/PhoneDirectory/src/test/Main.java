package test;

import java.io.IOException;

import main.java.*;

public class Main {

	public static void main(String[] args) {
		PhoneDirectory myDirectory = new PhoneDirectory();
		String name_to_find = "Khari Seals";
		String name_to_add = "Miya Goodwin";
		String number_to_add = "2569228";
		String name_to_delete = "Kemba Seals";
		String name_to_change = "Tyson Ross";
		String number_to_change = "8675309";
		
		myDirectory.addEntry(name_to_add, number_to_add);
		myDirectory.changeEntry(name_to_change, number_to_change);
		
		String number = myDirectory.getNumber(name_to_find);
		System.out.println("Khari Seals' number: " + number);
		
		try {
			myDirectory.deleteEntry(name_to_delete);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			myDirectory.deleteEntry(name_to_add);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		myDirectory.addEntry(name_to_delete, "4811820");
		
	}

}
