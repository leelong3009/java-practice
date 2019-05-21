package com.sample.crackingthecoding;

public class Exp12 {

	public static void main(String[] args) {
		purmutation("abcdef");
	}
	
	public static void purmutation(String str) {
		permuatation(str, "");
	}
	
	public static void permuatation(String str, String prefix) {
		if (str.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int i=0; i<str.length(); i++) {
				String rem = str.substring(0, i) + str.substring(i + 1);
				permuatation(rem, prefix + str.charAt(i));
			}
		}
	}

}