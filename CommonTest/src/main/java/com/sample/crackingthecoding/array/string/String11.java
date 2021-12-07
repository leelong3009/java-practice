package com.sample.crackingthecoding.array.string;

import java.util.Arrays;

public class String11 {

	public static void main(String[] args) {
		System.out.println(isUnique("abcdeff"));
	}

	public static boolean isUnique(String str) {
		boolean[] allChars = new boolean[256];
		Arrays.fill(allChars, false);
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			int idx = (int) chars[i];
			if (allChars[idx])
				return false;
			allChars[idx] = true;
		}
		return true;
	}
}