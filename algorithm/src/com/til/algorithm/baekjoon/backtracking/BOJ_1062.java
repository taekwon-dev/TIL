package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1062 {

    private static int N;
    private static int K;
    private static String[] words;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            bw.write(0 + "\n");
        } else {
            visited = new boolean[26];
            visited['a' - 'a'] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['c' - 'a'] = true;

            words = new String[N];
            for (int i = 0; i < N; i++) {
                words[i] = br.readLine();
            }
            backtracking(0, 0);
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int start) {
        if (depth == K - 5) {
            answer = Math.max(answer, countReadableWord());
            return;
        }
        for (int i = start; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static int countReadableWord() {
        int count = 0;
        for (String word : words) {
            boolean flag = false;
            for (char c : word.toCharArray()) {
                if (!visited[c - 'a']) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
        }
        return count;
    }
}