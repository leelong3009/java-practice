package com.sample.algorithm.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberToLetters {
    static Map<String, String> phoneMap = new HashMap<String, String>() {
        {
            put("1", "");
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        };
    };

    public static void main(String[] args) {
        backtrack("", "23");
        System.out.println(results.toString());
    }

    static List<String> results = new ArrayList<String>();

    public static void backtrack(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            results.add(combination);
        } else {
            String firstNumber = nextDigits.substring(0, 1);
            char[] chars = phoneMap.get(firstNumber).toCharArray();
            for (char c : chars) {
                backtrack(combination + c, nextDigits.substring(1));
            }
        }
    }
}
