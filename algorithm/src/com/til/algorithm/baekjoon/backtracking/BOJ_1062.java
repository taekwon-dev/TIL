package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  백트랙킹 + 조합
 */
public class BOJ_1062 {

    private static int N;
    private static int K;
    private static String[] words;
    private static boolean[] visited;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            bw.write("0" + "\n");
            bw.flush();
        } else {
            words = new String[N];
            visited = new boolean[26];

            for (int i = 0; i < N; i++) {
                words[i] = br.readLine();
            }
            visited['a' - 'a'] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['c' - 'a'] = true;
            backtracking(0, 0);

            bw.write(max + "\n");
            bw.flush();
        }

        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int index) {
        if (depth == K - 5) {
            max = Math.max(max, findMax());
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

    private static int findMax() {
        int count = 0;
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (!visited[word.charAt(i) - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}