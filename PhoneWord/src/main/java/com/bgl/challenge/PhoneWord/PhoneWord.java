package com.bgl.challenge.PhoneWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class PhoneWord {

	private Dictionary dict;
	private Map<Integer, List<Character>> digitToCharMap;
	private List<String> matchedWords;
	private StringBuilder matchedRow;
	private String matchedWord;
	private String onlyNumberRegex;
	private static final String EMPTY_STRING = "";
	private static final String HYPHEN = "-";

	public PhoneWord(Dictionary dict) {
		this.dict = dict;
		this.digitToCharMap = initDigitToCharMap();
		this.matchedWords = new ArrayList<String>();
		this.matchedRow = new StringBuilder();
		this.matchedWord = null;
		this.onlyNumberRegex = "[0-9]";
	}

	/**
	 * Match phone number to words in the dictionary
	 * @param phoneNumber input phone number
	 * @return list of matched words
	 */
	public List<String> findAnyMatches(String phoneNumber) {
		reset();
		this.backtrack("", phoneNumber);
		return this.matchedWords;
	}
	
	private void reset() {
		matchedWords.clear();
		matchedRow.setLength(0);
	}
	
	private Map<Integer, List<Character>> initDigitToCharMap() {
		Map<Integer, List<Character>> digitToCharMap = new HashMap<Integer, List<Character>>();
		digitToCharMap.put(0, Collections.emptyList());
		digitToCharMap.put(1, Collections.emptyList());
		digitToCharMap.put(2, Arrays.asList('A', 'B', 'C'));
		digitToCharMap.put(3, Arrays.asList('D', 'E', 'F'));
		digitToCharMap.put(4, Arrays.asList('G', 'H', 'I'));
		digitToCharMap.put(5, Arrays.asList('J', 'K', 'L'));
		digitToCharMap.put(6, Arrays.asList('M', 'N', 'O'));
		digitToCharMap.put(7, Arrays.asList('P', 'Q', 'R', 'S'));
		digitToCharMap.put(8, Arrays.asList('T', 'U', 'V'));
		digitToCharMap.put(9, Arrays.asList('W', 'X', 'Y', 'Z'));
		return digitToCharMap;
	}
	
	private void backtrack(String prefixWord, String phoneNumber) {
		if (phoneNumber.length() == 0) {
			return;
		}
		
		String firstNumberStr = phoneNumber.substring(0, 1);
		String remainingNumber = phoneNumber.substring(1, phoneNumber.length());
		List<Character> charList = digitToCharMap.get(Integer.valueOf(firstNumberStr));
		
		if (isAtRootLoop(prefixWord)) {
			matchedWord = null;
		}
		
		for (int i = 0; i < charList.size(); i++) {
			String newPrefixWord = prefixWord + charList.get(i);
			DictionarySearchResult dictResult = dict.contains(newPrefixWord);
			if (dictResult == null) {
				continue;
			} else {
				if (dictResult.isEndOfWord()) {
					matchedWord = newPrefixWord;
					matchedRow.append(HYPHEN).append(matchedWord);
					if (remainingNumber.length() > 0) {
						// start a new word looking
						backtrack(EMPTY_STRING, remainingNumber);
					}
				} else {
					// continue looking for a complete word
					if (remainingNumber.length() > 0) {
						backtrack(newPrefixWord, remainingNumber);
					} else {
						continue;
					}
				}
			}
			
			if (isAtLastNumber(remainingNumber) && matchedRow.length() > 0) {
				addMatchedRow(matchedRow.substring(1, matchedRow.length()));
				matchedRow.setLength(0);
			}
		}
			
		// After finishing all searches from the position of the first number,
		// check if there's no match or this number is 0/1
		if ((isAtRootLoop(prefixWord) && hasNoMatch()) || charList.isEmpty()) {
			if (isJustAddedANumber(matchedRow)) {
				addMatchedRow(matchedRow.substring(1, matchedRow.length()));
				matchedRow.setLength(0);
			} else {
				if (isAtLastNumber(remainingNumber)) {
					if (matchedRow.length() > 0) {
						matchedRow.append(HYPHEN).append(firstNumberStr);
						addMatchedRow(matchedRow.substring(1, matchedRow.length()));
						matchedRow.setLength(0);
					}
				} else {
					matchedRow.append(HYPHEN).append(firstNumberStr);
					backtrack(EMPTY_STRING, remainingNumber);
				}
			}
		}
	}
	
	private void addMatchedRow(String word) {
		if (!Pattern.matches(onlyNumberRegex, word)) {
			matchedWords.add(word);
		}
	}
	
	private boolean hasNoMatch() {
		return matchedWord == null;
	}

	private boolean isAtRootLoop(String prefix) {
		return prefix.isEmpty();
	}

	private boolean isAtLastNumber(String digit) {
		return digit.isEmpty();
	}

	private boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	private boolean isJustAddedANumber(StringBuilder word) {
		if (word.length() > 0) {
			String lastLetter = word.substring(word.length() - 1, word.length());
			return isNumber(lastLetter);
		} else {
			return false;
		}
	}
}