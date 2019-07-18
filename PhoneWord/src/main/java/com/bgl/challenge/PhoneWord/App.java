package com.bgl.challenge.PhoneWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App 
{
	private static Map<Integer, List<Character>> digitToCharMap = new HashMap<Integer, List<Character>>();
	private static List<String> results = new ArrayList<String>();
	private static Dictionary dict;
	static Map<String, Boolean> cache = new HashMap<String, Boolean>();
	
	private static void initMap() {
		digitToCharMap.put(2, Arrays.asList('A', 'B', 'C'));
		digitToCharMap.put(3, Arrays.asList('D', 'E', 'F'));
		digitToCharMap.put(4, Arrays.asList('G', 'H', 'I'));
		digitToCharMap.put(5, Arrays.asList('J', 'K', 'L'));
		digitToCharMap.put(6, Arrays.asList('M', 'N', 'O'));
		digitToCharMap.put(7, Arrays.asList('P', 'Q', 'R', 'S'));
		digitToCharMap.put(8, Arrays.asList('T', 'U', 'V'));
		digitToCharMap.put(9, Arrays.asList('W', 'X', 'Y', 'Z'));
	}
	
    public static void main( String[] args )
    {
    	initMap();
        List<String> words = new ArrayList<String>();
        words.add("STAR");
        words.add("PLACES");
        words.add("HELLO");
        words.add("WORLD");
        words.add("WARS");
        words.add("KITTY");
        
        dict = new Dictionary(words);
        String input = "54889";
        backtrack("", input);
        System.out.println(results);
    }
    
    public static void backtrack(String prefix, String digit, Map<String, Boolean> cache) {
    	if (digit.length() == 0) {
    		return;
    	}
    	int firstDigit = Integer.valueOf(digit.substring(0, 1));
    	String newDigit = digit.substring(1, digit.length());
    	List<Character> charList = digitToCharMap.get(firstDigit);
    	charList.forEach(c -> {
    		String newPrefix = prefix + c;
    		Result r = dict.contains(newPrefix);
    		if (r == null) {
    			// backtrack
    			return;
    		} else {
    			if (r.isEndOfWord()) {
    				results.add(newPrefix);
    				return;
    			} else {
    				cache.put(newPrefix, Boolean.TRUE);
    				backtrack(newPrefix, newDigit, cache);
    			}
    		}
    	});
    }
}
