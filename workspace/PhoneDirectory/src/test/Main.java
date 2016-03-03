package test;

import main.java.*;

public class Main {

	public static void main(String[] args) {
		PhoneDirectory myDirectory = new PhoneDirectory();
		String name_to_find = "Khari Seals";
		
		String number = myDirectory.getNumber(name_to_find);
		System.out.println("Khari Seals' number: " + number);
		
	}

}
