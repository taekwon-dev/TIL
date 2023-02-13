package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1062 {

    private static int N;
    private static int K;
    private static boolean[] visited;
    private static String[] words;
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
            words = new String[N];
            for (int i = 0; i < N; i++) {
                words[i] = br.readLine();
            }

            visited = new boolean[26];
            visited['a' - 'a'] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['c' - 'a'] = true;

            backtracking(0);

            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth) {
        if (depth == K - 5) {
            answer = Math.max(answer, getReadableCount());
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int getReadableCount() {
        int count = words.length;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!visited[word.charAt(i) - 'a']) {
                     count--;
                     break;
                }
            }
        }
        return count;
    }
}