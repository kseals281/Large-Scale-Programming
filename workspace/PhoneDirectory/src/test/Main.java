package test;

import main.java.*;

public class Main {

	public static void main(String[] args) {
		String name_to_find = "Khari Seals";
		
		String number = PhoneDirectory.getNumber(name_to_find);
		System.out.println(number);
		
	}

}
