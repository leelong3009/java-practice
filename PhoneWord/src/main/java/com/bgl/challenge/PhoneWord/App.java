package com.bgl.challenge.PhoneWord;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args) {
    	List<String> dictionaryWords = new ArrayList<String>();
    	String dictionaryFilePath = System.getProperty("dictionary");
    	if (dictionaryFilePath != null && !dictionaryFilePath.isEmpty()) {
    		dictionaryWords = Util.readFile(dictionaryFilePath);
    	}
    	if (dictionaryWords.isEmpty()) {
    		System.out.println("The dictionary is empty, please try again!");
			return;
		}
    	Dictionary dict = Util.createDictionary(dictionaryWords);
    	Menu menu = new Menu(new PhoneWord(dict));
    	menu.printMenu();
    }
}
