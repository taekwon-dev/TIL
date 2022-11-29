package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_6443 {

    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            char[] word = words[i].toCharArray();
            visited = new boolean[word.length];
            Arrays.sort(word);
            backtracking(word, 0, "");
            System.out.print(sb.toString());
        }
    }

    private static void backtracking(char[] word, int depth, String s) {
        if (depth == word.length) {
            sb.append(s).append("\n");
            return;
        }
        char prev = 'A';
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
