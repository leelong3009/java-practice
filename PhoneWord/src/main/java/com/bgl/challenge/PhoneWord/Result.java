package com.bgl.challenge.PhoneWord;

public class Result {
	private boolean contain;
	private boolean endOfWord;
	public static final Result NOT_EXISTING = new Result(false);
	
	private Result(boolean contain) {
		this.contain = contain;
	}
	
	public Result(boolean contain, boolean endOfWord) {
		this.contain = contain;
		this.endOfWord = endOfWord;
	}
	
	public boolean isContain() {
		return contain;
	}
	
	public boolean isEndOfWord() {
		return endOfWord;
	}
}
