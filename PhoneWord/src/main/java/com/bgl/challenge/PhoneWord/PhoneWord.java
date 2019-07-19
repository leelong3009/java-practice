package com.bgl.challenge.PhoneWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneWord {

	private Dictionary dict;
	private Map<Integer, List<Character>> digitToCharMap;
	private List<String> matchedWords;
	private StringBuilder oneMatchedWord;

	public PhoneWord(Dictionary dict) {
		this.dict = dict;
		this.digitToCharMap = initDigitToCharMap();
		this.matchedWords = new ArrayList<String>();
		this.oneMatchedWord = new StringBuilder();
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
		oneMatchedWord.setLength(0);
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
	
	private void backtrack(String prefix, String phoneNumber) {
		if (phoneNumber.length() == 0) {
			return;
		}
		String firstNumberStr = phoneNumber.substring(0, 1);
		String remainingNumber = phoneNumber.substring(1, phoneNumber.length());
		List<Character> charList = digitToCharMap.get(Integer.valueOf(firstNumberStr));
		
		int prevResultsSize = matchedWords.size();
		for (int i = 0; i < charList.size(); i++) {
			String newPrefix = prefix + charList.get(i);
			DictionarySearchResult dictResult = dict.contains(newPrefix);
			if (dictResult == null) {
				continue;
			} else {
				if (dictResult.isEndOfWord()) {
					oneMatchedWord.append("-").append(newPrefix);
					if (remainingNumber.length() > 0) {
						// start a new word looking
						backtrack("", remainingNumber);
					}
				} else {
					// continue looking for a complete word
					backtrack(newPrefix, remainingNumber);
				}
			}
			
			if (oneMatchedWord.length() > 0 && isAtLeaf(remainingNumber)) {
				matchedWords.add(oneMatchedWord.substring(1, oneMatchedWord.length()));
				oneMatchedWord.setLength(0);
			}
		}
			
		
		if ((isAtRoot(prefix) && isNoMatch(prevResultsSize)) || charList.isEmpty()) {
			if (isJustAddedANumber(oneMatchedWord)) {
				if (oneMatchedWord.length() > 0) {
					matchedWords.add(oneMatchedWord.substring(1, oneMatchedWord.length()));
					oneMatchedWord.setLength(0);
				}
			} else {
				if (isAtLeaf(remainingNumber)) {
					oneMatchedWord.append("-").append(firstNumberStr);
					matchedWords.add(oneMatchedWord.substring(1, oneMatchedWord.length()));
					oneMatchedWord.setLength(0);
				} else {
					oneMatchedWord.append("-").append(firstNumberStr);
					backtrack("", remainingNumber);
				}
				
				
			}
		}
//		if (isAtRoot(prefix) && isNoMatch(prevResultsSize) && !isJustAddedANumber(oneMatchedWord)) {
//			oneMatchedWord.append("-").append(firstNumberStr);
//			backtrack("", remainingNumber);
//		}
		
	}
	
	private boolean isNoMatch(int prevMatchedWordsSize) {
		return prevMatchedWordsSize == matchedWords.size() && oneMatchedWord.length()==0;
	}

	private boolean isAtRoot(String prefix) {
		return prefix.isEmpty();
	}

	private boolean isAtLeaf(String digit) {
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
