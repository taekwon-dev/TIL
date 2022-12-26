package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_6443 {

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            String target = br.readLine();
            visited = new boolean[target.length()];
            char[] word = target.toCharArray();
            Arrays.sort(word);
            backtracking(word, 0, "");
        }
    }

    private static void backtracking(char[] word, int depth, String anagram) {
        if (depth == word.length) {
            System.out.println(anagram);
            return;
        }
        char prev = 'A';
        for (int i = 0; i < word.length; i++) {
            if (!visited[i] && prev != word[i]) {
                prev = word[i];
                visited[i] = true;
                backtracking(word, depth + 1, anagram + word[i]);
                visited[i] = false;
            }
        }
    }
}