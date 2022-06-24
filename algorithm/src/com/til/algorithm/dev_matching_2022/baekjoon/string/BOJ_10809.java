package com.til.algorithm.dev_matching_2022.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Youn on 2022/06/24.
 * Title : 알파벳 찾기 (https://www.acmicpc.net/problem/10809)
 * Hint  : a - z (26)
 */
public class BOJ_10809 {

    public static void main(String[] args) throws IOException {
        int[] lowercase = new int[26];
        Arrays.fill(lowercase, -1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            if (lowercase[input.charAt(i) - 'a'] == -1) {
                lowercase[input.charAt(i) - 'a'] = i;
            }
        }
        for (int i = 0; i < lowercase.length; i++) {
            System.out.print(lowercase[i] + " ");
        }
    }
}
