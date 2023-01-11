package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_10988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        bw.write(isPalindrome(word) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int isPalindrome(String word) {
        int len = word.length();
        int left = 0;
        int right = len - 1;
        for (int i = 0; i < len / 2; i++) {
            if (word.charAt(left) != word.charAt(right)) {
                return 0;
            }
            left++;
            right--;
        }
        return 1;
    }
}