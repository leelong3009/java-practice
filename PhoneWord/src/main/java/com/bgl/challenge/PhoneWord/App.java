package com.bgl.challenge.PhoneWord;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App 
{
	private static Map<Integer, List<Character>> digitToCharMap = new HashMap<Integer, List<Character>>();
	private static List<String> results = new ArrayList<String>();
	private static Dictionary dict;
	
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
	
	private static Dictionary initDictionary() throws URISyntaxException, IOException {
    	Path path = Paths.get(App.class.getClassLoader().getResource("Dictionary-sample.txt").toURI());
    	Stream<String> lines = Files.lines(path);
    	List<String> words = lines.map(String::trim).map(String::toUpperCase).collect(Collectors.toList());
    	lines.close();
    	return new Dictionary(words);
	}
	
    public static void main( String[] args ) throws URISyntaxException, IOException
    {
    	initMap();
        dict = initDictionary();
        String input = "78 27,927 7";
        input = input.replaceAll("[\\s,]+", "");
        backtrack("", input);
        System.out.println(results);
    }
    
    public static void backtrack(String prefix, String digit) {
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
    				if (newDigit.length() > 0) {
    					backtrack("", newDigit);
    				} else {
    					return;
    				}
    			} else {
    				backtrack(newPrefix, newDigit);
    			}
    		}
    	});
    }
}
