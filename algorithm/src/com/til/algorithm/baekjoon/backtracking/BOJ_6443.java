package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_6443 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[] word = null;
        boolean[] visited = null;
        for (int i = 0; i < n; i++) {
            word = br.readLine().toCharArray();
            visited = new boolean[word.length];
            Arrays.sort(word);
            backtracking(word, visited, 0, "");
        }
    }

    private static void backtracking(char[] word, boolean[] visited, int depth, String s) {
        if (depth == word.length) {
            System.out.println(s);
            return;
        }
        int prev = 'A';
        for (int i = 0; i < word.length; i++) {
            if (!visited[i] && prev != word[i]) {
                prev = word[i];
                visited[i] = true;
                backtracking(word, visited, depth + 1, s + word[i]);
                visited[i] = false;
            }
        }
    }
}