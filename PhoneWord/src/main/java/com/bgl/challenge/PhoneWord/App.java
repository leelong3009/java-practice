package com.bgl.challenge.PhoneWord;

import java.util.Collections;
import java.util.List;

public class App 
{
    public static void main( String[] args) {
    	List<String> dictionaryWords = null;
    	String dictionaryFilePath = System.getProperty("dictionary");
    	if (dictionaryFilePath != null && !dictionaryFilePath.isEmpty()) {
    		dictionaryWords = Util.readFile(dictionaryFilePath);
    	} else {
    		dictionaryWords = Collections.emptyList();
    	}
    	Dictionary dict = Util.createDictionary(dictionaryWords);
    	Menu menu = new Menu(new PhoneWord(dict));
    	menu.printMenu();
    }
}
