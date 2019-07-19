package com.bgl.challenge.PhoneWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneWord {

	private Dictionary dict;
	private Map<String, List<Character>> digitToCharMap;
	private List<String> matchedWords;
	private StringBuilder matchedRow;
	private static final String EMPTY_STRING = "";
	private static final String HYPHEN = "-";

	public PhoneWord(Dictionary dict) {
		this.dict = dict;
		this.digitToCharMap = initDigitToCharMap();
		this.matchedWords = new ArrayList<String>();
		this.matchedRow = new StringBuilder();
	}

	/**
	 * Match phone number to words in the dictionary
	 * @param phoneNumber input phone number
	 * @return list of matched words
	 */
	public List<String> findAnyMatches(String phoneNumber) {
		reset();
		this.backtrack("", "", phoneNumber);
		return this.matchedWords;
	}
	
	private void reset() {
		matchedWords.clear();
		matchedRow.setLength(0);
	}
	
	private Map<String, List<Character>> initDigitToCharMap() {
		Map<String, List<Character>> digitToCharMap = new HashMap<String, List<Character>>();
		digitToCharMap.put("0", Collections.emptyList());
		digitToCharMap.put("1", Collections.emptyList());
		digitToCharMap.put("2", Arrays.asList('A', 'B', 'C'));
		digitToCharMap.put("3", Arrays.asList('D', 'E', 'F'));
		digitToCharMap.put("4", Arrays.asList('G', 'H', 'I'));
		digitToCharMap.put("5", Arrays.asList('J', 'K', 'L'));
		digitToCharMap.put("6", Arrays.asList('M', 'N', 'O'));
		digitToCharMap.put("7", Arrays.asList('P', 'Q', 'R', 'S'));
		digitToCharMap.put("8", Arrays.asList('T', 'U', 'V'));
		digitToCharMap.put("9", Arrays.asList('W', 'X', 'Y', 'Z'));
		return digitToCharMap;
	}
	
	boolean hasMatch = false;
	private void backtrack(String combination, String prefix, String nextDigits) {
		if (nextDigits.isEmpty()) {
			if (prefix.isEmpty()) {
				matchedWords.add(combination.substring(1));
			} else {
				DictionarySearchResult dictResult = dict.contains(prefix);
				if (dictResult != null && dictResult.isEndOfWord()) {
					hasMatch = true;
					matchedWords.add((combination + HYPHEN + prefix).substring(1));
				}
			}
		} else {
			String firstDigit = nextDigits.substring(0, 1);
			List<Character> chars = digitToCharMap.get(firstDigit);
			for (int i = 0; i < chars.size(); i++) {
				String newPrefix = prefix + chars.get(i);
				DictionarySearchResult dictResult = dict.contains(newPrefix);
				if (dictResult == null) {
					continue;
				} else {
					if (dictResult.isEndOfWord()) {
						backtrack(combination + HYPHEN + newPrefix, EMPTY_STRING, nextDigits.substring(1));
					} else {
						backtrack(combination, newPrefix, nextDigits.substring(1));
					}
				}
			}
			
			// At root search
			if (prefix.isEmpty()) {
				if (!hasMatch) {
					// if there is no match for this position, try to add a digit
					if (combination.isEmpty() || !isNumber(combination.substring(combination.length()-1))) {
						backtrack(combination + HYPHEN + nextDigits.substring(0, 1), EMPTY_STRING, nextDigits.substring(1)); 
					}
				} else {
					// reset
					hasMatch = false;
				}
			}
		}
		
	}
	
	private boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
