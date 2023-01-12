package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_1259 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while (!(input = br.readLine()).equals("0")) {
            bw.write(isPalindrome(input) + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static String isPalindrome(String input) {
        int len = input.length();
        for (int i = 0; i < len / 2; i++) {
            if (input.charAt(i) != input.charAt(len - 1 - i)) {
                return "no";
            }
        }
        return "yes";
    }
}