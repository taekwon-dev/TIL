package com.til.algorithm.baekjoon.bigstone.week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String item = null;
        while (!(item = br.readLine()).equals("end")) {
            boolean flag = true;
            char[] word = item.toCharArray();
            char prev = 'A';
            int vowel = 0;
            int consonant = 0;
            boolean containsVowel = false;
            for (int i = 0; i < word.length; i++) {
                if (isVowel(word[i])) {
                    containsVowel = true;
                    vowel++;
                    consonant = 0;
                } else {
                    consonant++;
                    vowel = 0;
                }
                if (prev == word[i] && (prev != 'e' && prev != 'o')) {
                    flag = false;
                    break;
                }
                prev = word[i];
                if (vowel == 3 || consonant == 3) {
                    flag = false;
                    break;
                }

                if (i == word.length - 1 && !containsVowel) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("<" + item + ">" + " is acceptable.");
                continue;
            }
            System.out.println("<" + item + ">" + " is not acceptable.");
        }
    }

    private static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}