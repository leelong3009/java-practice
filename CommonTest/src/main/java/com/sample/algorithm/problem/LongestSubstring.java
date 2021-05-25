package com.sample.algorithm.problem;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        int a = lengthOfLongestSubstring("abcab");
        System.out.println(a);
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> charSet = new HashSet<Character>();

        while (right < s.length()) {
            if (charSet.contains(chars[right])) {
                max = Math.max(max, right - left);
                left++;
                right = left;
                charSet.clear();
            } else {
                charSet.add(chars[right]);
                right++;
                if (right == s.length()) {
                    max = Math.max(max, right - left);
                }
            }
        }
        return max;
    }
}
