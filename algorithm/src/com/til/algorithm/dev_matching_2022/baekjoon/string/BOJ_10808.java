package com.til.algorithm.dev_matching_2022.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Youn on 2022/06/24.
 * Title : 알파벳 개수 (https://www.acmicpc.net/problem/10808)
 * Hint  :
 */
public class BOJ_10808 {
    public static void main(String[] args) throws IOException {
        int[] lowercase = new int[26];
        Arrays.fill(lowercase, 0);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            lowercase[input.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < lowercase.length; i++) {
            System.out.print(lowercase[i] + " ");
        }
    }
}
