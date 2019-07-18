package com.bgl.challenge.PhoneWord;

import java.util.List;

public class Dictionary {
	private LetterNode rootLetter;
	
	public Dictionary(List<String> words) {
		assert words != null;
		rootLetter = new LetterNode();
		words.forEach(word -> rootLetter.addWord(word));
	}
	
	public Result contains(String prefix) {
		if (prefix == null || prefix.isEmpty()) {
			return null;
		}
		
		LetterNode currentNode = rootLetter;
		for (int i=0; i < prefix.length(); i++) {
			LetterNode tempNode = currentNode.getChild(prefix.charAt(i));
			if (tempNode == null) {
				return null;
			}
			currentNode = tempNode;
		}
		
		return new Result(true, currentNode.isEndOfWord());
	}
}
