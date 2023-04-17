package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_6443 {

    private static int N;
    private static char[] c;
    private static boolean[] used;
    private static ArrayList<String> anagrams;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            c = br.readLine().toCharArray();
            used = new boolean[c.length];
            anagrams = new ArrayList<>();
            Arrays.sort(c);
            backtracking(0, "");

            for (String anagram : anagrams) {
                bw.write(anagram + "\n");
            }
            bw.flush();
        }

        bw.close();
        br.close();
    }

    private static void backtracking(int depth, String anagram) {
        if (depth == c.length) {
            anagrams.add(anagram);
            return;
        }
        char prev = 'A';
        for (int i = 0; i < c.length; i++) {
            if (!used[i] && prev != c[i]) {
                prev = c[i];
                used[i] = true;
                backtracking(depth + 1, anagram + c[i]);
                used[i] = false;
            }
        }
    }
}