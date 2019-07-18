package com.bgl.challenge.PhoneWord;

import java.util.HashMap;
import java.util.Map;

public class LetterNode {
	private char letter;
	private Map<Character, LetterNode> children;
	private boolean endOfWord;
	
	public LetterNode() {
		children = new HashMap<Character, LetterNode>();
	}
	
	public LetterNode(char letter) {
		this();
		this.letter = letter;
	}

	public char getLetter() {
		return letter;
	}
	
	public void addWord(String word) {
		if (word != null && !word.isEmpty()) {
			char firstChar = word.charAt(0);
			LetterNode firstChildLetterNode = getChild(firstChar);
			if (firstChildLetterNode == null) {
				firstChildLetterNode = new LetterNode(firstChar);
				children.put(firstChar, firstChildLetterNode);
			}
			
			if (word.length() > 1) {
				firstChildLetterNode.addWord(word.substring(1));
			} else {
				firstChildLetterNode.setEndOfWord(true);
			}
		}
	}

	public boolean isEndOfWord() {
		return endOfWord;
	}

	public void setEndOfWord(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}

	public Map<Character, LetterNode> getChildren() {
		return children;
	}
	
	public LetterNode getChild(char c) {
		return children.get(c);
	}
}
