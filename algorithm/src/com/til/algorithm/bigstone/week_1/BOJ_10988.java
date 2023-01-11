package com.til.algorithm.bigstone.week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        if (isPalindrome(word)) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

    private static boolean isPalindrome(String word) {
        String former = null;
        String latter = null;
        if (word.length() % 2 == 0) {
            former = word.substring(0, word.length() / 2);
            latter = word.substring(word.length() / 2);
        }
        if (word.length() % 2 != 0) {
            former = word.substring(0, word.length() / 2);
            latter = word.substring(word.length() / 2 + 1);
        }
        return former.equals(reverseString(latter));
    }

    private static String reverseString(String latter) {
        return new StringBuilder(latter).reverse().toString();
    }
}