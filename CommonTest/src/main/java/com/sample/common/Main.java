package com.sample.common;

public class Main {

	public static void main(String[] args) {
		String regex = "[\\s.,?!'\":;\\-\\(\\)\\[\\]]+";
		System.out.println("333".replaceAll(regex, ""));
	}

	public static String longestCommonPrefix(String[] strs) {
        StringBuilder s = new StringBuilder("");
        int idx = 0;
        boolean flag = true;
        if (strs.length < 1) return "";
        if (strs.length == 1) return strs[0];
        while(flag) {
        	for (int i=0; i<strs.length-1; i++) {
        		if(strs[i].length() <= idx || strs[i+1].length() <= idx || strs[i].charAt(idx) != strs[i+1].charAt(idx)) {
        			flag = false;
        			break;
        		}
        	}
        	if (flag) s.append(strs[0].charAt(idx));
        	idx++;
        }
    	
        return s.toString();
    }
}
