package com.sample.algorithm.problem;

public class Palindromatic {
    public static void main(String[] args) {
        System.out.println(isPalindrome("a"));
    }

    public static String longestPalindrome(String s) {
        abadda
    }

    public static boolean isPalindrome(String s) {
        int length = s.length();
        int middle = length / 2;
        for (int i = 0; i <= middle; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
