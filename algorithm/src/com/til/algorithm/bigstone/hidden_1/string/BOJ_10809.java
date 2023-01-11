package com.til.algorithm.bigstone.hidden_1.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10809 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] word = new int[26];
        Arrays.fill(word, -1);
        int index = 0;
        for (char c : input.toCharArray()) {
            if (word[c - 'a'] == -1) {
                word[c - 'a'] = index;
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : word) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}