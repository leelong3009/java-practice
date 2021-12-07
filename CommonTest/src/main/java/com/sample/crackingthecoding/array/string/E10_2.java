package com.sample.crackingthecoding.array.string;

import java.util.Arrays;

import com.sample.crackingthecoding.lib.Util;

public class E10_2 {

	public static void main(String[] args) {
		Util.printArray(sort(new String[] {"abc", "dec", "ed", "cab", "ced"}));
	}
	
	public static String[] sort(String[] strs) {
		Arrays.sort(strs, (s1, s2) -> sortString(s1).compareTo(sortString(s2)));
		return strs;
	}
	
	public static boolean isAnagram(String s1, String s2) {
		int[] allChars = new int[128];
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		if (c1.length != c2.length) {
			return false;
		}
		
		for(int i=0; i<c1.length; i++) {
			int code = (int)c1[i];
			allChars[code]++;
		}
		
		for (int i = 0; i < c2.length; i++) {
			int code = (int)c2[i];
			allChars[code]--;
			if(allChars[code] < 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static String sortString(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	public static boolean isAnagram2(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		String sortedS1 = new String(c1);
		String sortedS2 = new String(c2);
		return sortedS1.compareTo(sortedS2) == 0;
	}
}
