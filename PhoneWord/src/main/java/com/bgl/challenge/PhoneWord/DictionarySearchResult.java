package com.bgl.challenge.PhoneWord;

public class DictionarySearchResult {
	private boolean endOfWord;
	
	public DictionarySearchResult(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}
	
	public boolean isEndOfWord() {
		return endOfWord;
	}
}
