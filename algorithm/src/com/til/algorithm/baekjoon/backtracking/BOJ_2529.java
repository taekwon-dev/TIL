package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2529 {

    private static int K;
    private static char[] sign;
    private static boolean[] visited;
    private static ArrayList<String> candidates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        sign = new char[K];
        visited = new boolean[10];
        candidates = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            sign[i] = st.nextToken().charAt(0);
        }
        backtracking(0, "");

        bw.write(Collections.max(candidates) + "\n");
        bw.write(Collections.min(candidates) + "\n");
        bw.close();
        br.close();
    }

    private static void backtracking(int idx, String num) {
        if (idx == K + 1) {
            // K개의 부등호 -> K + 1개의 수
            candidates.add(num);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            // 가장 마지막 수 vs 새로 넣을 수 비교
            if (idx == 0 || isLocatable(sign[idx - 1], num.charAt(num.length() - 1) - '0', i)) {
                if (!visited[i]) {
                    visited[i] = true;
                    backtracking(idx + 1, num + i);
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean isLocatable(char sign, int former, int latter) {
        if (sign == '>') {
            return former > latter;
        }
        return former < latter;
    }
}