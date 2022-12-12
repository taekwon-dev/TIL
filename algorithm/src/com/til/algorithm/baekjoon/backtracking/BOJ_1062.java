package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1062 {

    private static int n;
    private static int k;
    private static String[] word;
    private static boolean[] visited = new boolean[26];
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        word = new String[n];

        if (k < 5) {
            System.out.println(0);
            return;
        }
        if (k == 26) {
            System.out.println(n);
            return;
        }

        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;
        backtracking(0, 0);
        System.out.println(max);
    }

    private static void backtracking(int depth, int index) {
        if (depth == k - 5) {
            max = Math.max(max, countReadableWord());
            return;
        }
        for (int i = index; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static int countReadableWord() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (char c : word[i].toCharArray()) {
                if (!visited[c - 'a']) {
                    count++;
                    break;
                }
            }
        }
        return n - count;
    }
}