package com.til.algorithm.baekjoon.bigstone.week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1159 {

    private static int[] familyName = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            familyName[name.charAt(0) - 'a']++;
        }
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (familyName[i] >= 5) {
                flag = true;
                sb.append((char) (i + 97));
            }
        }
        if (!flag) {
            System.out.println("PREDAJA");
            return;
        }
        System.out.println(sb.toString());
    }
}