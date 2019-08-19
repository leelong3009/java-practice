package com.bgl.challenge.PhoneWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PhoneWord {

	private Dictionary dict;
	private Map<String, String> digitToCharMap;
	private List<String> matchedWords;
	private StringBuilder matchedRow;
	private static final String EMPTY_STRING = "";
	private static final String HYPHEN = "-";
	
	private Consumer<String> searchAndPrintWordConsumer = number -> {
		findWordMatches(number);
		printResult(number, matchedWords);
	};
	
	private Predicate<String> onlyNumberPredicate = number -> number.matches("\\d+");
	
	public PhoneWord(Dictionary dict) {
		this.dict = dict;
		digitToCharMap = createDigitToCharMap();
		matchedWords = new ArrayList<String>();
		matchedRow = new StringBuilder();
	}

	/**
	 * Read phone numbers from a file, then search and print all word matches
	 * @param filePath
	 */
	public void searchAndPrintMatchedWordsFromFile(String filePath) {
		List<String> phonenumbers = Util.readFile(filePath);
		phonenumbers.stream().filter(onlyNumberPredicate).forEach(searchAndPrintWordConsumer);
	}
	
	/**
	 * Read phone numbers from a input string, then search and print all word matches
	 * @param words
	 */
	public void searchAndPrintMatchedWordsFromInput(String phoneNumber) {
		String filteredPhoneNumber = Util.removePunctuation(phoneNumber);
		if (onlyNumberPredicate.test(filteredPhoneNumber)) {
			searchAndPrintWordConsumer.accept(filteredPhoneNumber);
		};
	}
	
	private void printResult(String number, List<String> matchedWords) {
		System.out.println("Matched words of phone number \"" + number + "\":");
		if (matchedWords.isEmpty()) {
			System.out.println("-- empty --");
		} else {
			matchedWords.forEach(System.out::println);
		}
	}
	
	/**
	 * Match phone number to words in the dictionary
	 * @param phoneNumber input phone number
	 * @return list of matched words
	 */
	public void findWordMatches(String phoneNumber) {
		reset();
		if (phoneNumber != null && !phoneNumber.isEmpty()) {
			backtrack(EMPTY_STRING, EMPTY_STRING, phoneNumber);
		}
	}
	
	private void reset() {
		matchedWords.clear();
		matchedRow.setLength(0);
	}
	
	private Map<String, String> createDigitToCharMap() {
		Map<String, String> digitToCharMap = new HashMap<String, String>(10);
		digitToCharMap.put("2", "ABC");
		digitToCharMap.put("3", "DEF");
		digitToCharMap.put("4", "GHI");
		digitToCharMap.put("5", "JKL");
		digitToCharMap.put("6", "MNO");
		digitToCharMap.put("7", "PQRS");
		digitToCharMap.put("8", "TUV");
		digitToCharMap.put("9", "XWYZ");
		return digitToCharMap;
	}
	
	boolean hasWordMatch = false;
	private void backtrack(String combinedWords, String prefix, String nextDigits) {
		if (nextDigits.isEmpty()) {
			// when there is no digits to proceed
			if (prefix.isEmpty()) {
				matchedWords.add(combinedWords.substring(1));
			} else {
				DictionarySearchResult dictResult = dict.contains(prefix);
				if (dictResult != null && dictResult.isEndOfWord()) {
					hasWordMatch = true;
					matchedWords.add((combinedWords + HYPHEN + prefix).substring(1));
				}
			}
		} else {
			String firstDigit = nextDigits.substring(0, 1);
			String chars = digitToCharMap.get(firstDigit);
			if (chars != null) {
				for (int i = 0; i < chars.length(); i++) {
					String newPrefix = prefix + chars.charAt(i);
					DictionarySearchResult dictResult = dict.contains(newPrefix);
					if (dictResult == null) {
						continue;
					} else {
						if (dictResult.isEndOfWord()) {
							backtrack(combinedWords + HYPHEN + newPrefix, EMPTY_STRING, nextDigits.substring(1));
						} else {
							backtrack(combinedWords, newPrefix, nextDigits.substring(1));
						}
					}
				}
			}
			
			// At root search
			if (prefix.isEmpty()) {
				if (!hasWordMatch) {
					// if there is no match for this position, try to add a digit
					if (combinedWords.isEmpty() || !isNumber(combinedWords.substring(combinedWords.length()-1))) {
						backtrack(combinedWords + HYPHEN + nextDigits.substring(0, 1), EMPTY_STRING, nextDigits.substring(1)); 
					}
				} else {
					// reset
					hasWordMatch = false;
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

	public List<String> getMatchedWords() {
		return matchedWords;
	}
	
}
