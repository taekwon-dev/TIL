package com.til.algorithm.bigstone.hidden_1.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();
        int[] count = new int[26];
        int max = 0;
        for (int i = 0; i < word.length(); i++) {
            max = Math.max(max, ++count[word.charAt(i) - 'A']);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                sb.append((char) (i + 'A'));
            }
        }
        if (sb.length() > 1) {
            System.out.println("?");
            return;
        }
        System.out.println(sb.toString());
    }
}