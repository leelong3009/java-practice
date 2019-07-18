package com.sample.crackingthecoding;

public class Exc16 {

	public static void main(String[] args) {
		System.out.println(compressString("aabbbcddda"));
	}

	private static String compressString(String s) {
		char[] chars = s.toCharArray();
		StringBuilder builder = new StringBuilder();
		int count=1;
		for (int i=0; i<chars.length; i++) {
			if (i < chars.length -1 && chars[i] == chars[i+1]) {
				count++;
			} else {
				builder.append(chars[i]).append(count);
				count = 1;
			}
		}
		return builder.toString();
	}
}
