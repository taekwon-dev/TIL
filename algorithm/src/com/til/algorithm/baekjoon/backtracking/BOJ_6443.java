package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_6443 {

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] word = br.readLine().toCharArray();
            Arrays.sort(word);
            visited = new boolean[word.length];
            backtracking(word, 0, "");
        }
    }

    private static void backtracking(char[] word, int depth, String s) {
        if (depth == word.length) {
            System.out.println(s);
            return;
        }
        int prev = 'A';
        for (int i = 0; i < word.length; i++) {
            if (!visited[i] && prev != word[i]) {
                prev = word[i];
                visited[i] = true;
                backtracking(word, depth + 1, s + word[i]);
                visited[i] = false;
             }
        }
    }
}
