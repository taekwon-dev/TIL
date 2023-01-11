package com.til.algorithm.bigstone.week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10808 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] alphabet = new int[26];
        for (char c : word.toCharArray()) {
            alphabet[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(alphabet[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}