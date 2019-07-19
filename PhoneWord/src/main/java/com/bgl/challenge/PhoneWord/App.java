package com.bgl.challenge.PhoneWord;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class App 
{
	
    public static void main( String[] args ) throws URISyntaxException, IOException
    {
    	Util util = new Util();
    	List<String> words = util.loadWords("/home/long/Dictionary-sample.txt");
    	Dictionary dict = util.createDictionary(words);
        String input = "54889254889";
        input = input.replaceAll("[\\s,]+", "");
        PhoneWord phoneword = new PhoneWord(dict);
        List<String> matchedWords = phoneword.findAnyMatches(input);
        System.out.println(matchedWords);
    }
    
    
}
