package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.Arrays;

public class BOJ_6443 {

    private static int N;
    private static boolean[] visited;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] word = br.readLine().toCharArray();
            visited = new boolean[word.length];
            Arrays.sort(word);
            backtracking(word, 0, "");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(char[] word, int depth, String s) {
        if (depth == word.length) {
            answer.append(s).append("\n");
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