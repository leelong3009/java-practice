package com.sample.crackingthecoding;
import java.util.Arrays;

public class String12 {

	public static void main(String[] args) {
		String s1 = "abcdeabc";
		String s2 = "aabbccda";
		System.out.println(isPermutation(s1, s2));
	}
	
	public static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		} else {
			char[] arr1 = s1.toCharArray(); 
			char[] arr2 = s2.toCharArray();
//			O(nlog(n))
			Arrays.sort(arr1);
			Arrays.sort(arr2);
//			O(n)
			for (int i=0; i<arr1.length; i++) {
				if (arr1[i] != arr2[i]) return false;
			}
			return true;
		}
	}

}