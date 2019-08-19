package com.bgl.challenge.PhoneWord;

import java.util.Scanner;

public class Menu {
	private PhoneWord phoneWord;
	
	public Menu(PhoneWord phoneWord) {
		this.phoneWord = phoneWord;
	}
	
	public void printMenu() {
    	Scanner scanner = new Scanner(System.in);
    	boolean quit = false;
    	while (!quit) {
    		System.out.println("======================================================");
    		System.out.println("1 - Input file path, 2 - Enter a phone number, 3: QUIT");
    		String option = scanner.nextLine();
    		switch (option) {
    		case "1":
    			System.out.print("Phone number file path: ");
    			String filePath = scanner.nextLine();
    			phoneWord.searchAndPrintMatchedWordsFromFile(filePath);
    			break;
    		case "2":
    			System.out.println("Enter a phone number: ");
    			String phoneNumber = scanner.nextLine();
    			phoneWord.searchAndPrintMatchedWordsFromInput(phoneNumber);
    			break;
    		case "3":
    			quit = true;
    			break;
    		}
    	}
    	scanner.close();
    }
}
