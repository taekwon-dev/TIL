package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.Arrays;

public class BOJ_6443 {

    private static char[] word;
    private static boolean[] visited;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            word = br.readLine().toCharArray();
            Arrays.sort(word);
            visited = new boolean[word.length];
            backtracking(0, "");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, String s) {
        if (depth == word.length) {
            answer.append(s).append("\n");
            return;
        }
        char prev = 'A';
        for (int i = 0; i < word.length; i++) {
            if (!visited[i] && prev != word[i]) {
                prev = word[i];
                visited[i] = true;
                backtracking(depth + 1, s + word[i]);
                visited[i] = false;
            }
        }
    }
}
