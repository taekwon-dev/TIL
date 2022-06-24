package com.til.algorithm.dev_matching_2022.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Youn on 2022/06/24.
 * Title : 대소문자 바꾸기 (https://www.acmicpc.net/problem/2744)
 * Hint  : a (97) -> A (65), Character.isUpperCase(), Character.isLowerCase(), String.toLowerCase(), String.toUpperCase()
 */
public class BOJ_2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                System.out.print(String.valueOf(c).toLowerCase());
            } else {
                System.out.print(String.valueOf(c).toUpperCase());
            }
        }
    }
}
