package com.sample.crackingthecoding;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        System.out.println(isUnique("abcdfa"));
    }

    public static boolean isUnique(String s) {
        boolean[] matrix = new boolean[128];
        Arrays.fill(matrix, false);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (matrix[c]) {
                return false;
            } else {
                matrix[c] = true;
            }
        }
        return true;
    }
}
